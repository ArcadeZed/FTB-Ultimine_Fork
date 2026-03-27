package dev.ftb.mods.ftbultimine;

import dev.ftb.mods.ftbultimine.api.restriction.RestrictionHandler;
import dev.ftb.mods.ftbultimine.api.util.CanUltimineResult;
import net.minecraft.world.entity.player.Player;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

public class RestrictionHandlerRegistry {
	private static final RestrictionHandlerRegistry CLIENT_INSTANCE = new RestrictionHandlerRegistry();
	private static final RestrictionHandlerRegistry SERVER_INSTANCE = new RestrictionHandlerRegistry();

	private final Collection<RestrictionHandler> handlers = new CopyOnWriteArrayList<>();

	public static RestrictionHandlerRegistry getInstance(boolean clientSide) {
		return clientSide ? CLIENT_INSTANCE : SERVER_INSTANCE;
	}

	public void register(RestrictionHandler handler) {
		handlers.add(handler);
	}

	public CanUltimineResult canUltimine(Player player) {
		for (RestrictionHandler handler : handlers) {
			if (!handler.canUltimine(player)) {
				return handler.ultimineBlockReason(player);
			}
		}
        return CanUltimineResult.ALLOWED;
	}
}

package dev.ftb.mods.ftbultimine.fabric;

import dev.ftb.mods.ftblibrary.util.fabric.FabricEventHelper;
import dev.ftb.mods.ftbultimine.FTBUltimine;
import dev.ftb.mods.ftbultimine.FTBUltimineCommands;
import dev.ftb.mods.ftbultimine.api.blockbreaking.RegisterBlockBreakHandlerEvent;
import dev.ftb.mods.ftbultimine.api.blockselection.RegisterBlockSelectionHandlerEvent;
import dev.ftb.mods.ftbultimine.api.crop.RegisterCropLikeEvent;
import dev.ftb.mods.ftbultimine.api.fabric.FTBUltimineEvents;
import dev.ftb.mods.ftbultimine.api.restriction.RegisterRestrictionHandlerEvent;
import dev.ftb.mods.ftbultimine.api.rightclick.RegisterRightClickHandlerEvent;
import dev.ftb.mods.ftbultimine.api.shape.RegisterShapeEvent;
import dev.ftb.mods.ftbultimine.integration.FabricIntegration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.BlockEvents;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;

public class FTBUltimineFabric implements ModInitializer {
	private FTBUltimine ultimine;

	@Override
	public void onInitialize() {
		ultimine = new FTBUltimine();

		ServerPlayerEvents.JOIN.register(ultimine::playerJoined);
		ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            ultimine.serverStarting(server);
            FTBUltimine.commonSetup(false);
        });
		ServerLifecycleEvents.SERVER_STOPPING.register(ultimine::serverStopping);
		ServerTickEvents.END_SERVER_TICK.register(ultimine::serverTick);
		PlayerBlockBreakEvents.BEFORE.register((level, player, blockPos, blockState, _) ->
				!(player instanceof ServerPlayer sp) || !ultimine.handleBlockBreak(level, blockPos, blockState, sp));
		BlockEvents.USE_ITEM_ON.register((_, _, _, blockPos, player, hand, _) -> {
				InteractionResult result = ultimine.blockRightClick(player, hand, blockPos);
				return result.consumesAction() ? result : null;
			});
		CommandRegistrationCallback.EVENT.register(FTBUltimineCommands::registerCommands);
		// see PlayerMixin & PersistentEntitySectionManagerMixin for handling player tick & entity join "events"

		FTBUltimineEvents.REGISTER_RIGHT_CLICK_HANDLER.register(event -> ultimine.registerBuiltinRightClickHandlers(event));
		FTBUltimineEvents.REGISTER_SHAPE.register(event -> ultimine.registerBuiltinShapes(event));
		FTBUltimineEvents.REGISTER_CROP_LIKE.register(event -> ultimine.registerBuiltinCropHandlers(event));

		registerFabricEventPosters();

		FabricIntegration.init();
	}

	private static void registerFabricEventPosters() {
		FabricEventHelper.registerFabricEventPoster(RegisterRightClickHandlerEvent.Data.class, FTBUltimineEvents.REGISTER_RIGHT_CLICK_HANDLER);
		FabricEventHelper.registerFabricEventPoster(RegisterShapeEvent.Data.class, FTBUltimineEvents.REGISTER_SHAPE);
		FabricEventHelper.registerFabricEventPoster(RegisterCropLikeEvent.Data.class, FTBUltimineEvents.REGISTER_CROP_LIKE);
		FabricEventHelper.registerFabricEventPoster(RegisterRestrictionHandlerEvent.Data.class, FTBUltimineEvents.REGISTER_RESTRICTION_HANDLER);
		FabricEventHelper.registerFabricEventPoster(RegisterBlockBreakHandlerEvent.Data.class, FTBUltimineEvents.REGISTER_BLOCK_BREAK_HANDLER);
		FabricEventHelper.registerFabricEventPoster(RegisterBlockSelectionHandlerEvent.Data.class, FTBUltimineEvents.REGISTER_BLOCK_SELECTION_HANDLER);
	}
}

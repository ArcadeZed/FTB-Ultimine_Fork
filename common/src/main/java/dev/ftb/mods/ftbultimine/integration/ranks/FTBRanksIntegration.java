package dev.ftb.mods.ftbultimine.integration.ranks;

import dev.ftb.mods.ftblibrary.platform.network.Server2PlayNetworking;
import dev.ftb.mods.ftbranks.api.FTBRanksAPI;
import dev.ftb.mods.ftbranks.api.RankManager;
import dev.ftb.mods.ftbultimine.FTBUltimine;
import dev.ftb.mods.ftbultimine.config.FTBUltimineServerConfig;
import dev.ftb.mods.ftbultimine.net.SyncUltimineTimePacket;
import dev.ftb.mods.ftbultimine.net.SyncUltimineTimePacket.TimeType;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.NameAndId;

public class FTBRanksIntegration {
    private static final String MAX_BLOCKS_PERM = "ftbultimine.max_blocks";
    private static final String COOLDOWN_PERM = "ftbultimine.ultimine_cooldown";
    private static final String EXPERIENCE_COST_PERM = "ftbultimine.experience_per_block";
    private static final String EXHAUSTION_MULTIPLIER_PERM = "ftbultimine.exhaustion_per_block";

    public static void updatePlayer(RankManager manager, NameAndId player) {
        ServerPlayer sp = manager.getServer().getPlayerList().getPlayer(player.id());
        if (sp != null) {
            Server2PlayNetworking.send(sp, new SyncUltimineTimePacket(FTBUltimineServerConfig.getUltimineCooldown(sp), TimeType.COOLDOWN));
        }
    }

    public static void updateAllPlayers(RankManager manager) {
        manager.getServer().getPlayerList().getPlayers().forEach(sp ->
                Server2PlayNetworking.send(sp, new SyncUltimineTimePacket(FTBUltimineServerConfig.getUltimineCooldown(sp), TimeType.COOLDOWN))
        );
    }

    public static int getMaxBlocks(ServerPlayer player, int defMax) {
        return FTBRanksAPI.getPermissionValue(player, MAX_BLOCKS_PERM).asInteger().orElse(defMax);
    }

    public static long getUltimineCooldown(ServerPlayer player, long defCooldown) {
        return FTBRanksAPI.getPermissionValue(player, COOLDOWN_PERM).asLong().orElse(defCooldown);
    }

    public static double getExperiencePerBlock(ServerPlayer player) {
        return FTBRanksAPI.getPermissionValue(player, EXPERIENCE_COST_PERM).asDouble()
                .orElse(FTBUltimineServerConfig.EXPERIENCE_PER_BLOCK.get());
    }

    public static double getExhaustionPerBlock(ServerPlayer player) {
        return FTBRanksAPI.getPermissionValue(player, EXHAUSTION_MULTIPLIER_PERM).asDouble()
                .orElse(FTBUltimineServerConfig.EXHAUSTION_PER_BLOCK.get());
    }
}

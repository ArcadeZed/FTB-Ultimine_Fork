package dev.ftb.mods.ftbultimine.integration.ftbranks.fabric;

import dev.ftb.mods.ftbranks.api.fabric.FTBRanksEvents;
import dev.ftb.mods.ftbultimine.FTBUltimine;
import dev.ftb.mods.ftbultimine.integration.IntegrationHandler;
import dev.ftb.mods.ftbultimine.integration.ranks.FTBRanksIntegration;

public class FTBRanksFabricIntegration {
    public static void init() {
        IntegrationHandler.ftbRanksLoaded = true;

        FTBRanksEvents.PLAYER_ADDED_TO_RANK.register(event ->
                FTBRanksIntegration.updatePlayer(event.manager(), event.player()));
        FTBRanksEvents.PLAYER_REMOVED_FROM_RANK.register(event ->
                FTBRanksIntegration.updatePlayer(event.manager(), event.player()));

        FTBRanksEvents.PERMISSION_NODE_CHANGED.register(event ->
                FTBRanksIntegration.updateAllPlayers(event.manager()));
        FTBRanksEvents.RANK_RELOADED.register(event ->
                FTBRanksIntegration.updateAllPlayers(event.manager()));
        FTBRanksEvents.CONDITION_CHANGED.register(event ->
                FTBRanksIntegration.updateAllPlayers(event.manager()));

        FTBUltimine.LOGGER.info("FTB Ranks detected, listening for ranks events");
    }
}

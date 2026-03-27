package dev.ftb.mods.ftbultimine.integration.ftbranks.neoforge;

import dev.ftb.mods.ftbranks.api.neoforge.FTBRanksEvent;
import dev.ftb.mods.ftbultimine.FTBUltimine;
import dev.ftb.mods.ftbultimine.integration.IntegrationHandler;
import dev.ftb.mods.ftbultimine.integration.ranks.FTBRanksIntegration;
import net.neoforged.bus.api.IEventBus;

public class FTBRanksNeoIntegration {
    public static void init(IEventBus bus) {
        IntegrationHandler.ftbRanksLoaded = true;

        bus.addListener(FTBRanksEvent.PlayerAdded.class,
                event -> FTBRanksIntegration.updatePlayer(event.getEventData().manager(), event.getEventData().player()));
        bus.addListener(FTBRanksEvent.PlayerRemoved.class,
                event -> FTBRanksIntegration.updatePlayer(event.getEventData().manager(), event.getEventData().player()));
        bus.addListener(FTBRanksEvent.PermissionNodeChanged.class,
                event -> FTBRanksIntegration.updateAllPlayers(event.getEventData().manager()));
        bus.addListener(FTBRanksEvent.Reloaded.class,
                event -> FTBRanksIntegration.updateAllPlayers(event.getEventData().manager()));
        bus.addListener(FTBRanksEvent.ConditionChanged.class,
                event -> FTBRanksIntegration.updateAllPlayers(event.getEventData().manager()));

        FTBUltimine.LOGGER.info("FTB Ranks detected, listening for ranks events");
    }
}

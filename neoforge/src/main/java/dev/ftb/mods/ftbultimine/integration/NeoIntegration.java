package dev.ftb.mods.ftbultimine.integration;

import dev.ftb.mods.ftblibrary.platform.Platform;
import dev.ftb.mods.ftbultimine.api.neoforge.FTBUltimineEvent;
import dev.ftb.mods.ftbultimine.integration.agricraft.AgricraftSetup;
import dev.ftb.mods.ftbultimine.integration.ezcrystals.neoforge.EZCrystals;
import dev.ftb.mods.ftbultimine.integration.ftbranks.neoforge.FTBRanksNeoIntegration;
import net.neoforged.bus.api.IEventBus;

public class NeoIntegration {
    public static void init(IEventBus bus) {
        if (Platform.get().isModLoaded("ftbranks")) {
            FTBRanksNeoIntegration.init(bus);
        }

        if (Platform.get().isModLoaded("agricraft")) {
            bus.addListener(FTBUltimineEvent.RegisterCropLike.class,
                    event -> AgricraftSetup.registerHandler(event.getEventData()));
        }

        if (Platform.get().isModLoaded("ftbezcrystals")) {
            EZCrystals.init(bus);
        }
    }
}

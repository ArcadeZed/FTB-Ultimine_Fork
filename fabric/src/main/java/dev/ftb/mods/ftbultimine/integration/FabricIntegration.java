package dev.ftb.mods.ftbultimine.integration;

import dev.ftb.mods.ftblibrary.platform.Platform;
import dev.ftb.mods.ftbultimine.integration.ftbranks.fabric.FTBRanksFabricIntegration;

public class FabricIntegration {
    public static void init() {
        if (Platform.get().isModLoaded("ftbranks")) {
            FTBRanksFabricIntegration.init();
        }
    }
}

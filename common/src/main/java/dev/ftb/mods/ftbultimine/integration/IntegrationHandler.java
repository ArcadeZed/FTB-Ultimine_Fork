package dev.ftb.mods.ftbultimine.integration;

import dev.ftb.mods.ftblibrary.platform.Platform;
import dev.ftb.mods.ftbultimine.integration.acceldecay.AcceleratedDecay;

public class IntegrationHandler {
    public static boolean ftbRanksLoaded = false;

    public static void init() {
//        if (Platform.get().isModLoaded("agricraft")) {
//            RegisterCropLikeEvent.REGISTER.register(AgricraftSetup::registerHandler);
//        }

        if (Platform.get().isModLoaded("accelerateddecay")) {
            AcceleratedDecay.init();
        }
    }
}

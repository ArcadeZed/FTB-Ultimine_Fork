package dev.ftb.mods.ftbultimine.client;

import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.ftb.mods.ftblibrary.client.gui.input.Key;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.input.KeyEvent;

public class ClientPlatformUtil {
    @ExpectPlatform
    public static boolean doesKeybindMatch(KeyMapping keyMapping, KeyEvent event) {
        throw new AssertionError();
    }

    public static boolean doesKeybindMatch(KeyMapping keyMapping, Key key) {
        return doesKeybindMatch(keyMapping, key.event());
    }
}

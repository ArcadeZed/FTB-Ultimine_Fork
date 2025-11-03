package dev.ftb.mods.ftbultimine.client.fabric;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.input.KeyEvent;

public class ClientPlatformUtilImpl {
    public static boolean doesKeybindMatch(KeyMapping keyMapping, KeyEvent event) {
        // TODO how can we handle key modifiers on Fabric?
        return keyMapping.matches(event);
    }
}

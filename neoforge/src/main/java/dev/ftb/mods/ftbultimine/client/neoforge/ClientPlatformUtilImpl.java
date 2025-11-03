package dev.ftb.mods.ftbultimine.client.neoforge;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.input.KeyEvent;
import org.lwjgl.glfw.GLFW;

public class ClientPlatformUtilImpl {
    public static boolean doesKeybindMatch(KeyMapping keyMapping, KeyEvent event) {
        if (keyMapping.matches(event)) {
            return switch (keyMapping.getKeyModifier()) {
                case NONE -> event.modifiers() == 0;
                case SHIFT ->  (event.modifiers() & GLFW.GLFW_MOD_SHIFT) != 0;
                case CONTROL, CONTROL_OR_COMMAND ->  (event.modifiers() & GLFW.GLFW_MOD_CONTROL) != 0;
                case ALT ->  (event.modifiers() & GLFW.GLFW_MOD_ALT) != 0;
            };
        }
        return false;
    }
}

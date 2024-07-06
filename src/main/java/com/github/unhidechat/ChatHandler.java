package com.github.unhidechat;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.option.StickyKeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ChatHandler {
    public static final String KEY_CATEGORY = "UnhideChat";

    private static KeyBinding unhideChatKeyHold;
    private static StickyKeyBinding unhideChatKeyToggle;

    private static KeyBinding expandChatKeyHold;
    private static StickyKeyBinding expandChatKeyToggle;

    public static void registerKeyBindings() {
        KeyBindingHelper.registerKeyBinding(unhideChatKeyHold);
        KeyBindingHelper.registerKeyBinding(unhideChatKeyToggle);
        KeyBindingHelper.registerKeyBinding(expandChatKeyHold);
        KeyBindingHelper.registerKeyBinding(expandChatKeyToggle);
    }

    public static void initializeKeyBindings() {
        unhideChatKeyHold = new KeyBinding(
                "unhideChatKeyHold",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_Z,
                KEY_CATEGORY
        );

        unhideChatKeyToggle = new StickyKeyBinding(
                "unhideChatKeyToggle",
                GLFW.GLFW_KEY_X,
                KEY_CATEGORY,
                () -> true
        );

        expandChatKeyHold = new KeyBinding(
                "expandChatKeyHold",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_C,
                KEY_CATEGORY
        );

        expandChatKeyToggle = new StickyKeyBinding(
                "expandChatKeyToggle",
                GLFW.GLFW_KEY_V,
                KEY_CATEGORY,
                () -> true
        );
    }

    public static boolean isHidden() {
        if (unhideChatKeyToggle.isPressed()) {
            return false;
        }
        return !unhideChatKeyHold.isPressed();
    }

    public static boolean isExpanded() {
        if (expandChatKeyToggle.isPressed()) {
            return true;
        }
        return expandChatKeyHold.isPressed();
    }
}

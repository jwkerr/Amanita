package com.fwloopins.amanita.client.config;

import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class ConfigScreen {
    private static KeyBinding configKeyBind;

    public static void createConfigKeybind() {
        configKeyBind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.Amanita.config",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_F10,
                "category.Amanita"
        ));
    }

    public static void configScreenTick(MinecraftClient client) {
        while (configKeyBind.wasPressed()) {
            client.setScreen(AutoConfig.getConfigScreen(AmanitaConfig.class, client.currentScreen).get());
        }
    }
}

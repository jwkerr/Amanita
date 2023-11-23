package com.fwloopins.amanita.client;

import com.fwloopins.amanita.client.config.AmanitaConfig;
import com.fwloopins.amanita.client.config.ConfigScreen;
import com.fwloopins.amanita.client.tweak.bobberremoval.BobberRemoval;
import com.fwloopins.amanita.client.cosmetic.particles.ClientParticles;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmanitaClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("Amanita");
    private static AmanitaConfig config = null;

    @Override
    public void onInitializeClient() {
        init();
        tick();

        logInfo("Amanita initialised");
    }

    private void init() {
        AutoConfig.register(AmanitaConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(AmanitaConfig.class).getConfig();

        ConfigScreen.createConfigKeybind();
    }

    private void tick() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ClientParticles.clientParticlesTick(client);
            ConfigScreen.configScreenTick(client);
            BobberRemoval.bobberRemovalTick(client);
        });
    }

    public static void logInfo(String msg) {
        LOGGER.info("[Amanita] " + msg);
    }

    public static void logError(String msg) {
        LOGGER.error("[Amanita] " + msg);
    }

    public static AmanitaConfig getConfig() {
        return config;
    }
}

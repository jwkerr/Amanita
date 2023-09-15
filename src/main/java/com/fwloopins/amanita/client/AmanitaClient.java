package com.fwloopins.amanita.client;

import com.fwloopins.amanita.client.config.AmanitaConfig;
import com.fwloopins.amanita.client.cosmetics.particles.ClientParticles;
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
        AutoConfig.register(AmanitaConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(AmanitaConfig.class).getConfig();

        tick();

        logInfo("Amanita initialised");
    }

    private void tick() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ClientParticles.clientParticlesTick(client);
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

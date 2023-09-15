package com.fwloopins.amanita.client.config;

import com.fwloopins.amanita.client.cosmetics.particles.objects.ParticleEffects;
import com.fwloopins.amanita.client.cosmetics.particles.objects.ParticleStyles;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "Amanita")
public class AmanitaConfig implements ConfigData {
    @ConfigEntry.Category("General")
    @ConfigEntry.Gui.TransitiveObject
    public General general = new General();

    @ConfigEntry.Category("Cosmetics")
    @ConfigEntry.Gui.TransitiveObject
    public Cosmetics cosmetics = new Cosmetics();

    public static class General {
        @ConfigEntry.Gui.Tooltip
        public String clientBrand = "";
        @ConfigEntry.Gui.Tooltip
        public boolean fullBlueZAxis = false;
        @ConfigEntry.Gui.Tooltip
        public boolean nullMovement = false;
        @ConfigEntry.Gui.Tooltip
        public boolean spectatorCrosshair = false;
        @ConfigEntry.Gui.Tooltip
        public boolean trueXP = false;
    }

    public static class Cosmetics {
        @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
        public Particles particles = new Particles();

        public static class Particles {
            @ConfigEntry.Gui.Tooltip
            public boolean isEnabled = false;
            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.DROPDOWN)
            public ParticleEffects particleEffect = ParticleEffects.FLAME;
            @ConfigEntry.Gui.Tooltip
            @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.DROPDOWN)
            public ParticleStyles particleStyle = ParticleStyles.TRAIL;
        }
    }
}

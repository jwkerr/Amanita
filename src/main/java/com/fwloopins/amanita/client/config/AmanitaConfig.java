package com.fwloopins.amanita.client.config;

import com.fwloopins.amanita.client.object.ParticleEffects;
import com.fwloopins.amanita.client.object.ParticleStyles;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = "Amanita")
public class AmanitaConfig implements ConfigData {
    @ConfigEntry.Category("Cosmetics")
    @ConfigEntry.Gui.TransitiveObject
    public Cosmetics cosmetics = new Cosmetics();

    public static class Cosmetics {
        @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
        public Particles particles = new Particles();
        @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
        public FlipModels flipModels = new FlipModels();
        @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
        public AlterStars alterStars = new AlterStars();
        @ConfigEntry.Gui.CollapsibleObject(startExpanded = true)
        public Tweaks tweaks = new Tweaks();

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

        public static class FlipModels {
            @ConfigEntry.Gui.Tooltip
            public boolean flipSelf = false;
            @ConfigEntry.Gui.Tooltip
            public boolean flipOthers = false;
            @ConfigEntry.Gui.Tooltip
            public boolean flipMobs = false;
        }

        public static class AlterStars {
            @ConfigEntry.Gui.Tooltip
            public long seed = 10842L;
            @ConfigEntry.Gui.Tooltip
            public int maxStars = 1500;
        }

        public static class Tweaks {
            @ConfigEntry.Gui.Tooltip
            public boolean fullBlueZAxis = false;
            @ConfigEntry.Gui.Tooltip
            public boolean bobberRemoval = false;
        }
    }
}

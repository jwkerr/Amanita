package com.fwloopins.amanita.client.cosmetics.particles.objects;

import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public enum ParticleStyles {
    AURA("aura"),
    HALO("halo"),
    ORBIT("orbit"),
    PULSATING_AURA("pulsating_aura"),
    SCANNING_AURA("scanning_aura"),
    TRAIL("trail"),
    TWIN_ORBIT("twin_orbit");

    private final String styleName;

    ParticleStyles(String styleName) {
        this.styleName = styleName;
    }

    @NotNull
    public String style() {
        return this.styleName;
    }
}

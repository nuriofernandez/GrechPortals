package me.nurio.minecraft.grechportals.portals;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import me.nurio.minecraft.worldareas.areas.WorldArea;
import org.bukkit.Location;

@Data
@RequiredArgsConstructor
public final class WorldPortal {

    private final WorldArea area;
    private final Location destination;

}
package me.nurio.minecraft.grechportals.portals;

import lombok.Data;
import me.nurio.minecraft.worldareas.areas.WorldArea;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

@Data
public final class WorldPortal {

    private final WorldArea area;
    private final WorldPortalActions actions;

    public WorldPortal(WorldArea area, Location location) {
        this(
            area,
            location,
            new ArrayList<>()
        );
    }

    public WorldPortal(WorldArea area, Location location, List<String> messages) {
        this.area = area;
        this.actions = new WorldPortalActions(
            this,
            location,
            messages
        );
    }

}
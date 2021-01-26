package me.nurio.minecraft.grechportals;

import lombok.Data;
import me.nurio.minecraft.worldareas.areas.WorldArea;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class WorldPortalsFactory {

    private List<WorldPortal> portals = new ArrayList<>();

    public WorldPortal getPortalByArea(WorldArea area) {
        return getPortalByArea(area.getUuid());
    }

    public WorldPortal getPortalByArea(UUID areaUuid) {
        return portals.stream()
            .filter(portal -> portal.getArea().getUuid().equals(areaUuid))
            .findFirst()
            .orElse(null);
    }

}
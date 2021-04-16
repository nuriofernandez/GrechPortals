package me.nurio.minecraft.grechportals;

import lombok.AllArgsConstructor;
import me.nurio.bukkit.configuration.files.GrechConfig;
import me.nurio.minecraft.grechportals.portals.WorldPortal;
import me.nurio.minecraft.grechportals.portals.WorldPortalsFactory;
import me.nurio.minecraft.worldareas.areas.WorldArea;
import me.nurio.minecraft.worldareas.areas.WorldAreaFactory;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ConfigLoader {

    private Plugin plugin;
    private WorldAreaFactory areaFactory;

    private WorldPortalsFactory portalsFactory;

    public void load() {
        getPortals().stream()
            .map(this::parse)
            .forEach(portalsFactory.getPortals()::add);
    }

    private List<File> getPortals() {
        File portalsFolder = new File(plugin.getDataFolder() + File.separator + "portals");
        if (!portalsFolder.exists()) portalsFolder.mkdirs();

        return Arrays.stream(portalsFolder.listFiles())
            .peek(f -> System.out.println("Reading file... '" + f.getName() + "'"))
            .filter(file -> file.getName().endsWith(".yml"))
            .collect(Collectors.toList());
    }

    private WorldPortal parse(File file) {
        GrechConfig config = new GrechConfig(plugin, file);
        String worldAreaUniqueId = config.getConfig().getString("world-area-uuid");
        Location destination = config.getLocation("destination");

        UUID uuid = UUID.fromString(worldAreaUniqueId);
        WorldArea area = areaFactory.getAreas().stream()
            .filter(worldArea -> worldArea.getUuid().equals(uuid)).findFirst()
            .orElse(null);

        return new WorldPortal(
            area,
            destination
        );
    }

}
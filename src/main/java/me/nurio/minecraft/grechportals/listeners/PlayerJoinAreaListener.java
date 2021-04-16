package me.nurio.minecraft.grechportals.listeners;

import lombok.RequiredArgsConstructor;
import me.nurio.minecraft.grechportals.portals.WorldPortal;
import me.nurio.minecraft.grechportals.portals.WorldPortalsFactory;
import me.nurio.minecraft.worldareas.areas.WorldArea;
import me.nurio.minecraft.worldareas.events.PlayerJoinAreaEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

@RequiredArgsConstructor
public class PlayerJoinAreaListener implements Listener {

    private final Plugin plugin;
    private final WorldPortalsFactory portalsFactory;

    @EventHandler
    public void onPortalJoin(PlayerJoinAreaEvent event) {
        WorldArea area = event.getWorldArea();
        WorldPortal portal = portalsFactory.getPortalByArea(area);
        if (portal == null) return; // No portal linked to that area.

        Player player = event.getPlayer();
        player.teleport(portal.getDestination());
    }

}
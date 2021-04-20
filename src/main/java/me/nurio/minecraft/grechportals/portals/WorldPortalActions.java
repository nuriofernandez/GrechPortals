package me.nurio.minecraft.grechportals.portals;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles the portal action application to a player.
 */
@Getter
@AllArgsConstructor
@RequiredArgsConstructor
public class WorldPortalActions {

    @NotNull private final WorldPortal portal;

    @NotNull private final Location teleportLocation;
    @NotNull private List<String> sendMessages = new ArrayList<>();

    /**
     * Applies portal action to the provided player.
     *
     * @param player Player to apply actions to.
     */
    public void applyTo(Player player) {
        if (!sendMessages.isEmpty()) sendMessages(player);
        if (teleportLocation != null) teleport(player);
    }

    private void teleport(Player player) {
        player.teleport(teleportLocation);
    }

    private void sendMessages(Player player) {
        sendMessages.stream()
            .map(msg -> ChatColor.translateAlternateColorCodes('&', msg))
            .map(msg -> msg.replaceAll("\\{playername}", player.getName()))
            .map(msg -> msg.replaceAll("\\{portalname}", portal.getArea().getName()))
            .forEach(player::sendMessage);
    }

}
package me.nurio.minecraft.grechportals;

import lombok.Getter;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class GrechPortals extends JavaPlugin {

    @Getter private static Plugin plugin;

    @Override
    public void onEnable() {
        plugin = this;
    }

}
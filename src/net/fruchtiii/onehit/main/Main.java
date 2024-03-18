package net.fruchtiii.onehit.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.fruchtiii.onehit.listener.ControlListener;
import net.fruchtiii.onehit.listener.PlayerDeathListener;
import net.fruchtiii.onehit.listener.PlayerJoinListener;
import net.fruchtiii.onehit.util.PluginConfig;
import net.fruchtiii.onehit.util.StatsManager;

public class Main extends JavaPlugin {

	private static Main plugin;
	private StatsManager statsManager;
	private PluginConfig configuration;

	public void onEnable() {
		plugin = this;

		configuration = new PluginConfig();
		statsManager = new StatsManager(new File(getDataFolder(), "stats.yml"));
		statsManager.createStatsFile();

		Bukkit.getPluginManager().registerEvents(new ControlListener(), this);
		Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
		Bukkit.getPluginManager().registerEvents(new PlayerDeathListener(this), this);
	}

	public static Main getPlugin() {
		return plugin;
	}

	public StatsManager getStatsManager() {
		return statsManager;
	}

	public PluginConfig getConfiguration() {
		return configuration;
	}

}

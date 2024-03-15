package net.fruchtiii.onehit.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.fruchtiii.onehit.listener.ControlListener;
import net.fruchtiii.onehit.listener.GameMechanic;
import net.fruchtiii.onehit.util.GameManager;
import net.fruchtiii.onehit.util.PluginConfig;
import net.fruchtiii.onehit.util.StatsManager;

public class Main extends JavaPlugin {

	private static Main plugin;
	private StatsManager statsManager;
	private PluginConfig configuration;
	private GameManager gameManager;

	public void onEnable() {
		plugin = this;

		configuration = new PluginConfig();

		Bukkit.getPluginManager().registerEvents(new ControlListener(), this);
		Bukkit.getPluginManager().registerEvents(new GameMechanic(this), this);

		statsManager = new StatsManager(new File(getDataFolder(), "stats.yml"));
		statsManager.createStatsFile();

		gameManager = new GameManager();
		gameManager.startNewGame();
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

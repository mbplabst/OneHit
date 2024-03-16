package net.fruchtiii.onehit.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class StatsManager {

	private File statsFile;
	private FileConfiguration statsConfig;

	public StatsManager(File statsFile) {
		this.statsFile = statsFile;
	}

	public void createStatsFile() {
		if (!statsFile.exists()) {
			statsFile.getParentFile().mkdirs();
			try {
				statsFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		statsConfig = new YamlConfiguration();
		try {
			statsConfig.load(statsFile);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void save() {
		try {
			statsConfig.save(statsFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void incrementStat(Player player, String stat) {
		String configPath = "stats." + player.getUniqueId().toString() + "." + stat;

		int value = statsConfig.getInt(configPath, 0);
		statsConfig.set(configPath, value + 1);
		save();
	}

	public PlayerStats getStats(UUID uuid) {
		ConfigurationSection playerStats = statsConfig.getConfigurationSection("stats." + uuid.toString());

		if (playerStats == null) {
			return new PlayerStats(uuid, 0, 0, 0);
		}
		return new PlayerStats(uuid, playerStats.getInt("death", 0), playerStats.getInt("kill", 0),
				playerStats.getInt("streak", 0));
	}
	
	public void addDeath(Player player) {
		incrementStat(player, "death");
	}
	
	public void addKill(Player player) {
		incrementStat(player, "kill");
	}
	
	public void addStreak(Player player) {
		incrementStat(player, "streak");
	}
}

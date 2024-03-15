package net.fruchtiii.onehit.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class PluginConfig {

	private String prefix = "§8[§9OneHit§8] ";
	private Location spawnLocation = new Location(Bukkit.getWorld("world"), 0.5, 150, 0.5, 0, 0);
	private int minYCoordinate = 60;

	public String getPrefix() {
		return prefix;
	}

	public Location getSpawnLocation() {
		return spawnLocation;
	}

	public int getMinYCoordinate() {
		return minYCoordinate;
	}

}

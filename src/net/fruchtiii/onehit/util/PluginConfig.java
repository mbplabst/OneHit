package net.fruchtiii.onehit.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class PluginConfig {

	private Location spawnLocation = new Location(Bukkit.getWorld("world"), 0.5, 150, 0.5, 0, 0);
	private int minYCoordinate = 60;
	private ItemStack sword = new ItemBuilder(Material.IRON_SWORD).setName("§7Sword").setUnbreakable().hideFlags()
			.build();
	private ItemStack bow = new ItemBuilder(Material.BOW).setName("§7Bow").setUnbreakable().build();
	private ItemStack arrow = new ItemBuilder(Material.ARROW).setName("§7Arrow").hideFlags().build();

	public Location getSpawnLocation() {
		return spawnLocation;
	}

	public int getMinYCoordinate() {
		return minYCoordinate;
	}

	public ItemStack getSwordItem() {
		return sword;
	}

	public ItemStack getBowItem() {
		return bow;
	}

	public ItemStack getArrowItem() {
		return arrow;
	}
}

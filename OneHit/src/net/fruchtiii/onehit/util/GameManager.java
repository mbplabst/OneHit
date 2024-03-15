package net.fruchtiii.onehit.util;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GameManager {

	Location spawnLocation = new Location(Bukkit.getWorld("world"), 0.5, 150, 0.5, 0, 0);
	ItemStack sword = new ItemBuilder(Material.IRON_SWORD).setUnbreakable().hideFlags().build();
	ItemStack bow = new ItemBuilder(Material.BOW).setUnbreakable().build();
	ItemStack arrow = new ItemBuilder(Material.ARROW).hideFlags().build();

	public void startNewGame() {
		for (Player onlinePlayers : Bukkit.getOnlinePlayers()) {

			Bukkit.getWorld("world").setSpawnLocation(spawnLocation.getBlockX(), spawnLocation.getBlockY(),
					spawnLocation.getBlockZ());
			ScoreboardManager.createNewScoreboard(onlinePlayers);

			onlinePlayers.setGameMode(GameMode.SURVIVAL);
			onlinePlayers.setHealth(20);
			onlinePlayers.setSaturation(20);
			onlinePlayers.setExp(0);
			onlinePlayers.teleport(spawnLocation);

			Inventory inv = onlinePlayers.getInventory();
			inv.clear();
			inv.setItem(0, sword);
			inv.setItem(1, bow);
		}
	}
}

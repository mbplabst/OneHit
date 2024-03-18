package net.fruchtiii.onehit.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.fruchtiii.onehit.main.Main;
import net.fruchtiii.onehit.util.ScoreboardManager;

public class PlayerJoinListener implements Listener {

	private Location spawnLocation;
	private ItemStack sword;
	private ItemStack bow;

	private ScoreboardManager scoreboardManager;

	public PlayerJoinListener(Main main) {
		spawnLocation = main.getConfiguration().getSpawnLocation();
		sword = main.getConfiguration().getSwordItem();
		bow = main.getConfiguration().getBowItem();
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		event.setJoinMessage(null);

		Bukkit.getWorld("world").setSpawnLocation(spawnLocation.getBlockX(), spawnLocation.getBlockY(),
				spawnLocation.getBlockZ());

		Player player = event.getPlayer();
		player.teleport(spawnLocation);
		player.playSound(spawnLocation, Sound.NOTE_PLING, 1, 1);
		player.setGameMode(GameMode.SURVIVAL);
		player.setHealth(20);
		player.setSaturation(20);
		player.setExp(0);

		Inventory inv = player.getInventory();
		inv.clear();
		inv.setItem(0, sword);
		inv.setItem(1, bow);

		scoreboardManager = new ScoreboardManager();
		scoreboardManager.createNewScoreboard(player);
	}

}

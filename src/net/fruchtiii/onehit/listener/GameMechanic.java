package net.fruchtiii.onehit.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import net.fruchtiii.onehit.main.Main;

public class GameMechanic implements Listener {

	private Main main;
	String prefix;
	Location spawnLocation;
	int minYCoordinate;

	public GameMechanic(Main main) {
		this.main = main;
		prefix = main.getConfiguration().getPrefix();
		spawnLocation = main.getConfiguration().getSpawnLocation();
		minYCoordinate = main.getConfiguration().getMinYCoordinate();
	}

	@EventHandler
	public void onPlayerDeath(PlayerMoveEvent event) {
		Player player = event.getPlayer();

		if (player.getLocation().getBlockY() > minYCoordinate) {
			return;
		}

		player.teleport(spawnLocation);
		player.playSound(spawnLocation, Sound.VILLAGER_DEATH, 1, 1);
		Bukkit.getServer().broadcastMessage(prefix + ChatColor.RED + player.getName() + " died!");

		main.getStatsManager().addDeath(player);

	}

}

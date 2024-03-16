package net.fruchtiii.onehit.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import net.fruchtiii.onehit.main.Main;
import net.fruchtiii.onehit.util.ScoreboardManager;

public class PlayerDeathListener implements Listener {

	private Main main;
	private String prefix;
	private Location spawnLocation;
	private int minYCoordinate;

	private ScoreboardManager scoreboardManager;

	public PlayerDeathListener(Main main) {
		this.main = main;
		prefix = main.getConfiguration().getPrefix();
		spawnLocation = main.getConfiguration().getSpawnLocation();
		minYCoordinate = main.getConfiguration().getMinYCoordinate();
	}

	@EventHandler
	public void onPlayerOwnDeath(PlayerMoveEvent event) {
		Player player = event.getPlayer();

		if (player.getLocation().getBlockY() > minYCoordinate) {
			return;
		}

		player.teleport(spawnLocation);
		player.playSound(spawnLocation, Sound.VILLAGER_DEATH, 1, 1);
		Bukkit.getServer().broadcastMessage(prefix + ChatColor.RED + player.getName() + " died!");

		main.getStatsManager().addDeath(player);

		scoreboardManager = new ScoreboardManager();
		scoreboardManager.updatePlayerDeathCount(player);
	}

	@EventHandler
	public void onPlayerGettingKilled(EntityInteractEvent event) {
		event.getEntity().sendMessage(event.getEntity().getName());

	}
}

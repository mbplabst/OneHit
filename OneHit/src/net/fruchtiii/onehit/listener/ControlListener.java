package net.fruchtiii.onehit.listener;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerAchievementAwardedEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class ControlListener implements Listener {

	static Location spawnLocation = new Location(Bukkit.getWorld("world"), 0.5, 150, 0.5, 0, 0);

	@EventHandler
	public void handleHunger(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void handleDropping(PlayerDropItemEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void handleItemPickUp(PlayerPickupItemEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void handleBlockPlacing(BlockPlaceEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void handleBlockBreaking(BlockBreakEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void DamageHandler(EntityDamageEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void handleAchievements(PlayerAchievementAwardedEvent event) {
		event.setCancelled(true);
	}

	@EventHandler
	public void handleWeather(WeatherChangeEvent event) {
		Bukkit.getWorld("world").setTime(6000);
		event.setCancelled(true);
	}
}

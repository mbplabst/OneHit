package net.fruchtiii.onehit.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageManager {

	public String sendPlayerFallVoidMessage(Player player, int streak) {
		return (ChatColor.DARK_GRAY + "[" + ChatColor.WHITE + ChatColor.BOLD + "DEATH" + ChatColor.DARK_GRAY + "] "
				+ ChatColor.RED + player.getName() + ChatColor.DARK_GRAY + " [" + ChatColor.YELLOW + streak
				+ ChatColor.DARK_GRAY + "]" + ChatColor.RED + " fell into the void");
	}

	public String sendPlayerStreakMessage(Player player, int streak) {
		return (ChatColor.DARK_GRAY + "[" + ChatColor.WHITE + ChatColor.BOLD + "STREAK" + ChatColor.DARK_GRAY + "] "
				+ ChatColor.YELLOW + player.getName() + " reached a " + streak + " Killstreak");
	}

	public String sendPlayerKillMessage(Player p1, Player p2) {
		return ("&8[&f&lKILL&8] &aFruchtiii &8[&e5&8] &8» &cErsterJujo &8[&e2&8]");
	}

}

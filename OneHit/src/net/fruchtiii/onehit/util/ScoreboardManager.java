package net.fruchtiii.onehit.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import net.fruchtiii.onehit.main.Main;

public class ScoreboardManager {

	public static void createNewScoreboard(Player player) {
		Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective objective = scoreboard.registerNewObjective("Scoreboard", "dummy");

		String firstPlaceName = "name";
		String secondPlaceName = "name";
		String thirdPlaceName = "name";

		int firstPlaceKills = 0;
		int secondPlaceKills = 0;
		int thirdPlaceKills = 0;

		PlayerStats stats = Main.getPlugin().getStatsManager().getStats(player.getUniqueId());

		int ownKills = stats.getKills();
		int ownStreak = 0;
		int ownDeaths = stats.getDeaths();

		objective.setDisplaySlot(DisplaySlot.SIDEBAR);
		objective.setDisplayName("      §9§lONEHIT     ");
		objective.getScore("    ").setScore(13);
		objective.getScore(ChatColor.GOLD + "Most Kills:").setScore(12);
		objective
				.getScore(
						ChatColor.DARK_AQUA + "§8» " + ChatColor.YELLOW + "[" + firstPlaceKills + "] " + firstPlaceName)
				.setScore(11);
		objective
				.getScore(
						ChatColor.DARK_BLUE + "§8» " + ChatColor.GRAY + "[" + secondPlaceKills + "] " + secondPlaceName)
				.setScore(10);
		objective
				.getScore(ChatColor.DARK_GRAY + "§8» " + ChatColor.GOLD + "[" + thirdPlaceKills + "] " + thirdPlaceName)
				.setScore(9);
		objective.getScore("   ").setScore(8);
		objective.getScore(ChatColor.GOLD + "Your Kills:").setScore(6);
		objective.getScore(ChatColor.GREEN + "§8» §e" + ownKills).setScore(6);
		objective.getScore("  ").setScore(5);
		objective.getScore(ChatColor.GOLD + "Your Streak:").setScore(4);
		objective.getScore(ChatColor.BLUE + "§8» §e" + ownStreak).setScore(3);
		objective.getScore(" ").setScore(2);
		objective.getScore(ChatColor.GOLD + "Your Deaths:").setScore(1);
		objective.getScore(ChatColor.RED + "§8» §e" + ownDeaths).setScore(0);

		player.setScoreboard(scoreboard);
	}

	public static void updateScoreboard(Player player) {
	}

	public static void removeScoreboard(Player player) {
		player.getScoreboard().clearSlot(DisplaySlot.SIDEBAR);
	}
}

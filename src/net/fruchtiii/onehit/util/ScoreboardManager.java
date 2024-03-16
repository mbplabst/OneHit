package net.fruchtiii.onehit.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import net.fruchtiii.onehit.main.Main;

public class ScoreboardManager {

	PlayerStats stats;

	private String firstPlaceName = "name";
	private String secondPlaceName = "name";
	private String thirdPlaceName = "name";

	private int firstPlaceKills = 0;
	private int secondPlaceKills = 0;
	private int thirdPlaceKills = 0;

	public void createNewScoreboard(Player player) {
		stats = Main.getPlugin().getStatsManager().getStats(player.getUniqueId());
		Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective objective = scoreboard.registerNewObjective("Scoreboard", "dummy");

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
		objective.getScore(ChatColor.GOLD + "Your Kills:").setScore(7);
		objective.getScore("  ").setScore(5);
		objective.getScore(ChatColor.GOLD + "Your Streak:").setScore(4);
		objective.getScore(" ").setScore(2);
		objective.getScore(ChatColor.GOLD + "Your Deaths:").setScore(1);

		Team personalKillCount = scoreboard.registerNewTeam("kills");
		String killkey = ChatColor.BLACK.toString();

		personalKillCount.addEntry(killkey);
		personalKillCount.setPrefix(ChatColor.BLACK + "§8» ");
		personalKillCount.setSuffix(ChatColor.YELLOW + Integer.toString(stats.getKills()));
		objective.getScore(killkey).setScore(6);

		Team personalStreakCount = scoreboard.registerNewTeam("streak");
		String streakkey = ChatColor.RED.toString();

		personalStreakCount.addEntry(streakkey);
		personalStreakCount.setPrefix(ChatColor.RED + "§8» ");
		personalStreakCount.setSuffix(ChatColor.YELLOW + Integer.toString(stats.getStreak()));
		objective.getScore(streakkey).setScore(3);

		Team personalDeathCount = scoreboard.registerNewTeam("deaths");
		String deathkey = ChatColor.GOLD.toString();

		personalDeathCount.addEntry(deathkey);
		personalDeathCount.setPrefix(ChatColor.YELLOW + "§8» ");
		personalDeathCount.setSuffix(ChatColor.YELLOW + Integer.toString(stats.getDeaths()));
		objective.getScore(deathkey).setScore(0);

		player.setScoreboard(scoreboard);
	}

	public void updatePlayerKillCount(Player player) {
		stats = Main.getPlugin().getStatsManager().getStats(player.getUniqueId());
		Scoreboard scoreboard = player.getScoreboard();
		Team kills = scoreboard.getTeam("kills");
		kills.setSuffix(ChatColor.YELLOW + Integer.toString(stats.getKills()));
	}

	public void updatePlayerStreakCount(Player player) {
		stats = Main.getPlugin().getStatsManager().getStats(player.getUniqueId());
		Scoreboard scoreboard = player.getScoreboard();
		Team streak = scoreboard.getTeam("streak");
		streak.setSuffix(ChatColor.YELLOW + Integer.toString(stats.getStreak()));
	}

	public void updatePlayerDeathCount(Player player) {
		stats = Main.getPlugin().getStatsManager().getStats(player.getUniqueId());
		Scoreboard scoreboard = player.getScoreboard();
		Team deaths = scoreboard.getTeam("deaths");
		deaths.setSuffix(ChatColor.YELLOW + Integer.toString(stats.getDeaths()));
	}
}

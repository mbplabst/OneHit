package net.fruchtiii.onehit.util;

import java.util.UUID;

public class PlayerStats {

	private UUID uuid;
	private int deaths;
	private int kills;

	public PlayerStats(UUID uuid, int deaths, int kills) {
		this.setUuid(uuid);
		this.setDeaths(deaths);
		this.setKills(kills);
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public int getDeaths() {
		return deaths;
	}

	public void setDeaths(int deaths) {
		this.deaths = deaths;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

}

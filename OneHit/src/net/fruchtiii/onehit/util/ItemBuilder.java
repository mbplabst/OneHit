package net.fruchtiii.onehit.util;

import java.util.Arrays;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {

	private ItemStack item;
	private ItemMeta itemMeta;

	public ItemBuilder(Material material, short subID) {
		item = new ItemStack(material, 1, subID);
		itemMeta = item.getItemMeta();
	}

	public ItemBuilder(Material material) {
		this(material, (short) 0);
	}

	public ItemBuilder setName(String name) {
		itemMeta.setDisplayName(name);
		return this;
	}

	public ItemBuilder setLore(String... lore) {
		itemMeta.setLore(Arrays.asList(lore));
		return this;
	}

	public ItemBuilder setAmount(int amount) {
		item.setAmount(amount);
		return this;
	}

	public ItemBuilder setUnbreakable() {
		itemMeta.spigot().setUnbreakable(true);
		itemMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
		return this;
	}

	public ItemBuilder addEnchantment(Enchantment enchantment) {
		itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemMeta.addEnchant(enchantment, 1, false);
		return this;
	}

	public ItemBuilder hideFlags() {
		itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		return this;
	}

	public ItemBuilder setSkullOwner(String owner) {
		SkullMeta meta = (SkullMeta) this.item.getItemMeta();
		meta.setOwner(owner);
		this.item.setItemMeta(meta);
		return this;
	}

	public ItemBuilder setArmorColor(Color color) {
		LeatherArmorMeta meta = (LeatherArmorMeta) this.item.getItemMeta();
		meta.setColor(color);
		this.item.setItemMeta(meta);
		return this;
	}

	public static ItemBuilder skullBuilder() {
		return new ItemBuilder(Material.SKULL_ITEM, (short) 3);
	}

	public ItemStack build() {
		item.setItemMeta(itemMeta);
		return item;
	}
}

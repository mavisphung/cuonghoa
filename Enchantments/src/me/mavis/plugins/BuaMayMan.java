package me.mavis.plugins;

import org.bukkit.inventory.ItemStack;

public class BuaMayMan {
	private ItemStack item;
	
	public BuaMayMan() {
	}
	
	public BuaMayMan(ItemStack item) {
		this.item = item;
	}

	public ItemStack getItem() {
		return item;
	}

	public void setItem(ItemStack item) {
		this.item = item;
	}
}

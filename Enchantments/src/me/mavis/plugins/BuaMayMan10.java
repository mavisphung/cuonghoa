package me.mavis.plugins;

import org.bukkit.inventory.ItemStack;

public class BuaMayMan10 extends BuaMayMan {
	private int luck;
	
	public BuaMayMan10() {
		super();
		luck = 10;
	}
	
	public BuaMayMan10(ItemStack item) {
		super(item);
		luck = 10;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}
	
}
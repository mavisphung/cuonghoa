package me.mavis.plugins;

import org.bukkit.inventory.ItemStack;

public class BuaMayMan15 extends BuaMayMan {
	private int luck;
	
	public BuaMayMan15() {
		super();
		luck = 15;
	}
	
	public BuaMayMan15(ItemStack item) {
		super(item);
		luck = 15;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}
	
}

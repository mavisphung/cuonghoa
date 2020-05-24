package me.mavis.plugins;

import org.bukkit.inventory.ItemStack;

public class BuaMayMan5 extends BuaMayMan {
	private int luck;
	
	public BuaMayMan5() {
		super();
		luck = 5;
	}
	
	public BuaMayMan5(ItemStack item) {
		super(item);
		luck = 5;
	}

	public int getLuck() {
		return luck;
	}

	public void setLuck(int luck) {
		this.luck = luck;
	}
	
}

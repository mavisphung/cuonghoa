package me.mavis.main;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryListener implements Listener {
	
	@EventHandler
	public void onPlayerClickInventory(InventoryClickEvent e) {
		Player player = (Player) e.getWhoClicked();
		Inventory topInv = e.getView().getTopInventory();
		Inventory clickedInv = e.getClickedInventory();
		Inventory botInv = e.getView().getBottomInventory();
		String title = e.getView().getTitle();
		//chặn hết
//		if (title.equals("Shop")) {
//			e.setCancelled(true);
//			if (!e.getCurrentItem().equals(Material.AIR)) {
//				player.sendMessage("You clicked on " + e.getCurrentItem().getItemMeta().getDisplayName());
//				return;
//			}
//		}		
		
		//chặn top inv
//		if (title.equals("Shop")) {
//			if (e.getRawSlot() < 54) { //click trong top inv
//				if (!e.getCurrentItem().equals(Material.AIR)) {
//					player.sendMessage("You clicked on " + e.getCurrentItem().getItemMeta().getDisplayName());
//					player.sendMessage("You clicked on " + e.getClickedInventory().getType().name());
//					e.setCancelled(true);
//				}
//			}
//			else { //click trong bot inv
//				if (!e.getCurrentItem().equals(Material.AIR)) {
//					player.sendMessage("You clicked on " + e.getClickedInventory().getType().name());
//					player.sendMessage("bot inventory");
//					return;
//				}
//			}
//		}
		
		//chặn theo type
		if (title.equals("Shop")) {
			ItemStack currentItem = e.getCurrentItem();
			int pos = e.getRawSlot();
			if (clickedInv.getType().equals(InventoryType.CHEST) && pos < 53) {
				try {
					e.setCancelled(true);
					if (!currentItem.equals(Material.AIR)) {
						player.sendMessage("You clicked on GUI menu and an item: " + currentItem.getItemMeta().getDisplayName());
						return;
					}
				}
				catch (Exception ex) {
					
				}
			}
			if (clickedInv.getType().equals(InventoryType.PLAYER)) {
				try {
					if (!currentItem.equals(Material.AIR)) {
						player.sendMessage("You clicked on player's inventory and an item: " + currentItem.getItemMeta().getDisplayName());
					}
					else {
						player.sendMessage("You clicked on player's inventory");
					}
				}
				catch (Exception ex) {
					player.sendMessage(ex.getMessage());
				}
			}
		}
	}
}

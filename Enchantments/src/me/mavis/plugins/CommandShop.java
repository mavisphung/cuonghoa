package me.mavis.plugins;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class CommandShop implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) { //dùng cho player
			Player player = (Player) sender;
			if (args.length > 0) {
				player.sendMessage(ChatColor.RED + "Command không tồn tại");
			}
			else {
//				int counter = 300;
//				long current = System.currentTimeMillis();
//				long arrival = current + counter;
//				do {
//					current += current + 1000;
//					Thread.sleep(1000);
//				} while (current <= arrival);
				Inventory inv = Bukkit.createInventory(player, 9*6, "Shop");
				ItemStack apple = new ItemStack(Material.APPLE);
				ItemMeta mitem = apple.getItemMeta();
				mitem.setDisplayName("AAA");
				apple.setItemMeta(mitem);
				inv.setItem(12, apple);
				player.openInventory(inv);
			}
		}
		else { // dùng cho admin
			
		}
		return true;
	}

}

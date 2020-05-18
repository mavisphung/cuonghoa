package me.mavis.plugins;

import java.util.Map;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class CommandCuongHoa implements CommandExecutor {
	
	public Enchantment getEnchantmentInMapByName(Map<Enchantment, Integer> enchants, String enchantment) {
		for (Enchantment enchant : enchants.keySet()) {
			if (enchant.getName().toLowerCase().equals(enchantment.toLowerCase())) {
				Bukkit.getConsoleSender().sendMessage(enchants.toString());
				return enchant;
			}
		}
		Bukkit.getConsoleSender().sendMessage("Lỗi cực mank");
		return null;
	}
	
	public boolean isMoreTenLevels(Map<Enchantment, Integer> enchants) {
		for (Enchantment enchant : enchants.keySet()) {
			if (enchants.get(enchant) > 11) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isExistedEnchantment(Map<Enchantment, Integer> enchants, Enchantment enchantment) {
		for (Enchantment enchant : enchants.keySet()) {
			if (enchant.getKey().equals(enchantment.getKey())) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if (sender instanceof Player) {
			Player player = (Player) sender;
			ItemStack pitem = player.getInventory().getItemInMainHand();
			ItemMeta mitem = pitem.getItemMeta();
			if (args.length == 1) {
				if (mitem == null || mitem.equals(Material.AIR)) {
					player.sendMessage(ChatColor.RED + "Justmine: " +ChatColor.DARK_RED + "You have no item to do this !");
				}
				else {
					Map<Enchantment, Integer> enchantsList = mitem.getEnchants();
					Enchantment enchant = Enchantment.getByKey(NamespacedKey.minecraft(args[0].toLowerCase()));
					player.sendMessage(enchant.getName());
//					if (!isExistedEnchantment(enchantsList, enchant)) {
//						mitem.addEnchant(Enchantment.getByKey(NamespacedKey.minecraft(args[0].toLowerCase())), 1, true);
//						pitem.setItemMeta(mitem);
//						player.getInventory().setItemInMainHand(pitem);
//						player.sendMessage(ChatColor.AQUA + "Enchant thành công");
//					}
//					else {
//						if (isMoreTenLevels(enchantsList)) {
//							Random random = new Random();
//							int luck = random.nextInt(100);
//							try {
//								if (enchant != null) {
//									Integer currentLevel = mitem.getEnchantLevel(enchant);
//									if (luck <= 20) {
//										if (currentLevel == 1) {
//											mitem.removeEnchant(enchant);
//										}
//										else {
//											mitem.addEnchant(enchant, currentLevel - 1, true);
//										}
//										pitem.setItemMeta(mitem);
//										player.getInventory().setItemInMainHand(pitem);
//										player.sendMessage(ChatColor.RED + "Justmine: " + ChatColor.DARK_RED + "Cường hóa thất bại !");
//									}
//									else {
//				//						enchantsList.put(Enchantment.DAMAGE_ALL, currentLevel + 1);
//										mitem.addEnchant(enchant, currentLevel + 1, true);
//										pitem.setItemMeta(mitem);
//										player.getInventory().setItemInMainHand(pitem);
//										player.sendMessage(ChatColor.RED + "Justmine: " + ChatColor.AQUA + "Cường hóa thành công !");
//									}
//								}
//								else {
//									player.sendMessage(ChatColor.RED + "Justmine: " +ChatColor.DARK_RED + "Enchantment này bị lỗi");
//								}
//								
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
//						}
//						else {
//							player.sendMessage(ChatColor.RED + "Justmine: " +ChatColor.DARK_RED + "Có dòng enchant quá lvl 10!");
//						}
//					}
					if (!enchantsList.containsKey(enchant)) {
						mitem.addEnchant(Enchantment.getByKey(NamespacedKey.minecraft(args[0].toLowerCase())), 1, true);
//						mitem.addEnchant(enchant, 1, true);
						pitem.setItemMeta(mitem);
						player.getInventory().setItemInMainHand(pitem);
						player.sendMessage(ChatColor.AQUA + "Enchant thành công");
					}
					else {
//						Enchantment enchantFromList = getEnchantmentInMapByName(enchantsList, args[0]);
						if (enchant != null) {
							Random random = new Random();
							int luck = random.nextInt(100);
							Integer currentLevel = mitem.getEnchantLevel(enchant);
							if (currentLevel <= 3) {
								if (luck <= 20) {
									if (currentLevel == 1) {
										mitem.removeEnchant(enchant);
									}
									else {
										mitem.addEnchant(enchant, currentLevel - 1, true);
									}
									pitem.setItemMeta(mitem);
									player.getInventory().setItemInMainHand(pitem);
									player.sendMessage(ChatColor.RED + "Justmine: " + ChatColor.DARK_RED + "Cường hóa thất bại !");
								}
								else {
			//						enchantsList.put(Enchantment.DAMAGE_ALL, currentLevel + 1);
									mitem.addEnchant(enchant, currentLevel + 1, true);
									pitem.setItemMeta(mitem);
									player.getInventory().setItemInMainHand(pitem);
									player.sendMessage(ChatColor.RED + "Justmine: " + ChatColor.AQUA + "Cường hóa thành công !");
								}
							}
							else if (currentLevel > 3 && currentLevel <= 5) {
								luck = random.nextInt(100);
								if (luck <= 40) {
									mitem.addEnchant(enchant, currentLevel - 1, true);
									pitem.setItemMeta(mitem);
									player.getInventory().setItemInMainHand(pitem);
									player.sendMessage(ChatColor.RED + "Justmine: " + ChatColor.DARK_RED + "Cường hóa thất bại !");
								}
								else {
									mitem.addEnchant(enchant, currentLevel + 1, true);
									pitem.setItemMeta(mitem);
									player.getInventory().setItemInMainHand(pitem);
									player.sendMessage(ChatColor.RED + "Justmine: " + ChatColor.AQUA + "Cường hóa thành công !");
								}
							} else if (currentLevel > 5 && currentLevel <= 8) {
								luck = random.nextInt(100);
								if (luck <= 60) {
									mitem.addEnchant(enchant, currentLevel - 1, true);
									pitem.setItemMeta(mitem);
									player.getInventory().setItemInMainHand(pitem);
									player.sendMessage(ChatColor.RED + "Justmine: " + ChatColor.DARK_RED + "Cường hóa thất bại !");
								}
								else {
									mitem.addEnchant(enchant, currentLevel + 1, true);
									pitem.setItemMeta(mitem);
									player.getInventory().setItemInMainHand(pitem);
									player.sendMessage(ChatColor.RED + "Justmine: " + ChatColor.AQUA + "Cường hóa thành công !");
								}
							} else if (currentLevel > 8 && currentLevel <= 10) {
								luck = random.nextInt(100);
								if (luck <= 80) {
									mitem.addEnchant(enchant, currentLevel - 2, true);
									pitem.setItemMeta(mitem);
									player.getInventory().setItemInMainHand(pitem);
									player.sendMessage(ChatColor.RED + "Justmine: " + ChatColor.DARK_RED + "Cường hóa thất bại !");
								}
								else {
									mitem.addEnchant(enchant, currentLevel + 1, true);
									pitem.setItemMeta(mitem);
									player.getInventory().setItemInMainHand(pitem);
									player.sendMessage(ChatColor.RED + "Justmine: " + ChatColor.AQUA + "Cường hóa thành công !");
								}
							}
						}
						else {
							player.sendMessage(ChatColor.RED + "Justmine: " +ChatColor.DARK_RED + "Enchantment này bị lỗi");
						}
					}
					
				}
			}
		}
		else {
			sender.sendMessage(ChatColor.RED + " đéo được dùng");
		}
		return true;
	}

}

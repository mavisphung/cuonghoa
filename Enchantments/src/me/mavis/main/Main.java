package me.mavis.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.mavis.plugins.CommandCuongHoa;
import me.mavis.plugins.CommandShop;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		getCommand("cuonghoa").setExecutor(new CommandCuongHoa());
		getCommand("shop").setExecutor(new CommandShop());
		getServer().getPluginManager().registerEvents(new InventoryListener(), this);
	}
	
}

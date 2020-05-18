package me.mavis.main;

import org.bukkit.plugin.java.JavaPlugin;

import me.mavis.plugins.CommandCuongHoa;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		getCommand("cuonghoa").setExecutor(new CommandCuongHoa());
	}
	
}

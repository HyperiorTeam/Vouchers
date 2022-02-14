package net.hyperior.vouchers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import net.hyperior.vouchers.commands.VoucherCommand;

public class VouchersMain extends JavaPlugin {
	
	private static VouchersMain instance;
	
	public void onEnable() {
		
		instance = this;
		
		registerCommands();
		registerEvents();
		
		if(!getDataFolder().exists()) {
			
			getDataFolder().mkdir();
			
		}
		
		saveDefaultConfig();
		
		reloadConfig();
		
	}
	
	public void registerCommands() {
		
		getCommand("vouchers").setExecutor(new VoucherCommand());
		
	}
	
	public void registerEvents() {
		
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new VouchersEvents(), instance);
		
	}
	
	public static VouchersMain getInstance() {
		
		return instance;
		
	}
	
}

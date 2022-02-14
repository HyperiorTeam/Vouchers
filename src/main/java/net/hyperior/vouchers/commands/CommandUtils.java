package net.hyperior.vouchers.commands;

import net.md_5.bungee.api.ChatColor;

public class CommandUtils {
	
	public static String getHelp() {
		
		return ChatColor.GREEN + "----- Vouchers -----" + "\n" + 
		ChatColor.YELLOW + "/vouchers give [player] [amount]" + ChatColor.GREEN + " - Gives vouchers to the given player." + "\n" + 
		ChatColor.YELLOW + "/vouchers help" + ChatColor.GREEN + " - Shows this command list.";
		
	}
	
}

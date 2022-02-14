package net.hyperior.vouchers.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.hyperior.items.VoucherItemManager;
import net.md_5.bungee.api.ChatColor;

public class VoucherCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(args.length == 0) {sender.sendMessage(CommandUtils.getHelp()); return false;}
		
		if(args[0].equals("help")) sender.sendMessage(CommandUtils.getHelp());
		
		else if(args[0].equals("give")) {
			
			Player player = Bukkit.getPlayer(args[1]);
			
			if(args.length != 3) {sender.sendMessage(ChatColor.RED + "Invalid args length!"); return false;}
			if(player == null) {sender.sendMessage(ChatColor.RED + "The given player was not found"); return false;}
			if(!args[2].matches("\\d+")) {sender.sendMessage(ChatColor.RED + "Argument 3 must be a number!"); return false;}
			
			Integer amount = Integer.parseInt(args[2]);
			
			if(VoucherItemManager.giveItem(player, amount)) {
				
				sender.sendMessage(ChatColor.GREEN + "Successfully sent the vouchers!");
				
			}else {
				
				sender.sendMessage(ChatColor.RED + "The player inventory is full!");
				
			}
			
			
		}
		
		return false;
		
	}
	
}

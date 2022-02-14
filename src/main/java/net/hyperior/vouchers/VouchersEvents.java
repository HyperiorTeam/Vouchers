package net.hyperior.vouchers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

public class VouchersEvents implements Listener {
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		
		Player player = event.getPlayer();
		Action action = event.getAction();
		ItemStack item = event.getItem();
		
		
		if(!action.equals(Action.RIGHT_CLICK_AIR) && !action.equals(Action.RIGHT_CLICK_BLOCK)) return;
		if(item == null) return;
		if(item.getItemMeta().getLore() == null) return;
		if(item.getItemMeta().getLore().size() != 1) return;
		
		String hiddenLore = item.getItemMeta().getLore().get(0);
		
		if(!hiddenLore.replaceAll(String.valueOf(ChatColor.COLOR_CHAR), "").equals("Vouchers.isVoucher")) return;
		
		ItemStack remove = item.clone();
		remove.setAmount(1);
		
		player.getInventory().removeItem(remove);
		
		player.sendMessage(ChatColor.translateAlternateColorCodes('&', VouchersMain.getInstance().getConfig().getString("redeem-message")));
		
		for(String command : VouchersMain.getInstance().getConfig().getStringList("commands")) {
			
			command = command.replaceAll("<player>", player.getName());
			
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command);
			
		}
		
	}
	
}

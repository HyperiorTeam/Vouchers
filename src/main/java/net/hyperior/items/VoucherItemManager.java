package net.hyperior.items;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class VoucherItemManager {
	
	public static boolean giveItem(Player player, int amount) {
		
		Inventory playerInv = player.getInventory();
		
		ItemStack voucher = new ItemStack(Material.PAPER, amount);
		ItemMeta meta = voucher.getItemMeta();
		
		List<String> lore = new ArrayList<String>();
		
		lore.add(getHiddenLore());
		
		meta.setLore(lore);
		meta.setDisplayName(ChatColor.GREEN + "Voucher");
		
		voucher.setItemMeta(meta);
		
		if(!hasSpace(playerInv, voucher)) return false;
		
		playerInv.addItem(voucher);
		
		return true;
		
	}
	
	public static String getHiddenLore() {
		
		String message = "Vouchers.isVoucher";
		StringBuilder builder = new StringBuilder();
		
		for(char c : message.toCharArray()){
			
			builder.append(ChatColor.COLOR_CHAR).append(c);
			
		}
		
		String hidden = builder.toString();
		
		return hidden;
		
	}
	
	public static boolean hasSpace(Inventory inv, ItemStack item) {
		
		Inventory tempInv = Bukkit.createInventory(null, InventoryType.PLAYER);
		ItemStack tempItem = item.clone();
		
		tempInv.setContents(inv.getContents());
		
		tempItem.setAmount(item.getAmount() + 320);
		
		Map<Integer, ItemStack> failedItems = tempInv.addItem(tempItem);
		
		if(!failedItems.isEmpty()) return false;
		
		return true;
		
	}
	
}

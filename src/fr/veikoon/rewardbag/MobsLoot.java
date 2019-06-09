package fr.veikoon.rewardbag;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MobsLoot implements Listener {
	
	private RewardBag main;
	
	public MobsLoot(RewardBag helloworld) {

		this.main = helloworld;
		
		
	}

	@EventHandler
	public void onKill(EntityDeathEvent e) {
		if(main.getActivate()) {
			int random = rdm();
			
			if(random != 0) {
				
				Entity entity = e.getEntity();
				World world = entity.getLocation().getWorld();
				world.dropItem(entity.getLocation(), new Bag(random,main).getItem());
				
			}
		}
		
	}

	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		ItemStack it = e.getItem();
		
		if(it == null) return;
		
		if(it.getType() == Material.TURTLE_EGG && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equals("RewardBag")) {
			
			e.setCancelled(true);
			Inventory inv = Bukkit.createInventory(null, main.getConfig().getInt("config.general.inventory_size"), "§" + main.getConfig().getString("config.general.inventory_color") + main.getConfig().getString("config.general.inventory_name"));
			String rarete = it.getItemMeta().getLore().get(0).substring(2, it.getItemMeta().getLore().get(0).length());
			int test =  main.getConfig().getConfigurationSection(rarete).getKeys(false).size();
			double rdm = Math.random() * test;
			int i = 0;
			
			for(String bag : main.getConfig().getConfigurationSection(rarete).getKeys(false)) {
				
				if(i == (int)rdm) {
					
					for(String string : main.getConfig().getConfigurationSection(rarete+"."+bag).getKeys(false)) {
						
						inv.setItem(Integer.valueOf(string),new ItemStack(Material.valueOf(main.getConfig().getString(rarete+"."+bag+"."+string+".type")), main.getConfig().getInt(rarete+"."+bag+"."+string+".number")));
					
					}
					
				}
				
				i++;
			}

			player.openInventory(inv);
			player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount()-1);
			player.updateInventory();
		}
	}
	
	
	private int rdm() {
		
		double nbr = 1 + Math.random() * 100;
		if(nbr <= main.getConfig().getInt("config.epique.rate")) return 3;
		if(nbr <= main.getConfig().getInt("config.rare.rate")) return 2;
		if(nbr <= main.getConfig().getInt("config.commun.rate")) return 1;
		return 0;
		
	}
	
}

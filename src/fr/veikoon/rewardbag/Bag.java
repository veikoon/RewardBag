package fr.veikoon.rewardbag;

import java.util.Arrays;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Bag {
	
	private ItemStack aItem;
	private int aType;
	private RewardBag main;
	
	public Bag(final int pType, final int pNumber, final RewardBag RewardBag) {
		this.aType = pType;
		this.main = RewardBag;
		ItemStack rewardbag = new ItemStack(Material.TURTLE_EGG, pNumber);
		ItemMeta customM = rewardbag.getItemMeta();
		customM.setDisplayName("RewardBag");
		customM.setLore(Arrays.asList(type(pType),"Ouvrez le et vous obtiendrez une recompense"));
		customM.addEnchant(Enchantment.ARROW_DAMAGE, 0, true);
		customM.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		rewardbag.setItemMeta(customM);
		this.aItem = rewardbag;
	}
	
	public Bag(final int pType, final RewardBag RewardBag) {
		this(pType, 1, RewardBag);
	}
	
	public ItemStack getItem() {
		return this.aItem;
	}
	
	public int getType() {
		return this.aType;
	}
	
	private String type(final int pType) {
		switch(pType) {
		case 1:
			return "§" + main.getConfig().getString("config.commun.color") + main.getConfig().getString("config.commun.name");
		case 2:
			return "§" + main.getConfig().getString("config.rare.color") + main.getConfig().getString("config.rare.name");
		case 3:
			return "§" + main.getConfig().getString("config.epique.color") + main.getConfig().getString("config.epique.name");
		default:
			return "";
		}
	}
	
}

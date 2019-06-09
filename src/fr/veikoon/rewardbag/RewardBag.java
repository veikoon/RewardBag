package fr.veikoon.rewardbag;

import org.bukkit.plugin.java.JavaPlugin;

import Commands.Commands;

public class RewardBag extends JavaPlugin {

	@Override
	public void onEnable() {
		
		saveDefaultConfig();
		getLogger().info("Le plugin RewardBag s'est correctement allume");
		getCommand("reward").setExecutor(new Commands(this));
		getServer().getPluginManager().registerEvents(new MobsLoot(this), this);
		
	}
	
	@Override
	public void onDisable() {
		
		getLogger().info("Le plugin RewardBag s'est correctement eteint");
		
	}
	
}

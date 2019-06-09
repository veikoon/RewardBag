package fr.veikoon.rewardbag;

import org.bukkit.plugin.java.JavaPlugin;

import Commands.Commands;

public class RewardBag extends JavaPlugin {

	private boolean isActivate;
	
	@Override
	public void onEnable() {
		
		saveDefaultConfig();
		setActivate(getConfig().getBoolean("config.general.activate_drop"));
		getCommand("reward").setExecutor(new Commands(this));
		getServer().getPluginManager().registerEvents(new MobsLoot(this), this);
		getLogger().info("Le plugin RewardBag s'est correctement allume");

	}
	
	@Override
	public void onDisable() {
		
		getLogger().info("Le plugin RewardBag s'est correctement eteint");
		
	}
	
	public void setActivate(final boolean pActivate) {
		this.isActivate = pActivate;
	}
	
	public boolean getActivate() {
		return this.isActivate;
	}
	
}

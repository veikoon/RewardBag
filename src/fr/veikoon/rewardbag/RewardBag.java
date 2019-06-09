package fr.veikoon.rewardbag;

import org.bukkit.plugin.java.JavaPlugin;

public class RewardBag extends JavaPlugin {

	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		saveDefaultConfig();
		System.out.println("Le plugin est bien allume");
		getCommand("rw").setExecutor(new CommandTest(this));
		getServer().getPluginManager().registerEvents(new MobsLoot(this), this);
	}
	
	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		System.out.println("Le plugin est bien eteint");
	}
}

package Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.veikoon.rewardbag.Bag;
import fr.veikoon.rewardbag.RewardBag;

public class Commands implements CommandExecutor {

	private RewardBag main;
	public Commands(RewardBag RewardBag) {
		// TODO Auto-generated constructor stub
		this.main = RewardBag;
	}

	@Override
	public boolean onCommand(CommandSender player, Command arg1, String arg2, String[] arg3) {
		
		if(arg3.length == 0 || arg3[0].equalsIgnoreCase("help")) {
			player.sendMessage("§7===== §bRewardBag §7=====");
			player.sendMessage("§b/reward give §rPermet de give des RewardBag");
			player.sendMessage("§b/reward stop §rDesactive les drops");
			player.sendMessage("§b/reward start §rActive les drops");
			player.sendMessage("");
		}
					
		if(arg3[0].equalsIgnoreCase("give")) {
			
			if(player instanceof Player) {
				
				if(arg3.length==1 || Integer.valueOf(arg3[1]) >3 || Integer.valueOf(arg3[1]) <1) {
					
					player.sendMessage("");
					player.sendMessage("§bVous devez indiquer le type de RewardBag !");
					player.sendMessage("§b1-Commun 2-Rare 3-Epique");
					player.sendMessage("§b/reward give [Rarity 1-3] [Ammount]");
					player.sendMessage("");
					
				}
				
				else if (arg3.length == 2) {
					player.sendMessage("§bVous devez indiquer le nombre de RewardBag");
					player.sendMessage("§b/reward give [Rarity 1-3] [Ammount]");
				}
				
				else{
					
					((Player) player).getInventory().addItem(new Bag(Integer.valueOf(arg3[1]),Integer.valueOf(arg3[2]),main).getItem());
					
				}
									
			}
			
			else player.sendMessage("Vous devez etre un joueur pour executer cette commande !");
			
		}
		
		if(arg3[0].equalsIgnoreCase("stop")) {
			main.setActivate(false);
			main.getConfig().set("config.general.activate_drop", false);
			main.saveConfig();
			player.sendMessage("§bLe plugin RewardBag est desactive");
		}
		
		if(arg3[0].equalsIgnoreCase("start")) {
			main.setActivate(true);
			main.getConfig().set("config.general.activate_drop", true);
			main.saveConfig();
			player.sendMessage("§bLe plugin RewardBag est active");
		}
		
		if(arg3[0].equalsIgnoreCase("set")) {
			
			if(arg3.length==1) {
				
				player.sendMessage("§b/reward set inv");
				player.sendMessage("§b/reward set commun");
				player.sendMessage("§b/reward set rare");
				player.sendMessage("§b/reward set epique");
				player.sendMessage("");
				
			}
			
			else if(arg3[1].equalsIgnoreCase("inv")) {
				if(arg3.length==2) {
					player.sendMessage("§b/reward set inv color");
					player.sendMessage("§b/reward set inv size");
					player.sendMessage("");
				}
				else if(arg3[2].equalsIgnoreCase("color")) setConfig("config.general.inventory_color", Integer.valueOf(arg3[3]));
				else if(arg3[2].equalsIgnoreCase("size")) setConfig("config.general.inventory_size", Integer.valueOf(arg3[3]));
				
			}
			
			else if(arg3[1].equalsIgnoreCase("commun")) {
				if(arg3.length==2) {
					player.sendMessage("§b/reward set commun color");
					player.sendMessage("§b/reward set commun rate");
					player.sendMessage("");
				}
				else if(arg3[2].equalsIgnoreCase("color")) setConfig("config.commun.color", Integer.valueOf(arg3[3]));
				else if(arg3[2].equalsIgnoreCase("rate")) setConfig("config.commun.rate", Integer.valueOf(arg3[3]));
			
			}
			
			else if(arg3[1].equalsIgnoreCase("rare")) {
				if(arg3.length==2) {
					player.sendMessage("§b/reward set rare color");
					player.sendMessage("§b/reward set rare rate");
					player.sendMessage("");
				}
				else if(arg3[2].equalsIgnoreCase("color")) setConfig("config.rare.color", Integer.valueOf(arg3[3]));
				else if(arg3[2].equalsIgnoreCase("rate")) setConfig("config.rare.rate", Integer.valueOf(arg3[3]));
			
			}
			
			else if(arg3[1].equalsIgnoreCase("epique")) {
				if(arg3.length==2) {
					player.sendMessage("§b/reward set epique color");
					player.sendMessage("§b/reward set epique rate");
					player.sendMessage("");
				}
				else if(arg3[2].equalsIgnoreCase("color")) setConfig("config.epique.color", Integer.valueOf(arg3[3]));
				else if(arg3[2].equalsIgnoreCase("rate")) setConfig("config.epique.rate", Integer.valueOf(arg3[3]));
			
			}
			
		}
		
		
		
		return true;
	}
	
	public void setConfig(final String pLocate, final Object pObj) {
		
		main.getConfig().set(pLocate,pObj);
		main.saveConfig();
		
	}

}

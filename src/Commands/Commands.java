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
		
		if(arg3.length == 0 || arg3[0].equals("help")) {
			player.sendMessage("§7===== §bRewardBag §7=====");
			player.sendMessage("§b/reward give [Rarity 1-3] [Ammount]");
			player.sendMessage("");
		}
					
		if(arg3[0].equals("give")) {
			
			if(player instanceof Player) {
				
				if(arg3.length==1 || Integer.valueOf(arg3[1]) >=3 || Integer.valueOf(arg3[1]) <=1) {
					
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
		
		return true;
	}

}

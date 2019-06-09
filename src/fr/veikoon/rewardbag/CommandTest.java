package fr.veikoon.rewardbag;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTest implements CommandExecutor {

	private RewardBag main;
	public CommandTest(RewardBag RewardBag) {
		// TODO Auto-generated constructor stub
		this.main = RewardBag;
	}

	@Override
	public boolean onCommand(CommandSender player, Command arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		if(arg3[0].equals("give")) {
			if(player instanceof Player) {
				if(Integer.valueOf(arg3[1]) <=3 && Integer.valueOf(arg3[1]) >=1) {
					((Player) player).getInventory().addItem(new Bag(Integer.valueOf(arg3[1]),Integer.valueOf(arg3[2]),main).getItem());
				}
				else player.sendMessage("Vous devez indiquer le type de RewardBag !\n1-Commun 2-Rare 3-Epique");
			}
			else player.sendMessage("Vous devez etre un joueur pour executer cette commande !");
		}
		
		return true;
	}

}

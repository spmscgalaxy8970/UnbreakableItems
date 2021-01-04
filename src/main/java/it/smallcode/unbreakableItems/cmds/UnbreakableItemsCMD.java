package it.smallcode.unbreakableItems.cmds;
/*

Class created by SmallCode
04.01.2021 17:41

*/

import it.smallcode.unbreakableItems.UnbreakableItems;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class UnbreakableItemsCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender s, Command c, String label, String[] args) {

        if(args.length == 1 && args[0].equalsIgnoreCase("reload")){

            if(s.hasPermission("unbreakableitems.reload")){

                if(!UnbreakableItems.getUnbreakableItems().loadConfig()){

                    s.sendMessage(UnbreakableItems.PREFIX + "Couldn't load config");
                    Bukkit.getConsoleSender().sendMessage(UnbreakableItems.PREFIX + "Couldn't load config");

                    return false;

                }

                s.sendMessage(UnbreakableItems.PREFIX + "Reloaded config!");

            }else{

                s.sendMessage(UnbreakableItems.PREFIX + "No permissions!");

            }

        }else{

            s.sendMessage(UnbreakableItems.PREFIX + "/unbreakableitems reload");

        }

        return false;

    }
}

package it.smallcode.unbreakableItems.listener;
/*

Class created by SmallCode
04.01.2021 16:58

*/

import it.smallcode.unbreakableItems.ItemType;
import it.smallcode.unbreakableItems.UnbreakableItems;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class ItemUseListener implements Listener {

    @EventHandler
    public void onItemUse(PlayerItemDamageEvent e){

        if(UnbreakableItems.getUnbreakableItems().getSettings() == null)
            return;

        if(e.getItem() == null)
            return;

        if(!UnbreakableItems.getUnbreakableItems().getSettings().isDeactivatedInWorld(e.getPlayer().getWorld())){

            if(ItemType.ARMOR.contains(e.getItem().getType())) {

                if (UnbreakableItems.getUnbreakableItems().getSettings().isArmorUnbreakable())
                    e.setCancelled(true);

                return;

            }

            if(ItemType.SWORDS.contains(e.getItem().getType())) {

                if (UnbreakableItems.getUnbreakableItems().getSettings().isSwordsUnbreakable())
                    e.setCancelled(true);

                return;

            }

            if(ItemType.PICKAXES.contains(e.getItem().getType())) {

                if (UnbreakableItems.getUnbreakableItems().getSettings().isPickaxeUnbreakable())
                    e.setCancelled(true);

                return;

            }

            if(ItemType.AXE.contains(e.getItem().getType())) {

                if (UnbreakableItems.getUnbreakableItems().getSettings().isAxeUnbreakable())
                    e.setCancelled(true);

                return;

            }

            if(ItemType.HOE.contains(e.getItem().getType())) {

                if (UnbreakableItems.getUnbreakableItems().getSettings().isHoeUnbreakable())
                    e.setCancelled(true);

                return;

            }

            if(ItemType.SHOVEL.contains(e.getItem().getType())) {

                if (UnbreakableItems.getUnbreakableItems().getSettings().isShovelUnbreakable())
                    e.setCancelled(true);

                return;

            }

            if(UnbreakableItems.getUnbreakableItems().getSettings().isItemsUnbreakable())
                e.setCancelled(true);

        }

    }

}

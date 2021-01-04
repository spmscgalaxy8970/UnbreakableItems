package it.smallcode.unbreakableItems;
/*

Class created by SmallCode
04.01.2021 17:31

*/

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.World;

import java.util.List;

@AllArgsConstructor
@Getter
public class Settings {

    private boolean swordsUnbreakable;
    private boolean pickaxeUnbreakable;
    private boolean axeUnbreakable;
    private boolean shovelUnbreakable;
    private boolean hoeUnbreakable;
    private boolean itemsUnbreakable;
    private boolean armorUnbreakable;

    private List<String> deactivatedInWorlds;

    public boolean isDeactivatedInWorld(World world){

        if(world != null)
            return deactivatedInWorlds.contains(world.getName());

        return false;

    }

}

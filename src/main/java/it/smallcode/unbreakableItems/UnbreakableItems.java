package it.smallcode.unbreakableItems;
/*

Class created by SmallCode
04.01.2021 16:35

*/

import it.smallcode.unbreakableItems.cmds.UnbreakableItemsCMD;
import it.smallcode.unbreakableItems.listener.ItemUseListener;
import lombok.AccessLevel;
import lombok.Getter;
import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.LinkedList;
import java.util.List;

public class UnbreakableItems extends JavaPlugin {

    @Getter
    private static UnbreakableItems unbreakableItems;

    public static final String PREFIX = "§8[§cUnbreakableItems§8] §7";

    @Getter(AccessLevel.PUBLIC)
    private Settings settings;

    @Override
    public void onEnable() {

        unbreakableItems = this;

        initConfig();

        if(!loadConfig()) {

            Bukkit.getConsoleSender().sendMessage(PREFIX + "Couldn't load config");

            return;

        }

        Bukkit.getPluginManager().registerEvents(new ItemUseListener(), this);

        Bukkit.getPluginCommand("unbreakableitems").setExecutor(new UnbreakableItemsCMD());

        new Metrics(this, 9887);

    }

    public void initConfig(){

        FileConfiguration cfg = this.getConfig();

        cfg.addDefault("swordsUnbreakable", true);
        cfg.addDefault("pickaxeUnbreakable", true);
        cfg.addDefault("axeUnbreakable", true);
        cfg.addDefault("shovelUnbreakable", true);
        cfg.addDefault("hoeUnbreakable", true);
        cfg.addDefault("itemsUnbreakable", true);
        cfg.addDefault("armorUnbreakable", true);

        cfg.addDefault("deactivateInWorlds", new LinkedList<>());

        getConfig().options().copyDefaults(true);

        saveConfig();
        reloadConfig();

    }

    public boolean loadConfig(){

        try {

            reloadConfig();

            FileConfiguration cfg = this.getConfig();

            settings = new Settings(
                    cfg.getBoolean("swordsUnbreakable"),
                    cfg.getBoolean("pickaxeUnbreakable"),
                    cfg.getBoolean("axeUnbreakable"),
                    cfg.getBoolean("shovelUnbreakable"),
                    cfg.getBoolean("hoeUnbreakable"),
                    cfg.getBoolean("itemsUnbreakable"),
                    cfg.getBoolean("armorUnbreakable"),
                    (List<String>) cfg.getList("deactivateInWorlds"));

            return true;

        }catch(Exception ex){

            ex.printStackTrace();

            settings = null;

            return false;

        }

    }
}

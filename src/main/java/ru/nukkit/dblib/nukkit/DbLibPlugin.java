package ru.nukkit.dblib.nukkit;

import cn.nukkit.plugin.PluginBase;
import ru.nukkit.dblib.DbLib;
import ru.nukkit.dblib.core.M;

public class DbLibPlugin extends PluginBase {


    private static DbLibPlugin plugin;

    public static DbLibPlugin getPlugin() {
        return plugin;
    }

    @Override
    public void onLoad() {
        plugin = this;
        this.saveDefaultConfig();
        ConfigNukkit cfg = new ConfigNukkit(this);
        cfg.load();
        M.init("DbLib", new MessengerNukkit(this), cfg.language, cfg.debugMode, cfg.saveLanguage);
        DbLib.init(cfg, this.getDataFolder());
        getLogger().info("DbLib " + this.getDescription().getVersion() + " created by fromgate");
    }


}

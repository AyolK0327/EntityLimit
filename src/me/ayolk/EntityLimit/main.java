package ayolk.EntityLimit;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin{
    static FileConfiguration config = null;

    @Override
    public void onLoad() {
        super.onLoad();
    }

    @Override
    public void onEnable() {
        super.onEnable();
        saveDefaultConfig();
        config = getConfig();
        this.getServer().getPluginManager().registerEvents(new PlayerJoinEvent1(this), this);
        this.getServer().getPluginManager().registerEvents(new EntitySpawnEvent1(this), this);
    }


    @Override
    public void onDisable() {
        super.onDisable();
    }
}

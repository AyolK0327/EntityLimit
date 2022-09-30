package ayolk.EntityLimit;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.Plugin;

import static ayolk.EntityLimit.main.config;


public class EntitySpawnEvent1 implements Listener {
    private final Plugin dp;

    public EntitySpawnEvent1(Plugin dp) {
        this.dp = dp;
    }

    @EventHandler
    public void onEntitySpawn(CreatureSpawnEvent event){
        if(event.getEntity().getType().equals(EntityType.WITHER) || event.getEntity().getType().equals(EntityType.ENDER_DRAGON)){
            return;
        }
        if(Bukkit.getOnlinePlayers().size() >= config.getInt("Limit") ){
            event.getEntity().setAI(false);
        }
    }
}

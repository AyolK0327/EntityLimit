package ayolk.EntityLimit;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import static ayolk.EntityLimit.main.*;

import java.util.List;

public class PlayerJoinEvent1 implements Listener {

    private final List<World> world = Bukkit.getWorlds();
    public PlayerJoinEvent1(Plugin dp) {
    }
    static boolean WasIn = false;
    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event){

        if(getPlayerOnline() >= config.getInt("Limit") && !WasIn ){
            getShutdownAI();
        }else if(getPlayerOnline() < 10){
            WasIn = true;
            getOpenAI();
        }
    }
    public int getPlayerOnline(){
        return Bukkit.getOnlinePlayers().size();
    }
    public void getOpenAI(){
        for(World a : world){
            List<LivingEntity> LivingEntities = a.getLivingEntities();
            for (LivingEntity b : LivingEntities){
                b.setAI(!b.hasAI());
            }
        }
    }
    public void getShutdownAI(){
        for(World a : world){
            List<LivingEntity> LivingEntities = a.getLivingEntities();
            for (LivingEntity b : LivingEntities){
                b.setAI(b.hasAI());
            }
        }
    }

}

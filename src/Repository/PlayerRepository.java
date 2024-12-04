package Repository;

import Entities.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerRepository {
    public static Map<String, Player> getPlayer(){
        return playerMap;
    }
    public PlayerRepository(){
        playerMap=new HashMap<>();
    }
    static Map<String,Player> playerMap;
}

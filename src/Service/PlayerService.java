package Service;

import Entities.Player;
import Repository.PlayerRepository;

import java.util.Map;
import java.util.Scanner;

public class PlayerService {
    static void initializePlayerService(Scanner scanner){
        PlayerRepository playerRepository=new PlayerRepository();
        Map<String,Player> playerMap = playerRepository.getPlayer();
        System.out.println("Enter Number of players");
        int playerNum=scanner.nextInt();
        scanner.nextLine();

        while((playerNum--)>0){
            String playerName=scanner.nextLine();
            Player player=new Player(playerName,0);
            playerMap.put(playerName,player);
        }
    }
}

package Service;

import Entities.Board;
import Entities.Player;
import Repository.PlayerRepository;
import Util.DiceUtil;

import java.util.Scanner;

public class BoardService {
    //roll dice
    //move player
    // check for snake or ladder or winning index

    static Board board;

    int rollDice(){
        int diceValue= DiceUtil.getDiceValue();
        return diceValue;
    }

    int movePlayer(String playerName){
       Player player= PlayerRepository.getPlayer().get(playerName);
       int currPos=player.getCurrPos();
       if (currPos==board.getEnd()) {
           throw new RuntimeException("Game Over!");
       }
       int diceValue=rollDice();
        int updatedPos = diceValue + currPos;
        if(SnakeService.isSnakePos(updatedPos)){
            updatedPos=SnakeService.reachSnakeTail(updatedPos);
        }

        if(LadderService.isLadderPos(updatedPos)){
          updatedPos = LadderService.reachLadderTop(updatedPos);
        }

        if(updatedPos>board.getEnd()){
            updatedPos=currPos;
        }
        if (updatedPos<=board.getEnd()){
            player.setCurrPos(updatedPos);
            System.out.println(playerName+ " rolled a "+ diceValue+"and Move from "+currPos+"to"+updatedPos );
        }
        if (updatedPos==board.getEnd()){
            player.setCurrPos(updatedPos);
            System.out.println(playerName+" wins the game");
        }
        return updatedPos;
    }
    public void startGame(){
        while (true){
            PlayerRepository.getPlayer().keySet().forEach(PlayerName -> {
                int updatedPos = movePlayer(PlayerName);
                if(updatedPos==board.getEnd()) return;
            });
        }
    }
    static void initializeBoard(Scanner scanner){
        System.out.println("Enter 'boardSize' start end");
        String[] boardInp = scanner.nextLine().trim().split(" ");
        board=new Board(Integer.parseInt(boardInp[0]),Integer.parseInt(boardInp[1]),Integer.parseInt(boardInp[2]));
    }
}

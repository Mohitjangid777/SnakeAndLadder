package Service;

import Repository.SnakeRepository;

import java.util.Map;
import java.util.Scanner;

public class SnakeService {
    //check the position for dice if the dice is on the snake pos.
    static boolean isSnakePos(int pos){
        if(SnakeRepository.getStartLastMap().containsKey(pos))
            return true;
        else
            return false;
    }
    
    static int reachSnakeTail(int pos){
        return SnakeRepository.getStartLastMap().get(pos);
    }
    
    static void initializeSnakeRepository(Scanner scanner){
        SnakeRepository snakeRepository=new SnakeRepository();
        Map<Integer, Integer> snakeMap = snakeRepository.getStartLastMap();

        System.out.println("enter number of Snakes");
        int snakeNum = scanner.nextInt();
        scanner.nextLine();

        while ((snakeNum--)>0){
            String[] snakePos = scanner.nextLine().trim().split(" ");
           int start= Integer.parseInt(snakePos[0]);
           int end= Integer.parseInt(snakePos[0]);
        }

    }
}

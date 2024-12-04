package Service;

import Repository.LadderRepository;

import java.util.Map;
import java.util.Scanner;

public class LadderService {

    static boolean isLadderPos(int pos){
          if (LadderRepository.getStartLastMap().containsKey(pos))
            return true;
        else
                return false;
}
    static int reachLadderTop(int Pos){
      return LadderRepository.getStartLastMap().get(Pos);
}
    static void initializeLadderRepository(Scanner scanner){
        LadderRepository ladderRepository=new LadderRepository();
        Map<Integer, Integer> ladderMap = ladderRepository.getStartLastMap();
        System.out.println("Enter Number of ladders");
        int ladderNum=scanner.nextInt();
        scanner.nextLine();

        while ((ladderNum--)>0){
            String[] laddePos = scanner.nextLine().split(" ");
            int start=Integer.parseInt(laddePos[0]);
            int end=Integer.parseInt(laddePos[1]);
            ladderMap.put(start,end);
        }
    }
}

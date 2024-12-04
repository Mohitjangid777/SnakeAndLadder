import Service.BoardService;
import Service.InMemoryService;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Application {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        InMemoryService inMemoryService=new InMemoryService(scanner);
        BoardService service=new BoardService();
        try {
            service.startGame();
        }catch (Exception x){
            System.out.println(x.getMessage());
        }
    }
}
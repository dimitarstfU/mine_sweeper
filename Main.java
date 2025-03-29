import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        boolean game_over = false;
        Scanner scanner = new Scanner(System.in);
        Board board = new Board(30, 30);


        while(!game_over)
        {
            System.out.println("Choose row and column");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            game_over = board.discover(row, column);
            board.print();
        }
        System.out.println("game_over");
        scanner.close();
        
    }    
}

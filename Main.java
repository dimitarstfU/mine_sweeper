import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        boolean game_over = false;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose row and column");
        int st_row = scanner.nextInt();
        int st_column = scanner.nextInt();

        Board board = new Board(30, 30, st_row, st_column);
        board.discover(st_row, st_column);
        board.print();

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

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        boolean game_over = false;
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Choose starting row and column");
        int st_row = scanner.nextInt();
        int st_column = scanner.nextInt();

        Board board = new Board(10, 10, st_row, st_column);
        board.discover(st_row, st_column);
        board.print();

        while(!game_over)
        {
            if(board.winning())
            {
                System.out.println("you won");
                break;
            }
            System.out.println("Choose row and column");
            int row = scanner.nextInt();
            int column = scanner.nextInt();
            game_over = board.discover(row, column);
            board.print();
        }
        if(game_over)
        {
            System.out.println("you lose");
        }
        scanner.close();
        
    }    
}

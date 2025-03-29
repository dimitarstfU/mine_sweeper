import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board
{
    Field[][] board;
    Board(int n,int m)
    {
        board = new Field[n][m];
        for (int i=0;i<n;i++)
        {
            for (int j=0;j<m;j++) 
            {
                Random rand = new Random();
                int randomNum = rand.nextInt(100);
                if(randomNum >= 90)
                {
                    board[i][j] = new Mine(true);
                }
                else
                {
                    List<Field> neighbors = new ArrayList<Field>();
                    board[i][j] = new Empty(neighbors, true);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0; j<m;j++)
            {
                if(board[i][j] instanceof Empty)
                {
                    for(int k=-1;k<2;k++)
                    {
                        if(i+k<0 || i+k>n-1)
                        {
                            continue;
                        }
                        for(int p=-1; p<2;p++)
                        {
                            if(j+p<0 || j+p>m-1)
                            {
                                continue;
                            }
                            Empty field = (Empty) board[i][j];
                            field.neighbors.add(board[i+k][j+p]);
                        }
                    }
                }    
            }
        }
    }
    void print()
    {
        for (Field[] fields : board)
        {
            for (Field field : fields) 
            {
                System.out.print(field.view());    
            }
            System.out.print("\n");    
        }
    }
    boolean discover(int row, int column)
    {
        Field field = board[row][column];
        if(field instanceof Mine)
        {
            for (Field[] fields : board)
            {//otkrivam vsichki poleta za da izpechatam duskata
                for (Field field1 : fields) 
                {
                    field1.hidden = false;    
                }   
            }   
            return true;//ima bomba
        }
        field.hidden = false;//nqma bomba i otkrivam samo tova pole
        return false;//nqma bomba
    }    
}

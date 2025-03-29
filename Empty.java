import java.util.List;

public class Empty extends Field
{
    List<Field> neighbors;
    Empty(List<Field> neighbors,boolean hidden)
    {
        this.hidden = hidden;
        this.neighbors = neighbors;
    }
    @Override
    public char view()
    {
        if(hidden)
        {
            return '-';
        }
        else
        {
            int br = 0;
            for (Field field : neighbors)
            {
                if(field instanceof Mine) {br++;}    
            }
            if (br == 0) 
            {
                return ' ';
            }
            return (char) ('0' + br);
        }    
    }
    public boolean island()
    {
        int br = 0;
        for (Field field : neighbors)
        {
            if(field instanceof Mine) {br++;}    
        }
        return br == 0 ? true : false;
    }
    public void uncoverSurrounding()
    {
        this.hidden = false;
        for (Field neighbor : neighbors)
        {
            if(((Empty) neighbor).island() && neighbor.hidden)
            {
                ((Empty)neighbor).uncoverSurrounding();
            }
            else 
            {
                neighbor.hidden = false;
            }
        }
    }
}

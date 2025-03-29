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
            return (char) ('0' + br);
        }    
    }
}

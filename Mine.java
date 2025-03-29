public class Mine extends Field
{
    Mine(boolean hidden)
    {
        this.hidden = hidden;
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
            return 'X';
        }    
    }       
}

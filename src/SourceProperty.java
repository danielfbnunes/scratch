public class SourceProperty extends Property
{
  protected static boolean defined;

  public SourceProperty ()
  {
    super("source");
    defined = false;
  }
  
  @Override
  public String getExprType ()
  {
    defined = true;
    return "string";
  }
  
  @Override
  public boolean isDefined ()
  {
    return defined;
  }
}

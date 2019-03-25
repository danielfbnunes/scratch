public class WidthProperty extends Property
{
  protected static boolean defined;

  public WidthProperty ()
  {
    super("width");
    defined = false;
  }
  
  @Override
  public String getExprType ()
  {
    defined = true;
    return "number";
  }
  
  @Override
  public boolean isDefined ()
  {
    return defined;
  }
}

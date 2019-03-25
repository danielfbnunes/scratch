public class NSidesProperty extends Property
{
  protected static boolean defined;

  public NSidesProperty ()
  {
    super("nSides");
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

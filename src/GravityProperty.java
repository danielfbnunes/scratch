public class GravityProperty extends Property
{
  protected static boolean defined;

  public GravityProperty ()
  {
    super("gravity");
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
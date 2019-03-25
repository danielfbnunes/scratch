public class XPositionProperty extends Property
{
  protected static boolean defined;

  public XPositionProperty ()
  {
    super("xPosition");
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

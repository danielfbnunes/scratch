public class YPositionProperty extends Property
{
  protected static boolean defined;

  public YPositionProperty ()
  {
    super("yPosition");
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

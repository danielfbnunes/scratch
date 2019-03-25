public class HeightProperty extends Property
{
  protected static boolean defined;

  public HeightProperty ()
  {
    super("height");
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

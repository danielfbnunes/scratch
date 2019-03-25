public class RadiusProperty extends Property
{
  protected static boolean defined;

  public RadiusProperty ()
  {
    super("radius");
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

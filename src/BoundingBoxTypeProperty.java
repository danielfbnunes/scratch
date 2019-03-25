public class BoundingBoxTypeProperty extends Property
{
  protected static boolean defined;

  public BoundingBoxTypeProperty ()
  {
    super("boundingBoxType");
    defined = false;
  }
  
  @Override
  public String getExprType ()
  {
    defined = true;
    return "boolean";
  }
  
  @Override
  public boolean isDefined ()
  {
    return defined;
  }
}

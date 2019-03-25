public class CropProperty extends Property
{
  protected static boolean defined;

  public CropProperty ()
  {
    super("crop");
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

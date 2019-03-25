public class TypeProperty extends Property
{
  protected static boolean defined;

  public TypeProperty ()
  {
    super("type");
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

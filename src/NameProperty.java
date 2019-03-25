public class NameProperty extends Property
{
  protected static boolean defined;

  public NameProperty ()
  {
    super("name");
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

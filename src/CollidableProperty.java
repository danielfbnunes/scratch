public class CollidableProperty extends Property
{
  protected static boolean defined;

  public CollidableProperty ()
  {
    super("collidable");
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

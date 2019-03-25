public abstract class Property
{
  protected final String name;

  protected Property (String name)
  {
    assert name != null;
    this.name = name;
  }

  public String name ()
  {
    return name;
  }

  public boolean isNumeric ()
  {
    return false;
  }
  
  public String getExprType ()
  {
    return null;
  }
  
  public boolean isDefined ()
  {
    return false;
  }

  @Override
  public String toString ()
  {
    return name;
  }
}

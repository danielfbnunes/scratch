public abstract class Field
{
  protected final String name;

  protected Field (String name)
  {
    assert name != null;
    this.name = name;
  }

  public String name ()
  {
    return name;
  }
  
  public boolean contains (String p1)
  {
    return false;
  }
  
  public String getProps ()
  {
    return null;
  }
  
  public boolean isDefined ()
  {
    return false;
  }

  public boolean isNumeric ()
  {
    return false;
  }

  @Override
  public String toString ()
  {
    return name;
  }
}

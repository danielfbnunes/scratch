import java.util.ArrayList;
import java.util.List;

public class CostumeField extends Field
{
  protected final List<String> props = new ArrayList<>();
  protected static boolean defined = false;

  public CostumeField ()
  {
    super("costume");

    props.add("name");
    props.add("type");
    props.add("source");
  }
  
  @Override
  public boolean contains (String p1)
  {
    defined = true;
    return props.contains(p1);
  }
  
  @Override
  public String getProps()
  {
    StringBuilder sb = new StringBuilder();
    
    for (String prop : props)
      sb.append(prop + ", ");
    
    return sb.toString();
  }
  
  @Override
  public boolean isDefined ()
  {
    return defined;
  }
}

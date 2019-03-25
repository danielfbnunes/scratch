import java.util.ArrayList;
import java.util.List;

public class GeometryField extends Field
{
  protected final List<String> props = new ArrayList<>();
  protected static boolean defined;

  public GeometryField ()
  {
    super("geometry");
    defined = false;
    props.add("height");
    props.add("width");
    props.add("xPosition");
    props.add("yPosition");
    props.add("radius");
    props.add("nSides");
    props.add("boundingBoxType");
    props.add("crop");
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

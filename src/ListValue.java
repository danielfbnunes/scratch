import java.util.List;

public class ListValue extends Value
{
   public ListValue(List<Value> val)
   {
      setListValue(val);
   }

   @Override
   public Type type()
   {
      return type;
   }

   @Override
   public void setListValue(List<Value> val)
   {
      this.val = val;
   }

   @Override
   public List<Value> listValue()
   {
      return val;
   }

   @Override
   public String toString()
   {
      return ""+val;
   }

   private List<Value> val;

   private static ListType type = new ListType();
}


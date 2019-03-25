public class WindowValue extends Value
{
   public WindowValue(Window val)
   {
      setWindowValue(val);
   }

   @Override
   public Type type()
   {
      return type;
   }

   @Override
   public void setWindowValue(Window val)
   {
      this.val = val;
   }

   @Override
   public Window windowValue()
   {
      return val;
   }

   @Override
   public String toString()
   {
      return ""+val;
   }

   private Window val;

   private static WindowType type = new WindowType();
}


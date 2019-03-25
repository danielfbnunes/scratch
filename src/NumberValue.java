public class NumberValue extends Value
{
   public NumberValue(double val)
   {
      setNumberValue(val);
   }

   @Override
   public Type type()
   {
      return type;
   }

   @Override
   public void setNumberValue(double val)
   {
      this.val = val;
   }

   @Override
   public double numberValue()
   {
      return val;
   }

   @Override
   public String toString()
   {
      return ""+val;
   }

   private double val;

   private static NumberType type = new NumberType();
}


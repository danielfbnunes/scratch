import java.util.List;

abstract public class Value
{
   public Type type()
   {
      assert false;
      return null;
   }

   public void setIntValue(int val)
   {
      assert false;
   }

   public void setNumberValue(double val)
   {
      assert false;
   }

   public void setSpriteValue(Sprite val)
   {
      assert false;
   }

   public void setListValue(List<Value> val)
   {
      assert false;
   }

   public void setWindowValue(Window val)
   {
      assert false;
   }

   public void setBoolValue(boolean val)
   {
      assert false;
   }

   public double numberValue()
   {
      assert false;
      return 0;
   }

   public Sprite spriteValue()
   {
      assert false;
      return null;
   }

   public List<Value> listValue()
   {
      assert false;
      return null;
   }

   public Window windowValue()
   {
      assert false;
      return null;
   }

   public boolean boolValue()
   {
      assert false;
      return false;
   }

}


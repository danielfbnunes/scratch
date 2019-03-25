public class SpriteValue extends Value
{
   public SpriteValue(Sprite val)
   {
      setSpriteValue(val);
   }

   @Override
   public Type type()
   {
      return type;
   }

   @Override
   public void setSpriteValue(Sprite val)
   {
      this.val = val;
   }

   @Override
   public Sprite spriteValue()
   {
      return val;
   }

   @Override
   public String toString()
   {
      return ""+val;
   }

   private Sprite val;

   private static SpriteType type = new SpriteType();
}


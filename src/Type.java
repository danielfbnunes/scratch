import java.util.List;

public abstract class Type
{
   protected Type(String name) {
      assert name != null;
      this.name = name;
   }

   public String name() {
      return name;
   }

   public List<FunctionType> getMethod(String funcName) {
      return null;
   }

   public boolean hasMethod(String funcName) {
      return false;
   }

   public boolean conformsTo(Type other) {
      return name.equals(other.name());
   }

   public boolean isNumeric() {
      return false;
   }

   public boolean isBoolean() {
      return false;
   }

   protected Type getType(String type) {
       switch (type) {
           case "void": return new VoidType();
           case "number": return new NumberType();
           case "Sprite": return new SpriteType();
           case "List": return new ListType();
           case "string": return new StringType();
           case "boolean": return new BooleanType();
           default: return null;
       }
   }

   @Override
   public String toString()
   {
      return name;
   }

   protected final String name;
}


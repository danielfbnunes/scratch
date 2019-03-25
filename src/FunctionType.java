import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class FunctionType extends Type {

    private List<Type> argsList;
    private Type returnValue;
    public boolean isStatic = false;

    public FunctionType(Type returnValue) {
        super("function");
        argsList = new ArrayList<>();
        this.returnValue = returnValue;
    }

    public void addArg(Type arg) {
        argsList.add(arg); 
    }

    public List<Type> getArgs() {
        return Collections.unmodifiableList(argsList);
    }

    public Type getReturnValue() {
        return returnValue;
    }

    @Override
    public boolean conformsTo(Type other) {
        if (!this.name().equals(other.name()))
            return false;
        FunctionType o = (FunctionType) other;
        if (!this.returnValue.conformsTo(o.getReturnValue()))
            return false;
        if (!equalArgs(o.getArgs()))
            return false;
        return true;
    }

    private boolean equalArgs(List<Type> o) {
        if (argsList.size() != o.size())
            return false;
        for (int i = 0; i < argsList.size(); i++) {
            if (argsList.get(i) == null || o.get(i) == null)
                return false;
            if (!argsList.get(i).conformsTo(o.get(i)))
                return false;
        }
        return true;
    }
}

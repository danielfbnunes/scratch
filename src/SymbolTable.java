import java.util.Map;
import java.util.HashMap;

public class SymbolTable {
    
    private Node<Integer, Map<String, Symbol>> rootNode = null;

    public SymbolTable(int contextID) {
        rootNode = new Node<>(contextID, new HashMap<>());
    }

    public Node<Integer, Map<String, Symbol>> root() {
        return rootNode;
    }

    public boolean addChild(Integer currentContextID, Integer newContextID) {
         Node<Integer, Map<String, Symbol>> currentNode = getContext(currentContextID);
         if (currentNode == null)
             return false;
         currentNode.addChild(newContextID, new HashMap<String, Symbol>());
         return true;
    }

    public Node<Integer, Map<String, Symbol>> getContext(Integer contextID) {
        return getContext(contextID, rootNode);
    }

    public Node<Integer, Map<String, Symbol>> getContext(Integer contextID, Node<Integer, Map<String, Symbol>> root) {
        //System.out.println(root.getID()+" == "+contextID+" => "+root.getID().equals(contextID));
        if (root.getID().equals(contextID)) return root;
        Node<Integer, Map<String, Symbol>> res = null;
        for (Node<Integer, Map<String, Symbol>> child : root.getChildren()) {
            res = getContext(contextID, child);
            if (res != null) return res;
        }
        return null;
    }
}

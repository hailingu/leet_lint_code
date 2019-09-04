import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UnionFind {

    HashMap<String, String> parent = new HashMap<>();
    HashMap<String, Integer> size = new HashMap<>();

    public HashMap<String, List<String>> forest = new HashMap<>();

    public void union(String node1, String node2) {
        update(node1);
        update(node2);

        String parent1 = find(node1);
        String parent2 = find(node2);

        if (parent1.equals(parent2)) {
            return ;
        } else {
            int parent1Size = size.get(parent1);
            int parent2Size = size.get(parent2);

            if (parent1Size > parent2Size) {
                parent.put(parent2, parent1);
                size.put(parent1, size.get(parent2) + size.get(parent1));
                forest.get(parent1).addAll(forest.get(parent2));
                forest.remove(parent2);
                size.remove(parent2);
            } else {
                parent.put(parent1, parent2);
                size.put(parent2, size.get(parent1) + size.get(parent2));
                forest.get(parent2).addAll(forest.get(parent1));
                forest.remove(parent1);
                size.remove(parent1);
            }
        }
    }


    public String find(String node) {
        if (!parent.containsKey(node)) {
            parent.put(node, node);
            size.put(node, 1);
        }

        while (!node.equals(parent.get(node))) {
            node = parent.get(node);
        }

        return node;
    }

    void update(String node) {
        if (!parent.containsKey(node)) {
            parent.put(node, node);
            size.put(node, 1);
            List<String> list = new ArrayList<>();
            list.add(node);
            forest.put(node, list);
        }
    }

}

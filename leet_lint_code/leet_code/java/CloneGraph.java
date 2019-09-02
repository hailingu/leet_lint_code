// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: leetcode
// This is a answer of leet code problem 133.
// Date: 2019.9.2


import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    Node cloneGraph(Node node, Map<Integer, Node> map) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        List<Node> list = new ArrayList<>();
        Node n = new Node(node.val, list);
        map.put(n.val, n);
        for (Node neighbor : node.neighbors) {
            if (map.containsKey(neighbor.val)) {
                list.add(map.get(neighbor.val));
            } else {
                list.add(cloneGraph(neighbor, map));
            }
        }

        return n;
    }
}

// Copyright © 2018 Hailin Gu. All rights reserved.
// License
// Author: Hailin Gu
// This is a answer of leet code problem 207.
// Date: 2019.9.9

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, Node2> courses = new HashMap<>();
        for (int i = 0; i < numCourses; ++ i) {
            courses.put(i, new Node2(i));
        }

        for (int[] prerequisite : prerequisites) {
            Node2 course1 = courses.get(prerequisite[0]);
            Node2 course2 = courses.get(prerequisite[1]);
            course1.in.add(prerequisite[1]);
            course2.out.add(prerequisite[0]);
        }

        Node2 root = null;
        for (Map.Entry<Integer, Node2> entry : courses.entrySet()) {
            if (root == null && entry.getValue().in.size() == 0) {
                root = entry.getValue();
            }
        }

        List<Node2> sorted = new ArrayList<>();
        topologicalSort(root, sorted,courses);

        return sorted.size() == numCourses;
    }

    void topologicalSort(Node2 root, List<Node2> sorted, Map<Integer, Node2> courses) {
        if (root == null) {
            return ;
        }

        sorted.add(root);
        int val = root.val;
        Node2 nextRoot = null;
        for (int i : root.out) {
            Node2 n = courses.get(i);
            n.in.remove(val);
        }

        courses.remove(val);

        for (Map.Entry<Integer, Node2> entry : courses.entrySet()) {
            if (nextRoot == null && entry.getValue().in.size() == 0) {
                nextRoot = entry.getValue();
            }
        }

        if (nextRoot == null) {
            return;
        }

        topologicalSort(nextRoot, sorted, courses);
    }
}


class Node2 {
    int val;
    Set<Integer> in;
    Set<Integer> out;

    Node2(int val) {
        this.val = val;
        this.in = new HashSet<>();
        this.out = new HashSet<>();
    }
}
// Copyright © 2018 Hailin Gu. All rights reserved.
// License(GPL)
// Author: Hailin Gu
// This is a answer of leet code problem 116.
// Date: 2019.8.31

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        
        if (root.left != null) {
            root.left.next = root.right;
        }
        
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        
        Node leftNode = connect(root.left);
        Node rightNode = connect(root.right);
        
        return root;
        
    }
    

}
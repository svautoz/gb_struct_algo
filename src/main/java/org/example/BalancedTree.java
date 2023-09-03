package org.example;

/*Красно-черное дерево имеет следующие критерии:
        • Красные ноды могут быть только левым ребенком
*/

public class BalancedTree {
    Node head = null;

    public static class Node {
        private Node left;
        private Node right;
        private int value;
        private char color;
        public Node(int value) {
            this.value = value;
            color = 'r';
        }
    }

    public void add(int value){
        if(head == null){
            head = new Node(value);
            head.color = 'b';
            return;
        }
        add(value, head);
    }

    public void add(int value, Node node){
        if(node.value == value) return;
        if(value > node.value){
            if(node.right == null){
                node.right = new Node(value);
            }else{
                add(value, node.right);
            }
        }
        if(value < node.value){
            if(node.left == null){
                node.left = new Node(value);;
            }else{
                add(value, node.left);
            }
        }
        balanceTree(node);
    }

    public Integer find(int value){
        return find(value, head);
    }

    public Integer find(int value, Node node){
        Integer result = null;
        if(node == null) return null;
        if(node.value == value){
            return value;
        }
        if(value > node.value){
            return find(value, node.right);
        }else{
            return find(value, node.left);
        }
    }

    public void balanceTree(Node node){
        if(node == null) return;
        if(node.right != null && node.right.color == 'r' && (node.left == null || node.left.color == 'b')){
            leftTurn(node);
        }
        if(node.left != null && node.left.color == 'r' && node.left.left != null && node.left.left.color == 'r' ){
            rightTurn(node);
        }
        if(node.color == 'b' && node.left != null && node.right != null && node.left.color == 'r' && node.right.color == 'r'){
            swapColor(node);
        }
    }

    private void leftTurn(Node node) {
        Node tempNode = new Node(node.value);
        tempNode.left = node.left;
        tempNode.right = node.right.left;
        node.value = node.right.value;
        node.left = tempNode;
        node.right = node.right.right;
    }

    private void rightTurn(Node node) {
        Node tempNode = new Node(node.value);
        tempNode.left = node.left.right;
        tempNode.right = node.right;
        node.value = node.left.value;
        node.left = node.left.left;
        node.right = tempNode;
        swapColor(node);
    }

    private void swapColor(Node node) {
        node.color = 'r';
        node.left.color = 'b';
        node.right.color = 'b';
        head.color = 'b';
    }



}



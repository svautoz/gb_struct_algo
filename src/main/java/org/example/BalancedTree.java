package org.example;

/*Красно-черное дерево имеет следующие критерии:
        • Красные ноды могут быть только левым ребенком
*/

public class BalancedTree {
    Node head = null;

    private static class Node {
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
        Node newNode = new Node(value);
        if(value > node.value){
            if(node.right == null){
                node.right = newNode;
            }else{
                add(value, node.right);
            }
        }
        if(value < node.value){
            if(node.left == null){
                node.left = newNode;
            }else{
                add(value, node.left);
            }
        }
        balanceTree(node);
    }

    public Integer find(int value){
        find(value, head);
    }

    public Integer find(int value, Node node){
        Integer result = null;
        if(node == null) return null;
        if(node.value == value){
            return value;
        }
        result = find(value, node.left);
        if(result != null) return result;
        result = find(value, node.right);
        return result;
    }

    public void balanceTree(Node node){
        if(node == null) return;
        if(node.color == 'b' && node.left != null && node.right != null && node.left.color == 'r' && node.right.color == 'r'){
            swapColor(node);
        }
        if(node.left != null && node.left.color == 'r' && node.left.left != null && node.left.left.color == 'r' ){
            rightTurn(node);
        }
    }

    private void rightTurn(Node node) {
        Node tempNode = node;
        node = node.left;

    }

    private void swapColor(Node node) {
        node.color = 'r';
        node.left.color = 'b';
        node.right.color = 'b';
        head.color = 'b';
    }



}



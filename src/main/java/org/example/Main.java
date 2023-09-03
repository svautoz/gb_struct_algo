package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        BalancedTree balancedTree = new BalancedTree();
        balancedTree.add(24);
        System.out.println(balancedTree.find(24));
        balancedTree.add(5);
        System.out.println(balancedTree.find(5));
        balancedTree.add(1);
        System.out.println(balancedTree.find(1));
        balancedTree.add(15);
        System.out.println(balancedTree.find(15));
        balancedTree.add(3);
        System.out.println(balancedTree.find(3));
        balancedTree.add(3);
        balancedTree.add(8);
        System.out.println(balancedTree.find(8));
        System.out.println(balancedTree.find(1));
        balancedTree.add(14);
        System.out.println(balancedTree.find(14));
        balancedTree.add(10);
        System.out.println(balancedTree.find(55));

    }
}
package SkillTask6;

import java.util.ArrayList;

public class MyBinaryTreeTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree = myBinaryTree.fromArray(arrayList);
        System.out.println(myBinaryTree);
        System.out.println("\n\n\n");
        System.out.println(myBinaryTree.next(9).getValue());
    }
}

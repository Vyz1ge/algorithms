package SkillTask7;

import java.util.ArrayList;

public class MyDaveTree {

    public static void main(String[] args) {
        ArrayList<Edge> e = new ArrayList<>();
        ArrayList<ArrayList<Node>> v = new ArrayList<>();
        ArrayList<Integer> d = new ArrayList<>();
        for (int i = 0; i < v.size(); i++) {
            v.add(new ArrayList<Node>());
        }

        e.add(new Edge(0,1));
        e.add(new Edge(0,2));
        e.add(new Edge(1,3));
        e.add(new Edge(1,4));
        e.add(new Edge(2,5));
        e.add(new Edge(2,6));

        for (int i = 0; i < e.size(); i++) {
            int a = e.get(i).getA();
            int b = e.get(i).getB();
//            v.get(a).add(b);

        }



//        printTree(ar,0,0);



    }

    static void printTree(ArrayList<Node> ar, int nodeId, int level) {
        Node node = ar.get(nodeId);
        // Выводим отступы в зависимости от уровня
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        // Печатаем текущий узел
        System.out.println(node.getId());

        // Рекурсивно выводим детей узла
        for (Node child : node.getV()) {
            // Чтобы не идти по обратному пути (к родителю), пропускаем его
            if (child.getId() > nodeId) {
                printTree(ar, child.getId(), level + 1);
            }
        }
    }

}

class Node {
    private int id;
    private ArrayList<Node> v;

    public Node(int id){
        this.id = id;
        this.v = new ArrayList<Node>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Node> getV() {
        return v;
    }

    public void setV(ArrayList<Node> v) {
        this.v = v;
    }
}

class Edge {
    private int a;
    private int b;

    public Edge(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}

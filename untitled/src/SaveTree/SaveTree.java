package SaveTree;

import java.util.ArrayList;

public class SaveTree {
    public static void main(String[] args) {
        int n = 7; // НУ 5 ВЕРШИН
        ArrayList<Edge> e = new ArrayList<>(); // СОЗДАЮ СПИСОК, КОТОРЫЙ ХРАНИТ ПУТИ А ДО Б

        ArrayList<Node> ar = new ArrayList<>(); // СОЗДАЮ СПИСОК КОТОРЫЙ ХРАНИТ УЗЛЫ

        ar.add(new Node(0));
        ar.add(new Node(1));
        ar.add(new Node(2));
        ar.add(new Node(3));
        ar.add(new Node(4));
        ar.add(new Node(5));
        ar.add(new Node(6));


        // Добавляем ребра для трехуровневого дерева
        e.add(new Edge(0, 1)); // Корень -> Левый узел первого уровня
        e.add(new Edge(0, 2)); // Корень -> Правый узел первого уровня
        e.add(new Edge(1, 3)); // Левый узел первого уровня -> Левый узел второго уровня
        e.add(new Edge(1, 4)); // Левый узел первого уровня -> Правый узел второго уровня
        e.add(new Edge(2, 5)); // Правый узел первого уровня -> Левый узел второго уровня
        e.add(new Edge(2, 6)); // Правый узел первого уровня -> Правый узел второго уровня


        for (int i = 0; i < e.size(); i++) { // ЦИКЛ С ОБХОДОМ ПУТЕЙ ОТ А ДО Б
            int a = e.get(i).a; // ПРИСВАИВАЮ ПАРАМЕТРУ А ПОЛУЧЕНИЕ ИЗ СПИСКА Е ЭЛЕМЕНТА i
            int b = e.get(i).b; // ПРИСВАИВАЮ ПАРАМЕТРУ B ПОЛУЧЕНИЕ ИЗ СПИСКА Е ЭЛЕМЕНТА i
            ar.get(a).v.add(ar.get(b)); //
            ar.get(b).v.add(ar.get(a)); //
        }
        printTree(ar, 0, 0);
    }
    static void printTree(ArrayList<Node> ar, int nodeId, int level) {
        Node node = ar.get(nodeId);
        // Выводим отступы в зависимости от уровня
        for (int i = 0; i < level; i++) {
            System.out.print("   ");
        }
        // Печатаем текущий узел
        System.out.println(node.id);

        // Рекурсивно выводим детей узла
        for (Node child : node.v) {
            // Чтобы не идти по обратному пути (к родителю), пропускаем его
            if (child.id > nodeId) {
                printTree(ar, child.id, level + 1);
            }
        }
    }
}
class Node{ // УЗЕЛ
    int id; // КОТОРЫЙ ХРАНИТЬ АЙДИ УЗЛА
    ArrayList<Node> v; // СПИСОК ССЫЛОК НА СОСЕДНИЕ УЗЛЫ
    Node(int id){ // КОНСТРУКТОР
        this.id = id; // ПРИСВАЕВАЕМ
        this.v = new ArrayList<>(); // ПРИСВАЕВАЕМ НОВЫЙ СПИСОК
    }
}

class Edge{ // ПУТЬ ОТ А К Б, ТО ЕСТЬ РЕБРО
    int a,b; // ИНИЦИАЛИЗАЦИЯ
    Edge(int a, int b) {
        this.a = a;
        this.b = b;
    }
}


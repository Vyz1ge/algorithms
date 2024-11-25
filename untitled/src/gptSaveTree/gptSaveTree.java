package gptSaveTree;

import java.util.ArrayList;

public class gptSaveTree {
    public static ArrayList<ArrayList<Integer>> v = new ArrayList<>();
    public static ArrayList<Integer> d = new ArrayList<>();

    // Метод DFS для вычисления глубины каждого узла
    public static int dfs(int x) {
        return dfs(x, 0, -1);
    }

    public static int dfs(int x, int depth, int p) {
        d.set(x, depth); // Устанавливаем глубину текущего узла
        int weight = 1;
        for (int i = 0; i < v.get(x).size(); i++) {
            int a = v.get(x).get(i);
            if (a == p) {
                continue; // избегаем обратного пути к родителю
            }
            weight += dfs(a, depth + 1, x); // Рекурсивный вызов для детей узла
        }
        return weight;
    }

    // Метод для печати дерева на основе глубины узлов
    public static void printTree(int x, int p) {
        // Печать текущего узла с отступом, соответствующим его глубине
        for (int i = 0; i < d.get(x); i++) {
            System.out.print("   "); // добавляем отступ для визуализации уровня
        }
        System.out.println(x);

        // Рекурсивно печатаем детей узла
        for (int i = 0; i < v.get(x).size(); i++) {
            int a = v.get(x).get(i);
            if (a != p) {
                printTree(a, x);
            }
        }
    }

    public static void main(String[] args) {
        int n = 7;

        // Инициализация структуры
        for (int i = 0; i < n; i++) {
            v.add(new ArrayList<>());
            d.add(0); // Инициализируем глубину нулем для всех узлов
        }

        // Добавление связей (ребер) между узлами
        addV(v, 0, 1);
        addV(v, 0, 2);
        addV(v, 1, 3);
        addV(v, 1, 4);
        addV(v, 2, 5);
        addV(v, 2, 6);

        System.out.println(dfs(0)); // Вычисление глубины для каждого узла, начиная с корня (узел 0)

        System.out.println("Дерево:");
        printTree(0, -1); // Печать дерева, начиная с корня (узел 0)
    }

    // Метод для добавления связи между узлами
    static void addV(ArrayList<ArrayList<Integer>> v, int a, int b) {
        v.get(a).add(b);
        v.get(b).add(a);
    }
}

















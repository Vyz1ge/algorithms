package BFS;

import java.util.ArrayList;

public class bfs {

    public static void add(ArrayList<ArrayList<Integer>> v, int a, int b) {
        v.get(a).add(b);
        v.get(b).add(a);
    }

    public static void dfs(int x){
        dfs(x,0,-1);
    }

    public static void dfs(int x, int depth, int p){
        for (int i = 0; i < depth; i++) {
            System.out.print("   ");
        }
        System.out.println(x);
        d.set(x,depth);
        for (int i = 0; i < v.get(x).size(); i++) {
            int a = v.get(x).get(i);
            if (a == p){
                continue;
            }
            dfs(a,depth + 1,x);
        }
    }

    public static void main(String[] args) {
        int n = 7;

        for (int i = 0; i < n; i++) {
            v.add(new ArrayList<>());
            d.add(0);
        }
        add(v,0,1);
        add(v,1,4);
        add(v,0,2);
        add(v,1,3);
        add(v,2,6);
        add(v,2,5);
        bfc(0);

    }
    private static ArrayList<ArrayList<Integer>> v = new ArrayList<>();
    private static ArrayList<Integer> d = new ArrayList<>();
    private static int N = 7;
    public static void bfc(int x){
        int D = 0;
        ArrayList<Integer> next = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        boolean[] isv = new boolean[N];
        for (int i = 0; i < N; i++) {
            isv[i] = false;
        }
        next.add(x);

        while(next.size() > 0){
            cur = next;
            next = new ArrayList<>();
            for (int i = 0; i < cur.size(); i++) {
                int a = cur.get(i);
                isv[a] = true;
                d.set(a,D);
                System.out.print(a+" ");
                for (int j = 0; j < v.get(a).size(); j++) {
                    int b = v.get(a).get(j);
                    if (isv[b]){
                        continue;
                    }
                    next.add(b);

                }
            }
            System.out.println();
            D++;
        }

    }


}
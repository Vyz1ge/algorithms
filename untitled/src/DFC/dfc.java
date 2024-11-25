package DFC;

import java.util.ArrayList;

public class dfc {
    private static ArrayList<ArrayList<Integer>> v = new ArrayList<>();
    private static ArrayList<Integer> d = new ArrayList<>();
    private static ArrayList<Integer> w = new ArrayList<>();
    private static ArrayList<Integer> t_in = new ArrayList<>();
    private static ArrayList<Integer> t_out = new ArrayList<>();
    private static int T;

    public static int dfs(int x){
        return dfs(x, 0, -1);
    }

    public static int dfs(int x, int depth,int p){
        t_in.set(x,T++);
        int weight = 1;
        for (int i = 0; i < depth; i++) {
            System.out.print("   ");
        }
        d.set(x,depth);
        System.out.println(x);
        for (int i = 0; i < v.get(x).size(); i++) {
            int a = v.get(x).get(i);
            if (p == a){
                continue;
            }
            weight += dfs(a,depth+1,x);
        }
        w.set(x,weight);
        t_out.set(x,T++);
        return weight;
    }

    public static boolean istreesup(int a,int b){
        if(t_in.get(b) < t_in.get(a)){
            return false;
        }
        if (t_out.get(b) > t_out.get(a)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 100;
        for (int i = 0; i < n; i++) {
            v.add(new ArrayList<>());
            d.add(0);
            w.add(0);
            t_in.add(0);
            t_out.add(0);
        }

        add(v,0, 1);
        add(v,0, 2);
        add(v,1, 3);
        add(v,1, 4);
        add(v,2, 5);
        add(v,2, 9);


//        dfs(0);
        System.out.println();
        System.out.println();
        System.out.println(dfs(0));
//        System.out.println(w);
        System.out.println(t_in);
        System.out.println(t_out);
        System.out.println("\n\n\n");
        System.out.println(istreesup(2,9));

        System.out.println(w.get(9));
    }



    public static void add(ArrayList<ArrayList<Integer>> v, int a,int b){
        v.get(a).add(b);
        v.get(b).add(a);
    }
}

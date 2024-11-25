package DFS;

import java.util.ArrayList;

public class DSC {
    private static ArrayList<ArrayList<Integer>> v = new ArrayList<>();
    private static ArrayList<Integer> d = new ArrayList<>();
    private static ArrayList<Integer> w = new ArrayList<>();
    private static ArrayList<Integer> t_in = new ArrayList<>();
    private static ArrayList<Integer> t_out = new ArrayList<>();
    private static int T = 0;
    public static int dfs(int x){
        return dfs(x,0,-1);
    }

    public static int dfs(int x,int depth,int p){
        t_in.set(x,T++);
        for (int i = 0; i < depth; i++) {
            System.out.print("   ");
        }
        System.out.println(x);
        int weight = 1;
        d.set(x,depth);
        for (int i = 0; i < v.get(x).size(); i++) {
            int a = v.get(x).get(i);
            if (p == a){
                continue;
            }
            weight += dfs(a,depth+1,x);
        }
        t_out.set(x,T++);
        w.set(x,weight);
        return weight;
    }
    public static boolean issubtree(int a,int b){
        if (t_in.get(b) < t_in.get(a)){
            return false;
        }
        if (t_out.get(b) > t_out.get(a)){
            return false;
        }
        return true;
    }

    private static ArrayList<Integer> order = new ArrayList<>();
    private static ArrayList<Integer> first = new ArrayList<>();
    private static ArrayList<Integer> last = new ArrayList<>();
    public static void dfs2(int x, int depth, int p) {
        d.set(x, depth);
        first.set(x, order.size());
        order.add(x);
        for (int i = 0; i < v.get(x).size(); ++i) {
            int a = v.get(x).get(i);
            if (a == p) continue;
            dfs2(a, depth + 1, x);
            order.add(x);
        }
        last.set(x, order.size());
        order.add(x);
    }


    public static int get_lca(int a, int b) {
        int l = first.get(a);
        if (first.get(b) < l) {
            l = first.get(b);
        }

        int r = last.get(a);
        if (last.get(b) > r) {
            r = last.get(b);
        }

        int ans = a;
        int D = d.get(a);
        for (int i = l; i <= r; ++i) {
            if (d.get(order.get(i)) < D) {
                ans = order.get(i);
                D = d.get(ans);
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        int n = 100;
        for (int i = 0; i < n; i++) {
            v.add(new ArrayList<>());
            d.add(0);
            w.add(0);
            t_in.add(0);
            t_out.add(0);
            last.add(0);
            first.add(0);
        }
        add(v,99,1);
        add(v,99,2);
        add(v,99,3);
        add(v,3,4);
        add(v,3,5);
        add(v,3,6);
//        dfs2(0,0,-1);
//        System.out.println(get_lca(5,6));
//        System.out.println();
//        System.out.println(dfs(99));
            dfs(99);

    }


    public static void add(ArrayList<ArrayList<Integer>> v, int a,int b){
        v.get(a).add(b);
        v.get(b).add(a);
    }

}

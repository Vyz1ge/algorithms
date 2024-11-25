package bbfc;

import java.util.ArrayList;

public class bfc {
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
                System.out.print(" "+a+" ");
                for (int j = 0; j < v.get(a).size(); j++) {
                    int b = v.get(a).get(a);
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


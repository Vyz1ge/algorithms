import java.util.Arrays;

public class Fibtwo {
    //3639
    //0
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        int n = 45;
        long[] mem = new long[n+1];
        Arrays.fill(mem,-1);
        System.out.println(fibN(n,mem));
        long after = System.currentTimeMillis();
        System.out.println(after-before);
    }

    public static long fibN(int n,long[] mem) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (mem[n] != -1){
            return mem[n];
        }
        mem[n] = fibN(n - 1,mem) + fibN(n - 2,mem);
        return mem[n];
    }

}

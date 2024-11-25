public class Fib {
    public static void main(String[] args) {
        System.out.println(fibN(10));
        System.out.println(fibE(10));
    }

    public static int fibN(int n){
        if (n==0){
            return 0;
        }
        if (n==1){
            return 1;
        }
        return fibN(n-1)+fibN(n-2);
    }

    public static int fibE(int n){
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n+1; i++) {
            arr[i] = arr[i-2]+arr[i-1];
        }
        return arr[n];
    }
}

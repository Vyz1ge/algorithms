import java.util.Arrays;

public class Teest {
    public static void main(String[] args) {
        byte[] arr = {1,2,3,4,5};
        byte[] arrtwo = arr;
        arrtwo[0] = 9;
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arrtwo));
    }
}

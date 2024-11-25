import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1,2,2,3,4,2,5};
        System.out.println(Arrays.toString(numbers));
        System.out.println(Arrays.toString(removeEl(numbers,2)));
    }
    public static int[] removeEl(int[] numbers, int value){
        int offset = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == value){
                offset++;
            }else {
                numbers[i - offset] = numbers[i];
            }
        }
        int[] numbern = Arrays.copyOf(numbers,numbers.length - offset);
        int[] numberk = new int[numbers.length-offset];
        for (int i = 0; i < numberk.length; i++) {
            numberk[i] = numbers[i];
        }
        return numberk;
    }
}

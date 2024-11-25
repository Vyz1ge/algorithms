import java.util.Arrays;

public class SkillTask5 {
    public static void main(String[] args) {
        int[] arr = {23,7,6,1,5,7,1};
        //           23 6 5 7 1 / /
        System.out.println(Arrays.toString(arr));
        int l = arr.length;
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = i; j < l-1; j++) {
                if(arr[i] == arr[j+1]){
                    flag = true;
                    l--;
                }
            }
            if(flag) {
                for (int j = i; j < l; j++) {
                    arr[j] = arr[j+1];
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
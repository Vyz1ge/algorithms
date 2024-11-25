import java.util.Arrays;

public class SkillTask4 {
    public static void main(String[] args) {
        int[] arr = {2, 2543, 3254, 23, 43, 32, 1, 2432, 32, 42, 535, 6, 7, 8, 43, 64, 3, 2, 432, 32, 123, 5253};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarysearch(arr, 42));
    }
// 0 1 2 3 4   mid = 0 + (4-0)/2 = 2 | el >
    public static int binarysearch(int[] arr, int el) {
        int low = 0;
        int high = arr.length-1;
        while(low<=high){
            int middle = low + (high-low)/2;
            if (el < arr[middle]){
                high = middle-1;
            }
            else if (el > arr[middle]){
                low = middle+1;
            }
            else{
                return middle;
            }
        }
        return -1;
    }
}

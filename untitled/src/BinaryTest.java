import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        BinaryThree binaryThree = new BinaryThree();
        binaryThree = binaryThree.fromArray(arrayList);
        System.out.println(binaryThree.next(2).value);

        System.out.println(binaryThree);
    }


}

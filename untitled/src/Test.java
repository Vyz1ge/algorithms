import java.lang.reflect.Method;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String string1 = scanner.nextLine();
        String string2 = scanner.nextLine();
        String stringmethod = scanner.nextLine();
        Class class1 = Class.forName(string1);
        Class class2 = Class.forName(string2);
        Method method = class1.getMethod(stringmethod,class2);
        Object object1 = class1.newInstance();
        Object object2 = class2.getConstructor(class2).newInstance("Hi");
        method.invoke(object1,object2);
        System.out.println(object1);
    }
}

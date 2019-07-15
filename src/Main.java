import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    }

    public boolean porownajSlowa(String str1, String str2){

        String pStr1= str1.toLowerCase();
        String pStr2= str2.toLowerCase();

        char[] c1 = pStr1.toCharArray();
        char[] c2 = pStr2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        String sorted1= new String(c1);
        String sorted2= new String(c2);

        return sorted1.equals(sorted2);
    }
}

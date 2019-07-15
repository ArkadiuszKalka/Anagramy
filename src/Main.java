import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }

    public List<String> znajdzAnagram(List<String> listaSlow) {
        Date dStart = new Date();
        String s = "Rozpoczęto wyszukiwanie: ";
        long totalComp = 0;
        List<String> list = new ArrayList<>();
        System.out.println(s);

        for (int x = 0; x < listaSlow.size(); x++) {
            for (int y = x + 1; y < listaSlow.size(); y++) {
                String str1 = listaSlow.get(x).toString();
                String str2 = listaSlow.get(y).toString();
                totalComp++;
                if (porownajSlowa(str1, str2)) {
                    if ((x % 20) == 0) {
                        System.out.println(".");
                    }
                list.add(str1+" - "+str2);
                }


            }

        }

    }


    public boolean porownajSlowa(String str1, String str2) {

        String pStr1 = str1.toLowerCase();
        String pStr2 = str2.toLowerCase();

        char[] c1 = pStr1.toCharArray();
        char[] c2 = pStr2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        String sorted1 = new String(c1);
        String sorted2 = new String(c2);

        return sorted1.equals(sorted2);
    }
}

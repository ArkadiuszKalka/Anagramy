import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterReader;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Anagram {

    public static void main(String[] args) throws Exception {

        Anagram a = new Anagram();
        List<String> lista = new ArrayList<>();
        List<String> listaAnagrwmow = new ArrayList<>();

        lista = a.wczytajPlik();
        if (lista.size() == 0) {
            System.out.println("Nie wczytano żadnych słów");
        } else {
            System.out.println(String.format("Wczytano %,d unikalnych słów", lista.size()));
            listaAnagrwmow = a.znajdzAnagram(lista);
            System.out.println(String.format("Znaleziono anagramów %,d", listaAnagrwmow.size()));

            for (String s : listaAnagrwmow) {
                System.out.println(s);
            }
        }

    }

    public List<String> wczytajPlik() throws Exception {
        List<String> listaSlow = new ArrayList<>();
        Set<String> slowaSet = new HashSet<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader("anagram.txt"));
        try {
            String linia;
            while ((linia = bufferedReader.readLine()) != null) {
                if (!linia.equals("")) {
                    slowaSet.add(linia);
                }
            }
            bufferedReader.close();
            listaSlow.addAll(slowaSet);
        } catch (Exception e) {
            System.out.printf("Bład odczytu pliku");
        }
        return listaSlow;
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
                    list.add(str1 + " - " + str2);
                }
            }
        }
        System.out.println(String.format("\n\nLiczba wykonanych porównań %,d", totalComp));
        Date dEnd = new Date();
        long czas = (dEnd.getTime() - dStart.getTime()) / 1000;
        System.out.println(String.format("Porównanie trwało %,d", czas));
        return list;
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

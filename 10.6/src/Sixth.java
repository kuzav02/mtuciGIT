import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.String;
import java.lang.Math;
import java.util.regex.Matcher;
import java.util.Arrays;
import java.util.*;
import java.util.regex.Pattern;

public class Sixth {
    public static void main(String[] args) {
        System.out.println("Номер 1");
        // собираем анаграмму 2-ой строки из 1
        System.out.println(hiddenAnagram("My world evolves in a beautiful space called Tesh.", "sworn love lived"));
        System.out.println(hiddenAnagram("An old west action hero actor", "Clint Eastwood"));
        System.out.println(hiddenAnagram("Mr. Mojo Rising could be a song title", "Jim Morrison"));
        System.out.println(hiddenAnagram("Banana? margaritas", "ANAGRAM"));
        System.out.println(hiddenAnagram("D e b90it->?$ (c)a r...d,,#~", "bad credit"));
        System.out.println(hiddenAnagram("Bright is the moon", "Bongo mirth"));
        System.out.println();

        System.out.println("Номер 2");
        // разбиваем слова по n букв рекурсивным подходом
        System.out.println(Arrays.toString(collect("intercontinentalisationalism", 6)));
        System.out.println(Arrays.toString(collect("strengths", 3)));
        System.out.println(Arrays.toString(collect("pneumonoultramicroscopicsilicovolcanoconiosis", 15)));
        System.out.println();

        System.out.println("Номер 3");
        // шифр Nico
        System.out.println(nicoCipher("myworldevolvesinhers", "tesh"));
        System.out.println(nicoCipher("andiloveherso", "tesha"));
        System.out.println(nicoCipher("mubashirhassan", "crazy"));
        System.out.println(nicoCipher("edabitisamazing", "matt"));
        System.out.println(nicoCipher("iloveher", "612345"));
        System.out.println();

        System.out.println("Номер 4");
        // поиск двух множителей числа n
        int[] a1 = {1, 2, 3, 9, 4, 5, 15, 3};
        int[] a2 = {1, 2, 3, 9, 4, 15, 3, 5};
        int[] a3 = {1, 2, -1, 4, 5, 6, 10, 7};
        int[] a4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(Arrays.toString(twoProduct(a1, 45)));
        System.out.println(Arrays.toString(twoProduct(a2, 45)));
        System.out.println(Arrays.toString(twoProduct(a3, 20)));
        System.out.println(Arrays.toString(twoProduct(a4, 10)));
        System.out.println();

        System.out.println("Номер 5");
        // проверка факториала
        System.out.println(Arrays.toString(isExact(6)));
        System.out.println(Arrays.toString(isExact(24)));
        System.out.println(Arrays.toString(isExact(125)));
        System.out.println(Arrays.toString(isExact(720)));
        System.out.println(Arrays.toString(isExact(1024)));
        System.out.println(Arrays.toString(isExact(40320)));
        System.out.println();

        System.out.println("Номер 6");
        // перевод в обычную дробь
        System.out.println(fractions("0.(6)"));
        System.out.println(fractions("1.(1)"));
        System.out.println(fractions("3.(142857)"));
        System.out.println(fractions("0.19(2367)"));
        System.out.println(fractions("0.1097(3)"));
        System.out.println();

        System.out.println("Номер 7");
        // разбиение строки на слова, длина которых равна первым 15 цифрам числа пи
        System.out.println(pilish_string("33314444"));
        System.out.println(pilish_string("TOP"));
        System.out.println(pilish_string("X"));
        System.out.println(pilish_string(""));
        System.out.println();

        System.out.println("Номер 8");
        // генерация непоследовательных строк
        System.out.println(generateNonconsecutive(1));
        System.out.println(generateNonconsecutive(2));
        System.out.println(generateNonconsecutive(3));
        System.out.println(generateNonconsecutive(4));
        System.out.println();

        System.out.println("Номер 9");
        // проверка строк на действительность (количество символов одинаково)
        System.out.println(isValid("aabbcd"));
        System.out.println(isValid("aabbccddeefghi"));
        System.out.println(isValid("abcdefghhgfedecba"));
        System.out.println();

        // поиск массива пар[a, b], где a + b = 8, в массиве чисел
        System.out.println("Номер 10");
        System.out.println(sumsUp(new int[] { 1, 2, 3, 4, 5 }));
        System.out.println(sumsUp(new int[] { 1, 2, 3, 7, 9 }));
        System.out.println(sumsUp(new int[] { 10, 9, 7, 2, 8 }));
        System.out.println(sumsUp(new int[] { 1, 6, 5, 4, 8, 2, 3, 7 }));
    }

    // собираем анаграмму 2-ой строки из 1
    public static String hiddenAnagram(String str, String strValue) {
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        strValue = strValue.toLowerCase().replaceAll("[^a-z]", "");
        String strKey = "";
        String strCopyValue = strValue;
        for (int i = 0; i < str.length() - 1; i++) {
            strCopyValue = strValue;
            strKey = "";
            for (int j = i; j < str.length(); j++) {
                if (!strCopyValue.contains(str.substring(j, j + 1)) && strCopyValue != "") {
                    strCopyValue = strValue;
                    strKey = "";
                    break;
                }
                if (strCopyValue.contains(str.substring(j, j + 1))) {
                    strCopyValue = strCopyValue.replaceFirst(str.substring(j, j + 1), "");
                    strKey += str.substring(j, j + 1);
                }
            }
            if (strCopyValue == "" && strKey != "") {
                break;
            }
        }
        if (strCopyValue != "") strKey = "noutfond";
        return strKey;
    }
    // разбиваем слова по n букв рекурсивным подходом
    public static String[] collect(String str, int n) {
        String[] arr;
        if (str.length() < n) {
            arr = new String[0];
        } else {
            arr = new String[str.length() / n];
            arr[0] = str.substring(0, n);
            String[] arr1 = collect(str.substring(n), n);
            for (int i = 1; i < arr.length; i++) {
                if (arr1.length > i - 1)
                    arr[i] = arr1[i - 1];
            }
        }
        Arrays.sort(arr);
        return arr;
    }
    // шифр Nico
    public static String nicoCipher(String messege, String key) {
        double intermed = Math.ceil(messege.length() / key.length()) + Math.ceil(Math.ceil(messege.length() % key.length()) / 10);
        String[][] masValue = new String[(int) intermed][key.length()];
        String[][] masCopyValue = new String[(int) intermed][key.length()];
        ArrayList<String> keyValue = new ArrayList<String>();
        String code = "";

        int r = 0;
        //заполнение массива
        for (int i = 0; i < intermed; i++) {
            for (int j = 0; j < key.length(); j++) {
                if (r == messege.length()) break;
                masValue[i][j] = messege.substring(r, r + 1);
                r++;
            }
            if (r == messege.length()) break;
        }
        //сортировка ключа по алфовиту
        for (int i = 0; i < key.length(); i++) keyValue.add(key.substring(i, i + 1));
        Collections.sort(keyValue);
        //заполнения итогового массива по ключу
        String keyCopy = key;
        for (int i = 0; i < intermed; i++) {
            for (int j = 0; j < key.length(); j++) {
                masCopyValue[i][j] = masValue[i][keyCopy.indexOf(keyValue.get(j))];
                keyCopy = keyCopy.replaceFirst(keyValue.get(j), " ");
            }
            keyCopy = key;
        }
        //заполнение итоговой строки и ее вывод
        for (int i = 0; i < intermed; i++) {
            for (int j = 0; j < key.length(); j++) {
                if (masCopyValue[i][j] != null) {
                    code += masCopyValue[i][j];
                } else code += " ";
            }
        }
        return code;
    }
    // поиск двух множителей числа n
    public static int[] twoProduct(int[] arr, int n) {
        int first = 0, second = 0;
        int[] arr1 = new int[2];
        for (int i = arr.length - 1; i > 0; --i) {
            second = arr[i];
            for (int j = i - 1; j >= 0; --j) {
                first = arr[j];
                if (first * second == n) {
                    arr1[0] = first;
                    arr1[1] = second;
                }
            }
        }
        return arr1;
    }
    // проверка факториала
    public static int[] isExact(int val) {
        int[] arr = new int[0];
        int n = 2;
        int otvet = Fact(val, n);
        if (otvet != -1) arr = new int[]{val, otvet};
        return arr;
    }
    public static int Fact(int number, int k) {
        if (number == 1) return k - 1;
        if (number % k != 0) return -1;
        return Fact(number / k, k + 1);
    }
    // перевод в обычную дробь
    public static String fractions(String number) {
        // получение целой, непериодической и периодической частей
        int dotIndex = number.indexOf(".");
        int bracketIndex = number.indexOf("(");
        int leftPart = Integer.parseInt(number.substring(0, dotIndex));
        String unrepeatPart = number.substring(dotIndex + 1, bracketIndex);
        String repeatPart = number.substring(bracketIndex + 1, number.length() - 1);
        int b = 0;
        if (unrepeatPart.length() > 0) {
            b = Integer.parseInt(unrepeatPart);
        }
        // числитель дроби
        int chisl = Integer.parseInt(unrepeatPart + repeatPart) - b;
        // знаменатель дроби
        String znam_str = "";
        for (int i = 0; i < repeatPart.length(); i++) {
            znam_str += "9";
        }
        for (int i = 0; i < unrepeatPart.length(); i++) {
            znam_str += "0";
        }
        int znam = Integer.parseInt(znam_str);
        // сокращение дроби, если требуется
        int k = 2;
        int t = Math.max(chisl, znam);
        while (k < t) {
            if (chisl % k == 0 && znam % k == 0) {
                chisl /= k;
                znam /= k;
                t = Math.max(chisl, znam);
            } else {
                k++;
            }
        }
        return (leftPart * znam + chisl) + "/" + (znam);
    }
    // разбиение строки на слова, длина которых равна первым 15 цифрам числа пи
    private static String pilish_string(String str){
        int count = 0; String result = ""; int c = 0; String result1; int i = 0;
        String pi = "314159265358979";
        if (str == "") return str;
        while (i < 15){
            c = Character.digit(pi.charAt(i), 10);
            if(str.length() >= count + c) {
                result += str.substring(count, count + c);
                result += " ";
                if(str.length() == count + c)
                    return result;
                count += c;
            }
            else{
                result1 = str.substring(count, str.length());
                char b = result1.charAt(result1.length() - 1);
                int len = c - result1.length();
                for (int j = 0; j < len; j++) {
                    result1 += b;
                }
                result += result1;
                return result;
            }
            i++;
        }
        return result;
    }
    // генерация непоследовательных строк
    public static String generateNonconsecutive(int n) {
        if (n < 0) return "";
        if (n == 0) return "0";
        String s = "";
        int flag = 0;
        String otv = "";
        //пробег по всем числам в двоичной с\с с n кол-вом цифр
        for (int i = 0; i < Math.pow(2, n); i++){
            //перевод в двоисную с\с
            s = Integer.toBinaryString(i);
            //проверка, чтобы 11 не были вместе
            for (int j = 0; j<s.length() - 1; j++){
                if (s.charAt(j) == '1' && s.charAt(j + 1) == '1'){
                    flag = 1;
                    break;
                }
            }
            //дополнение 0 в начало, для правильного вывода
            if (s.length() != n){
                while (s.length() != n){
                    s = '0' + s;
                }
            }
            if (flag == 0) otv += s + ' ';
            flag = 0;
        }
        return otv.substring(0, otv.length()-1);
    }
    // проверка строк на действительность (количество символов одинаково)
    public static String isValid(String s) {
        String otv = "YES";
        // запись количества повторений символов в строке
        HashMap<String, Integer> ABC = new HashMap<String, Integer>();
        for (int i=0; i< s.length(); i++){
            String sym = s.substring(i, i+1);
            if (ABC.keySet().contains(sym)){
                int old = ABC.get(sym);
                ABC.replace(sym, old, old+1);
            }
            else{
                ABC.put(sym, 1);
            }
        }
        //проверка, что кол-во букв везде норм или отличается на 1
        int flag = 0;
        int flag1 = 0;
        ArrayList<String> key = new ArrayList<>(ABC.keySet());
        ArrayList<Integer> values = new ArrayList<>(ABC.values());
        int factValue = values.get(0);
        for (int i = 1; i < values.size() ; i++){
            if (Math.abs(values.get(i) - factValue) == 1) {
                if (flag1 == 0) flag1 = 1;
                else flag = 1;
            }
        }
        if (flag == 1) otv = "NO";
        return otv;
    }
    // поиск массива пар[a, b], где a + b = 8, в массиве чисел
    public static List<List<Integer>> sumsUp(int[] input) {
        List<List<Integer>> pair2 = new ArrayList<>();
        for (int i = 1; i < input.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (j != i && (input[i] + input[j]) == 8) {
                    List<Integer> pair = new ArrayList<>(List.of(input[i], 8 - input[i]));
                    pair.sort(Integer::compare);
                    pair2.add(pair);
                }
            }
        }
        return pair2;
    }
}

import java.util.*;
import java.lang.String;
import java.lang.Math;
import org.apache.commons.lang3.StringUtils;

public class Fourth10 {
    public static void main(String[] args){
        System.out.println();
        //номер 1
        String[] x = {"2", "4", "5", "2", "4845", "8", "9"};
        sevenBoom(x);
        System.out.println();
        //номер 2
        int[] y = {1, 2, 4, 5, 8, 9, 3, 6, 7};
        cons(y);
        System.out.println();
        //номер 3
        String s = "hTsii  s aimex dpus rtni.g";
        unmix(s);
        System.out.println();
        //номер 4
        s = "What went wrong!!!!!!!";
        noYelling(s);
        System.out.println();
        //номер 5
        s = "Inside xxxxxx the  x box was a xylophonx";
        xPronounce(s);
        System.out.println();
        //номер 6
        int[] y1 = {13, 3, 8, 5, 5, 2, 13, 6, 14, 2, 11, 4, 10, 8, 1, 9};
        largestGap(y1);
        System.out.println();
        //номер 7
        int z = 512;
        InhaleExhale(z);
        System.out.println();
        // номер 8
        s = "I I A A A I I!";
        if (s.charAt(s.length()-1) == '!' || s.charAt(s.length()-1) == '?' || s.charAt(s.length()-1) == '.' || s.charAt(s.length()-1) == ';'){
            char p = s.charAt(s.length()-1);
            s = s.replace(p,' ');
        }
        String[] s1 = s.split(" ");
        commonLastVowel(s1);
        System.out.println();
        //номер 9
        z = 24923;
        int z1 = 911;
        memeSum(z,z1);
        System.out.println();
        //номер 10
        s = "call 911";
        unrepeated(s);
    }

    public static void sevenBoom(String[] x){
        int k = 0;
        // если есть 7 -> Boom
        for (int i = 0; i < x.length; i++){
            if (x[i].indexOf('7') != -1) {
                System.out.println("Boom!");
                k = 1;
                break;
            }
        }
        if (k == 0){
            System.out.println("there is no 7 in the array");
        }
    }
    public static void cons(int[] x){
        boolean k = true;
        //true, если в массиве можно сделать элементы поподядку
        Arrays.sort(x);
        for (int i = 0; i < x.length - 1; i++){
            if (x[i+1] - x[i] != 1){
                k = false;
                break;
            }
        }
        System.out.println(k);
    }
    public static void unmix(String s){
        String s1 = "";
        //замена пары символов "This is a mixed up string." по промеру
        for(int i = 0; i < s.length() - 1; i += 2){
            s1 += s.charAt(i+1);
            s1 += s.charAt(i);
        }
        if (s.length() != s1.length()){
            s1 += s.charAt(s.length() - 1);
        }
        System.out.println(s1);
    }
    public static void noYelling(String s){
        //замена многих ????/!!!! на 1 ?/!
        if ((s.charAt(s.length() - 1) == '!' && s.charAt(s.length() - 2) == '!') || (s.charAt(s.length() - 1) == '?' && s.charAt(s.length() - 2) == '?')){
            int i = s.length() - 3;
            while (s.charAt(i) == s.charAt(s.length()-1)){
                i--;
            }
            System.out.println(s.substring(0, i+2));
        }
        else {
            System.out.println(s);
        }
    }
    public static void xPronounce(String s){
        String s1 = "";
        //замена букв, см номер
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'x'){
                if (i != s.length() - 1){
                    if (s.charAt(i - 1) == ' ' && s.charAt(i + 1) != ' '){
                        s1 += 'z';
                    }
                    else {
                        s1 += "cks";
                    }
                }
                else{
                    s1 += "cks";
                }
            }
            else {
                s1 += s.charAt(i);
            }
        }
        System.out.println(s1);
    }
    public static void largestGap(int[] x){
        int max = 0;
        //найти наибольший разрыв между числами в отсортированном массиве
        Arrays.sort(x);
        for (int i = 0; i < x.length - 1; i++){
            if (x[i+1] - x[i] > max){
                max = x[i+1] - x[i];
            }
        }
        System.out.println(max);
    }
    public static void InhaleExhale(int x){
        //обратное кодирование
        String s = Integer.toString(x);
        int[] a = new int[s.length()];
        int k = 0; int k1 = x;
        for (int i = 0; i < a.length; i++) {
            a[i] += x % 10;
            x /= 10;
        }
        Arrays.sort(a);
        for (int j : a) {
            k = k * 10 + j;
        }
        System.out.println(k1 - k);
    }
    public static void commonLastVowel(String[] x){
        /*
        String s1 = "aeiouy";
        x = x.toLowerCase();
        int max = 0; int ind = -1;
        for (int i = 0; i < s1.length(); i++){
            if (max < StringUtils.countMatches(x, s1.charAt(i))){
                max = StringUtils.countMatches(x, s1.charAt(i));
                ind = i;
            }
        }
        System.out.println(s1.charAt(ind));
         */
        //вернуть самую распространенную гласную букву в конце слов
        String s1 = "aeiouy";
        int max = 0; int l = -1;
        int[] k = new int[6];
        for (int i = 0; i < x.length; i++){
            x[i] = x[i].toLowerCase();
            for (int j = 0; j < s1.length(); j++){
                if (s1.charAt(j) == x[i].charAt(x[i].length()-1)){
                    k[j]++;
                }
            }
        }
        for (int i = 0; i < k.length; i++){
            if (k[i] > max){
                max = k[i];
                l = i;
            }
        }
        if (l != -1){
            System.out.println(s1.charAt(l));
        }
        else{
            System.out.println("Все слова оканчиваются на согласные");
        }
    }
    public static void memeSum(int x, int y){
        //выплощение мема в жизнь
        int r = 0; Integer x1 = 0; Integer y1 = 0; String s = "";
        if (x < y){
            r = x;
            x = y;
            y = r;
        }
        while (x != 0){
            x1 = x % 10;
            y1 = y % 10;
            if (x1 + y1 > 10){
                s += Integer.toString(x1+y1).charAt(1);
                s += Integer.toString(x1+y1).charAt(0);
            }
            else{
                s += Integer.toString(x1+y1);
            }
            x /= 10;
            y /= 10;
        }
        System.out.println(new StringBuilder(s).reverse().toString());
    }
    public static void unrepeated(String s){
        //удаление повторяющихся символов
        String s1 = "";
        for (char c : s.toCharArray()){
            if (s1.indexOf(c) == -1){
                s1 += c;
            }
        }
        System.out.println(s1);
    }
}

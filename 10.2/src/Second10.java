import java.util.Scanner;
import java.lang.String;
import java.lang.Math;

public class Second10 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Введите номер задания(-1 = stop): ");
            int n1 = scan.nextInt();
            if (n1 == -1) {
                break;
            }
            switch (n1) {
                case (1):
                    System.out.print("Введите номер дома и длину улицы: ");
                    int x = scan.nextInt();
                    int y = scan.nextInt();
                    System.out.println("Номер дома на противоположносой стророне улицы: " + oppositeHouse(x,y));
                    break;
                case (2):
                    System.out.print("Введите имя и фамилию человека: ");
                    Scanner str = new Scanner(System.in);
                    String[] s = str.nextLine().split(" ");
                    System.out.println(nameShuffle(s));
                    break;
                case (3):
                    System.out.print("Введите цену и процент скидки: ");
                    x = scan.nextInt();
                    y = scan.nextInt();
                    System.out.println(discount(x, y));
                    break;
                case (4):
                    System.out.print("Введите кол-во элементов в массиве: ");
                    int p1 = scan.nextInt();
                    int[] p = new int[p1];
                    System.out.print("Введите элементы массива': ");
                    for (int i = 0; i < p.length; i++){
                        p[i] = scan.nextInt();
                    }
                    System.out.println(differenceMaxMin(p));
                    break;
                case (5):
                    System.out.print("Введите 3 числа: ");
                    x = scan.nextInt();
                    y = scan.nextInt();
                    int z = scan.nextInt();
                    System.out.println(equal(x,y,z));
                    break;
                case (6):
                    System.out.print("Введите строку: ");
                    Scanner str1 = new Scanner(System.in);
                    String s1 = str1.nextLine();
                    System.out.println(reverse(s1));
                    break;
                case (7):
                    System.out.print("Введите 3 числа: ");
                    x = scan.nextInt();
                    y = scan.nextInt();
                    z = scan.nextInt();
                    System.out.println(programmers(x,y,z));
                    break;
                case (8):
                    System.out.print("Введите строку: ");
                    Scanner str2 = new Scanner(System.in);
                    String s2 = str2.nextLine();
                    System.out.println(getXO(s2));
                    break;
                case (9):
                    System.out.print("Введите строку: ");
                    Scanner str3 = new Scanner(System.in);
                    String s3 = str3.nextLine();
                    System.out.println(bomb(s3));
                    break;
                case (10):
                    System.out.print("Введите 2 строки: ");
                    Scanner str4 = new Scanner(System.in);
                    String s4 = str4.nextLine();
                    String s5 = str4.nextLine();
                    System.out.println(sameAscii(s4,s5));
                    break;
            }
        }
    }

    private static int oppositeHouse(int x, int y){
        return (y*2+1)-x;
    }
    private static String nameShuffle(String[] s){
        return s[1] + " " + s[0];
    }
    private static double discount(int x, int y){
        return x * y / 100;
    }
    private static int differenceMaxMin(int[] x){
        int max = x[0]; int min = x[0];
        for (int i = 1; i < x.length; i++){
            if (x[i]<min){
                min = x[i];
            }
            if (x[i]>max){
                max= x[i];
            }
        }
        return max - min;
    }
    private static int equal(int x, int y, int z){
        int a = 0;
        if (x == y || y == z || z == x){
            a = 2;
        }
        if (x == y && y == z){
            a = 3;
        }
        return a;
    }
    private static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
    private static int programmers(int x, int y, int z){
        return Math.max(Math.max(x,y),z)-Math.min(Math.min(x,y),z);
    }
    private static boolean getXO(String s){
        int a = 0; int b = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'o' || s.charAt(i) == 'O') {
                a++;
            }
            if (s.charAt(i) == 'x' || s.charAt(i) == 'X') {
                b++;
            }
        }
        return a == b;
    }
    private static String bomb(String s){
        s = s.toUpperCase();
        int a = s.indexOf("BOMB");
        if (a == -1){
            return "Relax, there's no bomb.";
        }
        else {
            return "DUCK!";
        }
    }
    //неверно
    private static boolean sameAscii(String s, String s1){
        int a = 0; int b = 0;
        for (int i = 0; i < s.length(); i++){
            a += s.charAt(i);
        }
        for (int i = 0; i < s1.length(); i++){
            b += s1.charAt(i);
        }
        return a == b;
    }

}

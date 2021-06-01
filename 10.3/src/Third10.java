import java.lang.reflect.Array;
import java.util.Scanner;
import java.lang.String;
import java.lang.Math;

public class Third10 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Введите номер задания(-1 = stop): ");
            int n1 = scan.nextInt();
            if (n1 == -1) {
                break;
            }
            switch (n1) {
                case (1):
                    System.out.print("Введите кол-во городов: ");
                    int n2 = scan.nextInt();
                    Scanner str = new Scanner(System.in);
                    String[][] s = new String[n2][2];
                    for (int i = 0; i < n2; i++){
                        System.out.print("Введите название города: ");
                        s[i][0] = str.nextLine();
                        System.out.print("Введите население города: ");
                        s[i][1] = str.nextLine();
                    }
                    millionsRounding(s);
                    break;
                case (2):
                    System.out.print("Введите малую сторону: ");
                    int x = scan.nextInt();
                    otherSides(x);
                    break;
                case (3):
                    System.out.print("Введите данные 1 игрока: ");
                    Scanner str1 = new Scanner(System.in);
                    String s1 = str1.nextLine();
                    System.out.print("Введите данные 2 игрока: ");
                    String s2 = str1.nextLine();
                    rps(s1, s2);
                    break;
                case (4):
                    System.out.print("Введите кол-во чисел в массиве: ");
                    x = scan.nextInt();
                    int[] a = new int[x];
                    System.out.print("Введите массив: ");
                    for (int i = 0; i < x; i++){
                        a[i] = scan.nextInt();
                    }
                    warOfNumbers(a,x);
                    break;
                case (5):
                    System.out.print("Введите строку: ");
                    Scanner str2 = new Scanner(System.in);
                    String s3 = str2.nextLine();
                    reverseCase(s3);
                    break;
                case (6):
                    System.out.print("Введите строку: ");
                    Scanner str3 = new Scanner(System.in);
                    String s4 = str3.nextLine();
                    inatorInator(s4);
                    break;
                case (7):
                    System.out.print("Введите высоту, ширину, глубину кирпича и ширину, высоту отверстия: ");
                    x = scan.nextInt();
                    int y = scan.nextInt();
                    int z = scan.nextInt();
                    int t = scan.nextInt();
                    int m = scan.nextInt();
                    doesBrickFit(x,y,z,t,m);
                    break;
                case (8):
                    System.out.print("Введите кол-во топлива: ");
                    double x1 = scan.nextDouble();
                    System.out.print("Введите расход топлива(литры/100 км): ");
                    double y1 = scan.nextDouble();
                    System.out.print("Введите кол-во пассажиров: ");
                    z = scan.nextInt();
                    System.out.print("Введите кондиционер(true/false): ");
                    boolean l = scan.nextBoolean();
                    totalDistance(x1, y1, z, l);
                    break;
                case (9):
                    System.out.print("Введите кол-во чисел в массиве: ");
                    x = scan.nextInt();
                    System.out.print("Введите массив чисел: ");
                    a = new int[x];
                    for (int i = 0; i < x; i++){
                        a[i] = scan.nextInt();
                    }
                    mean(a, x);
                    break;
                case (10):
                    System.out.print("Введите число: ");
                    x = scan.nextInt();
                    parityAnalysis(x);
                    break;
            }
        }
    }
    private static void millionsRounding(String[][] s){
        double a = 0;
        // округления населения до миллиона
        System.out.println("[");
        for (int i = 0; i < s.length; i++){
            a = Integer.parseInt(s[i][1]);
            a = a / 1000000;
            s[i][1] = Math.round(a)*1000000 + "";
            System.out.println("["+s[i][0]+", "+s[i][1]+"]");
        }
        System.out.println("]");
    }
    private static void otherSides(int n){
        double a = 1; double b = 1;
        // поиск 2 сторон треугольника 30, 90 и 60
        a = 2*n; b = Math.sqrt(3)*n;
        System.out.print("[");
        System.out.printf("%.2f",a);
        System.out.print(", ");
        System.out.printf("%.2f",b);
        System.out.println("]");
    }
    private static void rps(String s, String s1){
        // игра в кам./нож./бум.
        s = s.toUpperCase();
        s1 = s1.toUpperCase();
        if (s.equals(s1)){
            System.out.println("Ничья");
        }
        else {
            if (s.equals("КАМЕНЬ")){
                if (s1.equals("НОЖНИЦЫ")){
                    System.out.println("Выиграл 1");
                }
                else{
                    System.out.println("Выиграл 2");
                }
            }
            if (s.equals("НОЖНИЦЫ")){
                if (s1.equals("БУМАГА>")){
                    System.out.println("Выиграл 1");
                }
                else{
                    System.out.println("Выиграл 2");
                }
            }
            if (s.equals("БУМАГА")){
                if (s1.equals("КАМЕНЬ")){
                    System.out.println("Выиграл 1");
                }
                else{
                    System.out.println("Выиграл 2");
                }
            }
        }
    }
    private static void warOfNumbers(int[] n,int n1){
        double a = 0; double b = 0;
        // сумма четных против суммы нечетных (из массива) исходя из того какая сум. больше
        for (int i = 0; i < n1; i++){
            if (n[i] % 2 == 0){
                a += n[i];
            }
            else{
                b += n[i];
            }
        }
        System.out.println(Math.abs(a - b));
    }
    private static void reverseCase(String s) {
        //замена регистров в строке
        char[] chars = s.toCharArray();
        s = "";
        for (char c : chars) {
            if (Character.isLowerCase(c))
                c = Character.toUpperCase(c);
            else
                c = Character.toLowerCase(c);
            s += c;
        }
        System.out.println(s);
    }
    private static void inatorInator(String s){
        //инаторы
        String s1 = s.toUpperCase();
        boolean a = false;
        char[] vowels= {'A', 'E', 'I', 'O', 'U', 'Y'};
        for(char c:vowels){
            if(s1.charAt(s.length()-1) == c){
                a = true;
            }
        }
        if (a){
            System.out.println(s+"-inator "+s.length()+"000");
        }
        else{
            System.out.println(s+"inator "+s.length()+"000");
        }
    }
    private static void doesBrickFit(int x, int y, int z, int t, int m){
        //кирпись и дыра
        if ((x <= t && y <= m) || (x <= m && y <= t) || (y <= t && z <= m) || (z <= t && y <= m) || (x <= t && z <= m) || (z <= t && x <= m)){
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
    private static void totalDistance(double x, double y, int z, boolean l){
        //расчет проезда исходя из множества условий
        double a = 0; double b = 0;
        if (z != 0){
            if (l){
                a = 1.1;
                b = (x / ((y + y * z * 0.05) * a)) * 100;
                System.out.printf("%.2f\n", b);
            }
            else {
                b = (x / ((y + y * z * 0.05))) * 100;
                System.out.printf("%.2f\n", b);
            }
        }
        else {
            if (l){
                a = 1.1;
                b = (x / (y * a)) * 100;
                System.out.printf("%.2f\n", b);
            }
            else {
                b = (x / y) * 100;
                System.out.printf("%.2f\n", b);
            }
        }
    }
    private static void mean(int[] a, int x){
        //среднее значение массива
        double f = 0; double sum = 0;
        for (int i = 0; i < x; i++){
            sum += a[i];
        }
        f = sum / x;
        System.out.printf("%.2f\n", f);
    }
    private static void parityAnalysis(int x){
        //узнаем четность суммы цифр в числе и числа
        int z = 0; int y = 0;
        z = x;
        while(z != 0){
            //Суммирование цифр числа
            y += (z % 10);
            z /= 10;
        }
        if ((x % 2 == y % 2 )) {
            System.out.println("true");
        }
        else{
            System.out.println("false");
        }
    }
}

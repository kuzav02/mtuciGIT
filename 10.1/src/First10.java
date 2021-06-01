import java.util.Scanner;

public class First10 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Введите номер задания(-1 = stop): ");
            int n1 = scan.nextInt();
            if (n1 == -1){
                break;
            }
            switch (n1) {
                case (1):
                    System.out.print("Введите количество минут: ");
                    int n = scan.nextInt();
                    System.out.println(n + " минут это " + convert(n) + " секунд.");
                    break;

                case (2):
                    System.out.print("Введите количество забитых 2-х очковых и 3-х очковых бросков: ");
                    int x = scan.nextInt();
                    int y = scan.nextInt();
                    System.out.println("Всего очков: " + Points(x, y));
                    break;

                case (3):
                    System.out.print("Введите количество побед, ничьих и поражений: ");
                    x = scan.nextInt();
                    y = scan.nextInt();
                    int z = scan.nextInt();
                    System.out.println("Всего очков: " + footballPoints(x, y, z));
                    break;

                case (4):
                    System.out.print("Введите число для проверки деления: ");
                    x = scan.nextInt();
                    System.out.println(divisibleByFive(x));
                    break;

                case (5):
                    System.out.print("Введите 2 логический значения (true, false): ");
                    boolean x1 = scan.nextBoolean();
                    boolean y1 = scan.nextBoolean();
                    System.out.println(and(x1, y1));
                    break;

                case (6):
                    System.out.print("Введите кол-во краски и размеры стены: ");
                    x = scan.nextInt();
                    y = scan.nextInt();
                    z = scan.nextInt();
                    System.out.println(howManyWalls(x, y, z));
                    break;

                case (7):
                    System.out.print("Введите число: ");
                    x = scan.nextInt();
                    System.out.println(Challenge.squared(x));
                    break;

                case (8):
                    System.out.print("Введите 3 аргумента prob, prize, pay: ");
                    double prob = scan.nextDouble();
                    double prize = scan.nextDouble();
                    double pay = scan.nextDouble();
                    System.out.println(profitableGamble(prob, prize, pay));
                    break;

                case (9):
                    System.out.print("Введите 3 аргумента prob, prize, pay: ");
                    x = scan.nextInt();
                    y = scan.nextInt();
                    System.out.println(frames(x, y));
                    break;

                case (10):
                    System.out.print("Введите 2 числа для определения остатка: ");
                    x = scan.nextInt();
                    y = scan.nextInt();
                    System.out.println(mod(x, y));
                    break;
            }
        }
    }

    private static int convert(int n){
        return n*60;
    }
    private static int Points(int x, int y){
        return x*2+y*3;
    }
    private static int footballPoints(int x, int y, int z){
        return x*3+y;
    }
    private static boolean divisibleByFive(int x){
        return x % 5 == 0;
    }
    private static boolean and(boolean x, boolean y){
        return x && y;
    }
    private static int howManyWalls(int x, int y, int z){
        return (int )(x / (y*z));
    }
    public static class Challenge {
        public static int squared(int a) {
            return a * a;
        }
    }
    private static boolean profitableGamble(double x, double y, double z){
        return x * y > z;
    }
    private static int frames(int x, int y){
        return x*y*60;
    }
    private static int mod(int x, int y){
        return x - y * (x / y);
    }
}

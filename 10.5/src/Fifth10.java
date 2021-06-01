import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.lang.String;
import java.lang.Math;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fifth10 {
    public static void main(String[] args){
        System.out.println("Номер 1");
        // проверка шаблона строк
        String s = "PPPIIIQQQ";
        String s1 = "AAASSSDDD";
        sameLetterPattern(s, s1);
        System.out.println();
        System.out.println("Номер 2");
        // паук идет
        s = "H4";
        s1 = "C2";
        String s3 = "";
        s3 = spiderVsFly(s, s1);
        System.out.println(s3);
        System.out.println(spiderVsFly("A4", "A2"));
        System.out.println(spiderVsFly("H3", "E2"));
        System.out.println(spiderVsFly("A4", "D2"));
        System.out.println(spiderVsFly("A4", "E1"));
        System.out.println(spiderVsFly("A2", "B2"));
        System.out.println("Номер 3");
        // рекурсивные подсчет кол-ва цифр
        long x = 1289396382412417328L;
        long k = digitsCount(x);
        System.out.println(k);
        System.out.println();
        System.out.println("Номер 4");
        //игра text-twist
        String[] mass = {"cat", "create", "sat"};
        String[] mass1 = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        s = "caster";
        System.out.println(totalPoints(mass, s));
        System.out.println(totalPoints(mass1, "tossed"));
        System.out.println();
        System.out.println("Номер 5");
        //длинна самого длинного последовательного запуска
        int[] p = {1, 2, 3, 2, 1, 7, 8, 9, 10, 11, 12};
        System.out.println(longestRun(p));
        System.out.println();
        System.out.println("Номер 6");
        //ну мы дополняем его, да
        String[] percent = {"95%", "83%", "90%", "87%", "88%", "93%"};
        System.out.println(takeDownAverage(percent));
        System.out.println();
        System.out.println("Номер 7");
        //располагаем предложение по числам
        System.out.println(rearrange("Tesh3 th5e 1I lov2e way6 she7 j4ust i8s."));
        System.out.println(rearrange("the4 t3o man5 Happ1iest of6 no7 birt2hday steel8!"));
        System.out.println();
        System.out.println("Номер 8");
        //делаем число больше меняя цифры
        System.out.println(maxPossible(523, 76));
        System.out.println(maxPossible(9132, 5564));
        System.out.println();
        System.out.println("Номер 9");
        //календарь
        System.out.println(timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome"));
        System.out.println();
        System.out.println("Номер 10");
        //новое ли число
        System.out.println(isNew(3));
        System.out.println(isNew(30));
        System.out.println(isNew(123));
        System.out.println(isNew(301));
        System.out.println(isNew(12002));
        System.out.println(isNew(10022));

    }

    // проверка шаблона строк
    public static void sameLetterPattern(String s, String s1){
        String x = ""; String y = ""; String x1 = ""; String y1 = "";
        s = s.toUpperCase();
        s1 = s1.toUpperCase();
        for (int i = 0; i < s.length(); i ++){
            if (x1.indexOf(s.charAt(i)) == -1){
                x1 += s.charAt(i);
                x += x1.indexOf(s.charAt(i));
            }
            else {
                x += x1.indexOf(s.charAt(i));
            }
        }
        for (int i = 0; i < s1.length(); i ++){
            if (y1.indexOf(s1.charAt(i)) == -1){
                y1 += s1.charAt(i);
                y += y1.indexOf(s1.charAt(i));
            }
            else {
                y += y1.indexOf(s1.charAt(i));
            }
        }
        System.out.println(x.equals(y));
    }
    // паук идет
    public static String spiderVsFly(String spider, String fly){
        int sx = spider.charAt(0) - 65;
        int sy = spider.charAt(1) - 48;
        int fx = fly.charAt(0) - 65;
        int fy = fly.charAt(1) - 48;

        double strategyDist1 = sy + fy;
        double strategyDist2 = Math.abs(sy - fy) + ((sx + fx) % 8) * fy * 0.76536686473;

        String path = "";
        if (strategyDist1 <= strategyDist2) {
            for (int i = 0; i < sy; i++) {
                path += String.valueOf(spider.charAt(0)) + String.valueOf(sy - i) + "-";
            }
            path += "A0-";
            for (int i = 0; i < fy; i++) {
                path += String.valueOf(fly.charAt(0)) + String.valueOf(i+1) + "-";
            }
        } else {
            for (int i = 0; i < Math.abs(sy - fy); i++) {
                path += spider.charAt(0);
                if (sy > fy) path += sy - i;
                else path += sy + i;
                path += '-';
            }
            for (int i = 0; i <= (sx + fx) % 8; i++) {
                path += (char)(65 + (sx + i) % 8) + String.valueOf(fly.charAt(1)) + "-";
            }
        }
        return path.substring(0, path.length() - 1);
    }
    // рекурсивные подсчет кол-ва цифр
    public static int digitsCount(long x){
        x /= 10;
        int k = 0;
        if (x == 0){
            return k+1;
        }
        else {
            k = digitsCount(x);
            k += 1;
        }
        return k;
    }
    //игра text-twist
    public static int totalPoints(String[] s, String slovo){
        int score = 0;
        for (String word: s){
            boolean isRightWord = true;
            String wordForTest = slovo;
            for (int i=0; i < word.length(); i++){
                String chr = Character.toString(word.charAt(i));
                if (wordForTest.contains(chr)){
                    wordForTest = wordForTest.replaceFirst(chr, "");
                }
                else{
                    isRightWord = false;
                    break;
                }
            }
            if (isRightWord){
                score += word.length() - 2;
                if (word.length() == 6){
                    score += 50;
                }
            }
        }
        return score;
    }
    //длинна самого длинного последовательного запуска
    public static int longestRun(int[] arr){
        int count = 1;
        int maxCount = 0;
        boolean isUpper;
        if (arr.length > 1){
            if (arr[0] > arr[1]){
                isUpper = false;
            }
            else{
                isUpper = true;
            }
        }
        else{
            return 1;
        }
        for (int i=1; i < arr.length; i++){
            if (arr[i-1] > arr[i] && isUpper){
                count = 1;
                isUpper = false;
                continue;
            }
            if (arr[i-1] < arr[i] && !isUpper){
                count = 1;
                isUpper = true;
                continue;
            }

            if (Math.abs(arr[i-1] - arr[i]) == 1){
                count++;
            }
            else{
                if (count > maxCount){
                    maxCount = count;
                }
                count = 1;
            }
        }
        if (count > maxCount){
            maxCount = count;
        }
        return maxCount;
    }
    //ну мы дополняем его, да
    public static String takeDownAverage(String arr[]){
        double sum = 0.0;
        int count = 0;
        double downRate = 0.05;
        for (int i = 0; i< arr.length; i++){
            double rate = Double.parseDouble(arr[i].substring(0, arr[i].length() - 1))  / 100.0; // "x%" to (x / 100)
            sum += rate;
            count++;
        }
        double x = (sum / count - downRate) * (count + 1) - sum;
        x *= 100;
        String ans = Integer.toString((int) x) + "%";
        return ans;
    }
    //располагаем предложение по числам
    public static String rearrange(String wrongStr){
    String[] wrongStrSplited = wrongStr.split(" ");
    String[] resultStrArr = new String[wrongStrSplited.length];
    for (String word: wrongStrSplited){
        if (word.equals("")){
            continue;
        }
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(word);
        String numStr = "";
        while (matcher.find()) {
            int start=matcher.start();
            int end=matcher.end();
            numStr += (word.substring(start, end));
        }
        int position = Integer.parseInt(numStr) ;
        word = word.replaceAll(numStr, "");
        if (position != resultStrArr.length){
            word += " ";
        }
        resultStrArr[position - 1] = word;

    }
    String resultStr = "";
    for (String word: resultStrArr){
        resultStr += word;
    }
    return resultStr;
}
    //делаем число больше меняя цифры
    public static int maxPossible(int firstNum, int secondNum){
        String firstNumStr = Integer.toString(firstNum);
        int[] firstNumbers = new int[firstNumStr.length()];
        for (int i=0; i <firstNumStr.length(); i++){
            firstNumbers[i] = Integer.parseInt(firstNumStr.substring(i, i+1));
        }
        String secondNumStr = Integer.toString(secondNum);
        int[] secondNumbers = new int[secondNumStr.length()];
        for (int i=0; i <secondNumStr.length(); i++){
            secondNumbers[i] = Integer.parseInt(secondNumStr.substring(i, i+1));
        }
        Arrays.sort(secondNumbers);

        String res = "";
        int i = 0;
        int indexOfMaxN = secondNumbers.length - 1;
        while (i < firstNumbers.length){
            if (firstNumbers[i] < secondNumbers[indexOfMaxN]){
                res += Integer.toString(secondNumbers[indexOfMaxN]);
                secondNumbers[indexOfMaxN] = 0;
                Arrays.sort(secondNumbers);
            }
            else
                res += Integer.toString(firstNumbers[i]);
            i++;
        }
        return Integer.parseInt(res);
    }
    //календарь
    public static String timeDifference(String cityA, String cityATime, String cityB){
        Map<String, String> cities = new HashMap<String, String>();
        cities.put("Los Angeles", "- 08:00");
        cities.put("New York", "- 05:00");
        cities.put("Caracas", "- 04:30");
        cities.put("Buenos Aires", "- 03:00");
        cities.put("London", "+ 00:00");
        cities.put("Rome", "+ 01:00");
        cities.put("Moscow", "+ 03:00");
        cities.put("Tehran", "+ 03:30");
        cities.put("New Delhi", "+ 05:30");
        cities.put("Beijing", "+ 08:00");
        cities.put("Canberra", "+ 10:00");

        int modA = 1;
        int modB = 1;
        if (cities.get(cityA).substring(0, 1).equals("-"))
            modA = -1;
        if (cities.get(cityB).substring(0, 1).equals("-"))
            modB = -1;
        int timeAHours = modA * Integer.parseInt(cities.get(cityA).substring(2,4));
        int timeAMins = modA * Integer.parseInt(cities.get(cityA).substring(5,7));
        int timeBHours = modB * Integer.parseInt(cities.get(cityB).substring(2,4));
        int timeBMins = modB * Integer.parseInt(cities.get(cityB).substring(5,7));

        SimpleDateFormat formatDateIn = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.ENGLISH);
        Date date;
        try {
            date = formatDateIn.parse(cityATime);
        }
        catch (ParseException e) {
            return null;
        }

        GregorianCalendar timeB = new GregorianCalendar();
        timeB.setTime(date);
        int diffHours = timeBHours - timeAHours;
        int diffmins = timeBMins - timeAMins;
        timeB.add(Calendar.HOUR, diffHours);
        timeB.add(Calendar.MINUTE, diffmins);
        SimpleDateFormat formatDateOut = new SimpleDateFormat("yyyy-M-d HH:mm");
        String ans = formatDateOut.format(timeB.getTime());
        return ans;
    }
    //новое ли число
    public static boolean isNew (int n) {
        ArrayList<Integer> digits = new ArrayList<Integer>();
        int n1 = n;
        while (n > 0 ) { //добавляем все числа в список
            digits.add(n%10);
            n/=10;
        }
        digits.sort(Collections.reverseOrder());//сортируем по убыванию
        if(digits.get(digits.size()-1)==0){ //если последний элемент 0
            for (int i = digits.size()-1; i >= 0; i--) { //проходим по списку
                if(digits.get(i)!=0){// первая цифра не равная нулю
                    digits.set(digits.size()-1, digits.get(i));//меняем ее местами с последним (нулевым) элементом
                    digits.set(i, 0);//на место цифры добавляем ноль
                    break;
                }
            }
        }
        int newNum = 0;
        for (int i = 0; i < digits.size(); i++) {
            newNum += digits.get(i) * (int) Math.pow(10, i);}//собираем из списка число (цифры в числе будут по убыванию)
        //оно будет наименьшим тз возможных комбинаций
        if (n1 > newNum) return false;
        return true;
    }
}



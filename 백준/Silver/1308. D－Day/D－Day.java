import java.util.Scanner;

public class Main{
    private static int calc(int year, int month, int day){
        int days[] = {31,28,31,30,31,30,31,31,30,31,30,31};

        int result = 0;
        for(int i = 1 ; i < year ; i ++){
            if(check(i))
                result += 1;
            result += 365;
        }

        for(int i = 1 ; i < month ; i ++){
            if(i == 2 && check(year))
                result += 1;
            result += days[i - 1];
        }

        return result + day;
    }
    private static boolean check(int year){
        if((year % 4 == 0 && year % 100 != 0 ) || year % 400 == 0)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startYear = scanner.nextInt();
        int startMonth = scanner.nextInt();
        int startDay = scanner.nextInt();

        int endYear = scanner.nextInt();
        int endMonth = scanner.nextInt();
        int endDay = scanner.nextInt();

        int firstTotal = calc(startYear,startMonth,startDay);
        int lastTotal = calc(endYear,endMonth,endDay);

        if(endYear - startYear > 1000 || (endYear - startYear == 1000 && (startMonth < endMonth || (startMonth == endMonth && startDay <= endDay))))
            System.out.println("gg");
        else
            System.out.println("D-" + (lastTotal - firstTotal));
        scanner.close();
    }
}
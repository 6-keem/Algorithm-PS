import java.util.Scanner;

public class Main{
    private static long[] dp = null;
    private static long calc(int n){
        if(n == 0 || n == 1)
            return n;
        if(dp[n] != -1)
            return dp[n];
        return dp[n] = calc(n-1) + calc(n-2);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new long[n + 1];
        for(int i = 0 ; i <= n ; i ++)
            dp[i] = -1;
        dp[1] = 0;
        System.out.println(calc(n));
        scanner.close();
    }
}
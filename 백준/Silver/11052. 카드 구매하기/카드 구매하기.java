import java.io.*;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        int [] value = new int[n + 1];
        int [] dp = new int[n + 1];

        String []str = bufferedReader.readLine().split(" ");
        for(int i = 1 ; i < value.length ; i++)
            value[i] = Integer.parseInt(str[i-1]);

        for(int i = 1 ; i <= n ; i ++){
            for(int j = 1 ; j <= i ; j++){
                dp[i] = Math.max(dp[i-j] + value[j], dp[i]);
            }
        }
        bufferedWriter.write(Integer.toString(dp[n]));
        bufferedWriter.flush();
    }
}
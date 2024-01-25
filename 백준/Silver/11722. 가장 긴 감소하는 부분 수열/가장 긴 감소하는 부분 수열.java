import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        int []arr = new int[n];
        int []dp = new int[n];
        String []str = bufferedReader.readLine().split(" ");
        for(int i = 0 ; i < str.length ; i ++)
            arr[i] = Integer.parseInt(str[i]);

        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i ++){
            dp[i] = 1;
            for(int j = 0 ; j < i ; j ++){
                if(arr[i] < arr[j] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
            if(max < dp[i])
                max = dp[i];
        }
        bufferedWriter.write(Integer.toString(max));
        bufferedWriter.flush();
    }
}
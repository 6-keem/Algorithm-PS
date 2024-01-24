import java.io.*;

public class Main {
    static int n, count = 0;
    static int []array = null;
    static int []dp = null;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bufferedReader.readLine());
        array = new int[n];
        dp = new int[n];

        String []str = bufferedReader.readLine().split(" ");
        for(int i = 0 ; i < n ; i ++)
            array[i] = Integer.parseInt(str[i]);

        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            dp[i] = 1;
            for(int j = 0 ; j < i ; j ++){
                if(array[j] < array[i] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
            if(max < dp[i])
                max = dp[i];
        }

        bufferedWriter.write(Integer.toString(max));
        bufferedWriter.flush();
    }
}
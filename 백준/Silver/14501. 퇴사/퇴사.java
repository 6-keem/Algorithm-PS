import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        int [][]num = new int[n+1][2];
        int []dp = new int[n + 1];

        for(int i = 0 ; i < n ; i ++){
            String []str = bufferedReader.readLine().split(" ");
            num[i][0] = Integer.parseInt(str[0]);
            num[i][1] = Integer.parseInt(str[1]);
        }

        for(int i = 0 ; i < n ; i ++){
            if(i + num[i][0] <= n){
                dp[i + num[i][0]] = Math.max(dp[i] + num[i][1], dp[i + num[i][0]]);
            }
            dp[i+1] = Math.max(dp[i+1],dp[i]);
        }
        bufferedWriter.write(Integer.toString(dp[n]));
        bufferedWriter.flush();
    }
}
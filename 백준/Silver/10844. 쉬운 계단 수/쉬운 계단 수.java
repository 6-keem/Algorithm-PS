import java.io.*;

public class Main {
    public static final long MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(bufferedReader.readLine());
        long [][] array = new long[n][10];

        for(int i = 0 ; i < 10 ; i ++)
            array[0][i] = 1;
        array[0][0] = 0;

        for(int i = 0 ; i < n - 1; i ++) {
            array[i+1][0] = array[i][1];
            for(int j = 1 ; j < 9 ; j ++)
                array[i+1][j] = (array[i][j-1] + array[i][j+1]) % MOD;
            array[i+1][9] = array[i][8];
        }

        long result = 0;
        for(int i = 0 ; i < 10 ; i ++)
            result = (result + array[n-1][i]) % MOD;

        bufferedWriter.write(Long.toString(result));
        bufferedWriter.flush();
    }
}
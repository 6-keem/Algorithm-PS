import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int []nums = new int[n];
        String []str = bufferedReader.readLine().split(" ");

        for(int i = 0 ; i < n ; i ++)
            nums[i] = Integer.parseInt(str[i]);
        int max = nums[0];
        for(int i = 1 ; i < n ; i++){
            nums[i] = Math.max(nums[i], nums[i] + nums[i-1]);
            if(nums[i] > max)
                max = nums[i];
        }
        bufferedWriter.write(Integer.toString(max));
        bufferedWriter.flush();
    }
}
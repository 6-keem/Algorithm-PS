import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int n, length;
    static int [] nums = null;
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String [] str = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        length = Integer.parseInt(str[1]);
        nums = new int[length];
        backTracking(1,0);
        bufferedWriter.flush();
    }
    public static void backTracking(int index, int count) throws IOException {
        if(count == length){
            for(int num : nums)
                bufferedWriter.write(Integer.toString(num) + " ");
            bufferedWriter.newLine();
        }
        else {
            for(int i = index ; i <= n ; i ++){
                nums[count] = i;
                backTracking(i, count + 1);
            }
        }
    }
}
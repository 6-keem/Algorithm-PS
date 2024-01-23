import java.io.*;

//https://st-lab.tistory.com/118 - 2차원 배열으로 풀어보려 했지만 실패하여 풀이 참조
public class Main {
    static int n, count = 0;
    static int []array = null;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(bufferedReader.readLine());

        array = new int[n];
        backtracking(0);
        bufferedWriter.write(Integer.toString(count));
        bufferedWriter.flush();
    }
    public static boolean checkCollision(int qCount){
        for(int i = 0 ; i < qCount ; i++){
            if(array[i] == array[qCount])
                return false;
            else if(Math.abs(qCount - i) == Math.abs(array[qCount] - array[i]))
                return false;
        }
        return true;
    }
    public static void backtracking(int qCount){
        if(qCount == n)
            count++;
        else {
            for(int i = 0 ; i < n ; i ++){
                array[qCount] = i;
                if(checkCollision(qCount))
                    backtracking(qCount+1);
            }
        }
    }
}
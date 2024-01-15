import java.io.*;
import java.util.Collections;
import java.util.Vector;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String []input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        Vector<Integer> vt = new Vector<>();
        int count = 0;

        for(int i = 0 ; i < N ; i ++){
            input = bufferedReader.readLine().split(" ");
            int ai = Integer.parseInt(input[0]);
            int bi = Integer.parseInt(input[1]);
            if(ai >= bi)
                vt.add(0);
            else
                vt.add(Math.abs(bi - ai));
        }

        Collections.sort(vt);
        int money = 0;
        while(count != K){
            money = vt.remove(0);
            count++;
        }
        bufferedWriter.write(Integer.toString(money));
        bufferedWriter.flush();
    }
}
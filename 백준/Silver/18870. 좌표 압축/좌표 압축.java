import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        Vector<Integer> vt = new Vector<>();
        int n = Integer.parseInt(bufferedReader.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        String []tokens = bufferedReader.readLine().split(" ");
        for(int i = 0 ; i < n ; i++)
            vt.add(Integer.parseInt(tokens[i]));

        Vector<Integer> sorted = new Vector<>(vt);
        Collections.sort(sorted);

        int count = 0;
        for(int i = 0 ; i < sorted.size() ; i++){
            if(hashMap.get(sorted.get(i)) == null)
                hashMap.put(sorted.get(i), count++);
        }
        for(int i = 0 ; i < vt.size() ; i ++)
            bufferedWriter.write(Integer.toString(hashMap.get(vt.get(i))) + " ");
        bufferedWriter.flush();
    }
}
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[26];
        for(int i = 0; i < arr.length; i++)
            arr[i] = -1;

        String str = bufferedReader.readLine();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(arr[ch-'a'] == -1)
                arr[ch-'a'] = i;
        }

        for(int n : arr)
            bufferedWriter.write(Integer.toString(n) + " ");
        bufferedWriter.flush();
    }
}
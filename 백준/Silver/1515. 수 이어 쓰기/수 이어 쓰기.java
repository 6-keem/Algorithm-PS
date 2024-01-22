import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = bufferedReader.readLine();

        int index = 1;
        int pos = 0;
        while (pos < str.length()) {
            char[] arr = Integer.toString(index++).toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == str.charAt(pos))
                    pos++;
                if (pos >= str.length())
                    break;
            }
        }

        bufferedWriter.write(Integer.toString(index-1));
        bufferedWriter.flush();
    }
}
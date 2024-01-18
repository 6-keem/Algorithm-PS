import java.io.*;
import java.util.HashMap;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> strToInt = new HashMap<>();
        HashMap<Integer,String> intToStr = new HashMap<>();

        String[] input = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        for(int i = 1 ; i <= N ; i ++){
            String name = bufferedReader.readLine();
            strToInt.put(name, i);
            intToStr.put(i,name);
        }

        for(int i = 0 ; i < M ; i++){
            String str = bufferedReader.readLine();
            try{
                int num = Integer.parseInt(str);
                bufferedWriter.write(intToStr.get(num));
            } catch (NumberFormatException e){
                bufferedWriter.write(Integer.toString(strToInt.get(str)));
            } finally {
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.flush();
    }
}
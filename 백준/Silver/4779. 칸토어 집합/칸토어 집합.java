import java.io.*;

public class Main{
    private static String[] line = null;

    private static void fill(int x, int n){
        if(n == 1)
            line[x] = "-";
        else {
            int count = 0;
            int size = n / 3;
            for(int i = 0 ; i < n ; i += size){
                if(count != 1)
                    fill(i + x, size);
                count ++;
            }
        }

    }
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            String str = null;
            while((str = bufferedReader.readLine()) != null){
                int n = (int) Math.pow(3, Integer.parseInt(str));
                line = new String[n];
                fill(0, n);
                for (int i = 0; i < n; i++) {
                    if (line[i] == null)
                        bufferedWriter.write(" ");
                    else
                        bufferedWriter.write("-");
                }
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch(IOException | NumberFormatException ignored){ }
    }
}
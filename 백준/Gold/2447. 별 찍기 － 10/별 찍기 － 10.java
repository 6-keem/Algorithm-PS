import java.io.*;
import java.util.Scanner;

public class Main{
    private static String[][] stars = null;
    private static void fill(int y, int x, int n, boolean blank){
        if(blank)
            return;
        if(n == 1)
            stars[y][x] = "*";
        else {
            int size = n/3;
            int count = 0;
            for(int i = 0 ; i < n ; i += size){
                for(int j = 0 ; j < n ; j += size){
                    if(count == 4)
                        fill(i + y, j + x, size, true);
                    else
                        fill(i + y, j + x, size, false);
                    count++;
                }
            }
        }
    }
    public static void main(String[] args) {
        // System.out.println() 사용 시 시간 초과
        // StringBuilder - Speed / BufferWriter - Memory
        
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        try{
            int size = Integer.parseInt(bufferedReader.readLine());
            stars = new String[size][size];
            fill(0,0,size, false);
            for(int i = 0 ; i < size ; i ++){
                for(int j = 0 ; j < size ; j++){
                    if(stars[i][j] == null)
                        bufferedWriter.write(" ");
                    else
                        bufferedWriter.write("*");
                }
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
        } catch (IOException exception){
            exception.printStackTrace();
        }

    }
}
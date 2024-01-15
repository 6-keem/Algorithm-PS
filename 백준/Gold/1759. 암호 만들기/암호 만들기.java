import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    static int L, C;
    static ArrayList<String> arrayList = new ArrayList<>();
    static boolean [] visited;
    static BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");

        L = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        visited = new boolean[C];
        input = bufferedReader.readLine().split(" ");

        for(String token : input)
            arrayList.add(token);

        Collections.sort(arrayList);
        backTracking(0, 0);
        bufferedWriter.flush();
    }
    private static void backTracking(int count, int index) throws IOException {
        if(count == L){
            int consonant = 0, vowel = 0;
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0 ; i < arrayList.size() ; i++){
                if(visited[i] == true){
                        list.add(arrayList.get(i));
                    if(check(arrayList.get(i)))
                        vowel++;
                    else
                        consonant++;
                }
            }
            if(0 < vowel && 1 < consonant){
                for(String token : list)
                    bufferedWriter.write(token);
                bufferedWriter.newLine();
            }
        }
        else {
            for(int i = index ; i < arrayList.size() ; i ++){
                visited[i] = true;
                backTracking(count + 1, i + 1);
                visited[i] = false;
            }
        }
    }
    private static boolean check(String str){
        switch (str){
            case "a":
            case "e":
            case "i":
            case "o":
            case "u":
                return true;
            default:
                return false;
        }
    }
}
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] input = bufferedReader.readLine().split(" ");

        boolean [] flag = new boolean[10];
        int length = input[0].length();
        int target = Integer.parseInt(input[0]);

        int n = Integer.parseInt(bufferedReader.readLine());
        int gap = Math.abs(target - 100);
        input = bufferedReader.readLine().split(" ");
        for(String str : input)
            flag[Integer.parseInt(str)] = true;

        for(int i = 0 ; i <= 999999 ; i++){
            String str = Integer.toString(i);
            boolean isAvail = true;
            for(int j = 0 ; j < str.length() ; j++){
                if(flag[Integer.parseInt(Character.toString(str.charAt(j)))]){
                    isAvail = false;
                    break;
                }
            }
            if(isAvail){
                int min = Math.abs(target - i) + str.length();
                gap = Math.min(gap, min);
            }
        }
        bufferedWriter.write(Integer.toString(gap));
        bufferedWriter.flush();
    }
}


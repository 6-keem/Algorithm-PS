import java.io.*;

public class Main{
    static int target, n, length, num = 100;
    static int gap = 1;
    static boolean isPushed = false;
    static boolean [] flag = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String [] input = bufferedReader.readLine().split(" ");
        length = input[0].length();
        target = Integer.parseInt(input[0]);

        n = Integer.parseInt(bufferedReader.readLine());
        if(n != 0){
            gap = Math.abs(target - num);
            input = bufferedReader.readLine().split(" ");
            for(String str : input)
                flag[Integer.parseInt(str)] = true;

            if(gap == 0){
                bufferedWriter.write(Integer.toString(0));
                bufferedWriter.flush();
                return;
            }
            else {
                num = 100;
                for(int i = 0 ; i < 10 ; i ++){
                    if(!flag[i])
                        calc(i);
                }
            }
        }
        else{
            bufferedWriter.write(Integer.toString(Math.min(length, Math.abs(num - target))));
            bufferedWriter.flush();
            return;
        }

        if(!isPushed)
            bufferedWriter.write(Integer.toString(gap));
        else
            bufferedWriter.write(Integer.toString(Math.abs(target-num) + Integer.toString(num).length()));
        bufferedWriter.flush();
    }
    private static void calc(int prefix){
        if(prefix / Math.pow(10,length + 1) > 1)
            return;
        if(Math.abs(prefix - target) <= gap && prefix != 100){
            if(gap == Math.abs(prefix - target))
                num = Integer.toString(num).length() < Integer.toString(prefix).length() ? num : prefix;
            else
                num = prefix;
            gap = Math.abs(prefix - target);
            isPushed = true;
            if(Math.abs(target - 100) <= Integer.toString(num).length() + gap){
                num = 100;
                gap = Math.abs(100 - target);
                isPushed = false;
            }
        }
        for(int i = 0 ; i < 10 ; i ++){
            if(!flag[i] && prefix != 0){
                calc(prefix * 10 + i);
            }
        }
    }
}


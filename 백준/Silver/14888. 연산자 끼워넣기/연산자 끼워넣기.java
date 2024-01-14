import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main{
    private static int n;
    private static int [] nums = null;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static int [] ops = new int[4];
    private static LinkedList<String> op = new LinkedList<>();
    private static int [] visited = new int[4];
    private static HashMap<Integer,String> hashMap = new HashMap<>(){{
        put(0,"+");
        put(1,"-");
        put(2,"*");
        put(3,"/");
    }};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        nums = new int[n];

        for(int i = 0 ; i < n ; i++)
            nums[i] = scanner.nextInt();
        for(int i = 0 ; i < 4 ; i++)
            ops[i] = scanner.nextInt();
        backTracking(0);
        System.out.println(max + "\n" + min);
        scanner.close();
    }
    private static void backTracking(int count){
        if(count == n-1){
            int total = nums[0];
            for(int i = 0 ; i < op.size() ; i ++)
                total = calc(op.get(i),total,nums[i+1]);
            max = Math.max(total, max);
            min = Math.min(total, min);
        }
        else {
            for(int i = 0 ; i < 4 ; i++){
                if(ops[i] != visited[i] && ops[i] != 0){
                    visited[i]++;
                    op.add(hashMap.get(i));
                    backTracking(count + 1);
                    visited[i]--;
                    op.removeLast();
                }
            }
        }
    }
    private static int calc(String op, int op1, int op2){
        switch (op){
            case "+":
                return op1 + op2;
            case "-":
                return op1 - op2;
            case "*":
                return op1 * op2;
            case "/":
                if(op2 > 0)
                    return op1 / op2;
                int temp = Math.abs(op2);
                return -(op1 / op2);
            default:
                return -1;
        }
    }
}
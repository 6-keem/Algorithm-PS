import java.io.*;
import java.util.Collections;
import java.util.Vector;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        Vector<Point> vt = new Vector<>();
        int N = Integer.parseInt(bufferedReader.readLine());
        for(int i = 0 ; i < N ; i ++){
            String []input = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            vt.add(new Point(x,y));
        }

        Collections.sort(vt);
        for(Point point : vt){
            bufferedWriter.write(Integer.toString(point.x) + " " + Integer.toString(point.y));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }
    static class Point implements Comparable{
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object object) {
            Point point = (Point) object;
            if(this.y < point.y)
                return -1;
            else if(this.y > point.y)
                return 1;
            else
                return compareToX(point);
        }
        public int compareToX(Point point){
            if(this.x < point.x)
                return -1;
            else if(this.x > point.x)
                return 1;
            else
                return 0;
        }
    }
}
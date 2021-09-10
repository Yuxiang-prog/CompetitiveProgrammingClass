import java.awt.Rectangle;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class WhiteSheets {
    public static void main(String[] args) throws Exception {
        Kattio in = new Kattio();
        PrintWriter out = new PrintWriter(System.out);
        int x1, y1, x2, y2;
        x1 = in.nextInt();
        y1 = in.nextInt();
        x2 = in.nextInt();
        y2 = in.nextInt();
        Rectangle a = new Rectangle(x1, -y2, x2 - x1, y2 - y1);
        x1 = in.nextInt();
        y1 = in.nextInt();
        x2 = in.nextInt();
        y2 = in.nextInt();
        Rectangle b = new Rectangle(x1, -y2, x2 - x1, y2 - y1);
        x1 = in.nextInt();
        y1 = in.nextInt();
        x2 = in.nextInt();
        y2 = in.nextInt();
        Rectangle c = new Rectangle(x1, -y2, x2 - x1, y2 - y1);

        long firstIntersect = getArea(b.intersection(a));
        long secondIntersect = getArea(c.intersection(a));
        Rectangle i1 = a.intersection(c);
        Rectangle i2 = a.intersection(b);
        Rectangle i3 = i1.intersection(i2);


        long area = getArea(a) - (firstIntersect + secondIntersect - getArea(i3));
        if(area > 0) out.println("YES");
        else out.println("NO");
        out.close();
    }

    static long getArea(Rectangle r) {
        return r.isEmpty() ? 0 : (long) r.getHeight() * (long) r.getWidth();
    }
    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // standard input
        public Kattio() {
            this(System.in, System.out);
        }

        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        // USACO-style file input
        public Kattio(String problemName) throws IOException {
            super(new FileWriter(problemName + ".out"));
            r = new BufferedReader(new FileReader(problemName + ".in"));
        }

        // returns null if no more input
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String readLine() throws Exception {
            return r.readLine();
        }

        public long[] readArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++)
                arr[i] = nextLong();
            return arr;
        }
    }
}
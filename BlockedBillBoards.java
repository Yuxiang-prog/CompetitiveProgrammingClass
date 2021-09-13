import java.awt.Rectangle;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class BlockedBillBoards {
	public static void main(String[]args) throws Exception {
		Scanner in = new Scanner(new FileReader("billboard.in"));
		PrintWriter out = new PrintWriter("billboard.out");
		
		int x1 = in.nextInt(); int y1 = in.nextInt(); int x2 = in.nextInt(); int y2 = in.nextInt();
		Rectangle billboard1 = new Rectangle(x1, -y2, x2 - x1, y2 - y1);
		
		
		x1 = in.nextInt(); y1 = in.nextInt(); x2 = in.nextInt(); y2 = in.nextInt();
		Rectangle billboard2 = new Rectangle(x1, -y2, x2 - x1, y2 - y1);
		
		x1 = in.nextInt(); y1 = in.nextInt(); x2 = in.nextInt(); y2 = in.nextInt();
		Rectangle truck = new Rectangle(x1, -y2, x2 - x1, y2 - y1);
		
		
		long firstI = getArea(billboard1.intersection(truck));
		long secondI = getArea(billboard2.intersection(truck));
		out.println(getArea(billboard1) + getArea(billboard2) - (firstI + secondI));
		out.close();
		
	}
	
	public static long getArea(Rectangle r) {
		return r.isEmpty() ? 0 : (long) r.getHeight() * (long) r.getWidth();
	}
}

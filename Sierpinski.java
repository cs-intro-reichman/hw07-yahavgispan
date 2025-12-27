/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {

	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}

	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski(int n) {
		StdDraw.setCanvasSize(800, 700);
		StdDraw.setXscale(0, 1);
		StdDraw.setYscale(0, Math.sqrt(3) / 2);
		double x1 = 0.0;
		double y1 = 0.0;
		double x2 = 0.0;
		double y2 = 1.0;
		double x3 = 0.5;
		double y3 = Math.sqrt(3) / 2;
		sierpinski(n, x1, x2, x3, y1, y2, y3);

	}

	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
			double y1, double y2, double y3) {
		if (n == 0) {
			StdDraw.line(x1, y1, x2, y2);
			StdDraw.line(x2, y2, x3, y3);
			StdDraw.line(x1, y1, x3, y3);
			return;
		}

		double middleX12 = (x1 + x2) / 2;
		double middleX23 = (x2 + x3) / 2;
		double middleX13 = (x1 + x3) / 2;
		double middleY12 = (y1 + y2) / 2;
		double middleY23 = (y3 + y2) / 2;
		double middleY13 = (y1 + y3) / 2;

		sierpinski(n - 1, x1, middleX12, middleX13, y1, middleY12, middleY13);
		sierpinski(n - 1, middleX12, x2, middleX23, middleY12, y2, middleY23);
		sierpinski(n - 1, middleX13, middleX23, x3, middleY13, middleY23, y3);

	}
}

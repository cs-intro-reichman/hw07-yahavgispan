/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		/// Uncomment the first code block to test the curve function. Uncomment the
		/// second code block to test the snowflake function. Uncomment only one block in
		/// each test, and remember to compile the class whenever you change the test.

		// Tests the curve function:
		// Gets n, x1, y1, x2, y2,
		// and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
		// curve(Integer.parseInt(args[0]),
		// Double.parseDouble(args[1]), Double.parseDouble(args[2]),
		// Double.parseDouble(args[3]), Double.parseDouble(args[4]));

		// Tests the snowflake function:
		// Gets n, and draws a Koch snowflake of n edges in the standard canvass.
		snowFlake(Integer.parseInt(args[0]));

	}

	/**
	 * Gets n, x1, y1, x2, y2,
	 * and draws a Koch curve of depth n from (x1,y1) to (x2,y2).
	 */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		if (n == 0)
			StdDraw.line(x1, y1, x2, y2);
		else {
			double oneThirdX = x1 + (1.0 / 3) * (x2 - x1);
			double twoThirdsX = x1 + (2.0 / 3) * (x2 - x1);
			double oneThirdY = y1 + (1.0 / 3) * (y2 - y1);
			double twoThirdsY = y1 + (2.0 / 3) * (y2 - y1);
			double cornerX = (Math.sqrt(3) / 6) * (oneThirdY - twoThirdsY) + 0.5 * (oneThirdX + twoThirdsX);
			double cornerY = (Math.sqrt(3) / 6) * (twoThirdsX - oneThirdX) + 0.5 * (oneThirdY + twoThirdsY);
			curve(n - 1, x1, y1, oneThirdX, oneThirdY);
			curve(n - 1, oneThirdX, oneThirdY, cornerX, cornerY);
			curve(n - 1, cornerX, cornerY, twoThirdsX, twoThirdsY);
			curve(n - 1, twoThirdsX, twoThirdsY, x2, y2);

		}
	}

	/** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);
		curve(n, 0.1, 0.15, 1.0, 0.15);
		curve(n, 1.0, 0.15, 0.55, 0.93);
		curve(n, 0.55, 0.93, 0.1, 0.15);
	}
}

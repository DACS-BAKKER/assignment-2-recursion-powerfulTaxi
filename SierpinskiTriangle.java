/* *****************************************************************************
 *  Name:    Eli Ji
 *  Date: 9-19-19
 **************************************************************************** */

public class SierpinskiTriangle {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(400, 350);
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        System.out.println("This program draws the Sierpinski Triangle.");
        System.out.println("Order?");
        int order = StdIn.readInt();
        drawSierpinskiTriangle(0.1, 0.1, 0.8, order);
    }

    private static void drawSierpinskiTriangle( double x, double y, double sideLength, int order) {
       if (order == 0) {
            StdDraw.line(x, y, x + sideLength, y);
            StdDraw.line(x, y,x + sideLength / 2, y + (sideLength * Math.sqrt(3)/2));
            StdDraw.line(x + sideLength, y,x + sideLength / 2, y + (sideLength * Math.sqrt(3)/2));
       } else {
           drawSierpinskiTriangle(x, y, sideLength / 2, order - 1);
           StdDraw.pause(200);
           drawSierpinskiTriangle(x + sideLength / 2, y, sideLength / 2, order - 1);
           StdDraw.pause(200);
           drawSierpinskiTriangle(x + sideLength / 4, y + (sideLength * Math.sqrt(3)/4), sideLength / 2, order - 1);
           StdDraw.pause(200);
       }
    }
}

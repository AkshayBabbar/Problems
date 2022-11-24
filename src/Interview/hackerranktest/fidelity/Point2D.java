package src.Interview.hackerranktest.fidelity;

public class Point2D {
    int x;
    int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double dist2D(Point2D point2D) {
        return Math.sqrt(Math.pow(point2D.x - x, 2) + Math.pow(point2D.y - y, 2));

    }

    void printDistance(double distance) {
        System.out.println("2D distance = " + (int) Math.ceil(distance));
    }
}

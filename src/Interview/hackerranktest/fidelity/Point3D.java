package src.Interview.hackerranktest.fidelity;

public class Point3D extends Point2D {
    private int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    double dist3D(Point3D point3D) {
        return Math.sqrt(Math.pow(point3D.x - x, 2) + Math.pow(point3D.y - y, 2) + Math.pow(point3D.z - z, 2));
    }

    void printDistance(double distance) {
        System.out.println("3D distance = " + (int) Math.ceil(distance));
    }
}

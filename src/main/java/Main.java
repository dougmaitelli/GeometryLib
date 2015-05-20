
import Geography.LatLng;
import Geometry.Line;
import Geometry.Point;
import Geometry.Triangle;
import Geometry.Polygon;
import Geometry.Matrix;


/**
 *
 * @author DougM
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Double teste = LatLng.distanceBetweenPoints(new LatLng(-29.687166, -51.127223), new LatLng(-29.68773, -51.127062));

        Polygon poly = new Polygon();

        poly.add(new Point(0, 0));
        poly.add(new Point(1, 2));
        poly.add(new Point(3, 8));
        poly.add(new Point(2, 10));

        poly.getArea();

        double tt1 = Point.distanceBetweenPoints(new Point(3, 8), new Point(2, 10));
        double tt2 = Point.distanceBetweenPoints(new Point(2, 10), new Point(0, 0));
        double tt3 = Point.distanceBetweenPoints(new Point(0, 0), new Point(1, 2));
        
        double tt4 = poly.distanceBetweenPoints(new Point(3, 8), new Point(1, 2));
        Point tt5 = poly.getClosestPoint(new Point(3, 11));

        Triangle t = new Triangle(new Point(0, 0), new Point(1, 2), new Point(3, 8));

        t.getArea();

        Double teste1 = poly.distanceFromPoint(new Point(21, 12));

        Matrix matrix = new Matrix(new Integer[][]{
                    {2, 2, 1},
                    {-3, 5, 14}
                });

        matrix.getDeterminant();
    }
}

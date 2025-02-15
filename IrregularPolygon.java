import java.awt.geom.*; // for Point2D.Double
import java.util.ArrayList; // for ArrayList


public class IrregularPolygon {
    private ArrayList<Point2D.Double> myPolygon = new ArrayList<Point2D.Double>();

    // constructor
    public IrregularPolygon() {}

    // public methods
    public void add(Point2D.Double aPoint)
    {
        myPolygon.add(aPoint);
    }

    public double perimeter() {
        double perimeter = 0.0;
        for(int i = 0; i < myPolygon.size() - 1; i++){
            Point2D.Double point = myPolygon.get(i);
            Point2D.Double points = myPolygon.get(i + 1);
            perimeter += point.distance(points);
        }
        perimeter += myPolygon.get(myPolygon.size() - 1).distance(myPolygon.get(0));
        return perimeter;
    }

    public double area() {
        double first = 0.0;
        double second = 0.0;
        for(int i = 0; i < myPolygon.size() - 1; i++){
            Point2D.Double point = myPolygon.get(i);
            Point2D.Double points = myPolygon.get(i+1);
            first += point.x * points.y;
            second += point.y * points.x;
        }
        double area  = 0.0;
        first += myPolygon.get(myPolygon.size() - 1).x * myPolygon.get(0).y;
        second += myPolygon.get(myPolygon.size() - 1).y * myPolygon.get(0).x;
        area = 0.5 * (first - second);
        area = Math.abs(area);
        return area;
    }

    // public void draw()
    // {
    //     // Wrap the DrawingTool in a try/catch to allow development without need for graphics.
    //     try {
    //         // TODO: Draw the polygon.
    //         // Documents: https://pavao.org/compsci/gpdraw/html/gpdraw/DrawingTool.html
    //         DrawingTool pen = new DrawingTool(new SketchPad(500, 500));
    //         pen.move(50, 50);
    //     } catch (java.awt.HeadlessException e) {
    //         System.out.println("Exception: No graphics support available.");
    //     }
    // }
}

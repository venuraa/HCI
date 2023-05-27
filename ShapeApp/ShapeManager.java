import java.util.ArrayList;
import java.util.List;

public class ShapeManager {
    private List<Shape> shapes;

    public ShapeManager() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(Shape shape) {
        shapes.remove(shape);
    }

    public List<Shape> getAllShapes() {
        return new ArrayList<>(shapes);
    }

    public int getTotalShapes() {
        return shapes.size();
    }

    public Shape getShapeAtIndex(int index) {
        if (index >= 0 && index < shapes.size()) {
            return shapes.get(index);
        }
        throw new IndexOutOfBoundsException("Invalid index: " + index);
    }
}

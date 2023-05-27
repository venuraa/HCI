import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeFileHandler {
    private static final String FILE_PATH = "shapes.txt";

    public static void saveShapes(List<Shape> shapes) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Shape shape : shapes) {
                writer.println(shape.getClass().getSimpleName());
                writer.println(shape.toString());
            }
        } catch (IOException e) {
            System.out.println("Error saving shapes to file: " + e.getMessage());
        }
    }

    public static List<Shape> loadShapes() {
        List<Shape> shapes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String shapeType = line;
                String shapeDetails = reader.readLine();

                Shape shape = createShape(shapeType, shapeDetails);
                if (shape != null) {
                    shapes.add(shape);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading shapes from file: " + e.getMessage());
        }

        return shapes;
    }

    private static Shape createShape(String shapeType, String shapeDetails) {
        Shape shape = null;

        switch (shapeType) {
            case "Circle":
                shape = createCircle(shapeDetails);
                break;
            case "Square":
                shape = createSquare(shapeDetails);
                break;
            case "Triangle":
                shape = createTriangle(shapeDetails);
                break;
            // Add cases for other shape types as needed
        }

        return shape;
    }

    private static Circle createCircle(String shapeDetails) {
        String[] parts = shapeDetails.split(",");
        if (parts.length == 1) {
            double radius = Double.parseDouble(parts[0].trim());
            return new Circle(radius);
        }
        return null;
    }

    private static Square createSquare(String shapeDetails) {
        String[] parts = shapeDetails.split(",");
        if (parts.length == 1) {
            double sideLength = Double.parseDouble(parts[0].trim());
            return new Square(sideLength);
        }
        return null;
    }

    private static Triangle createTriangle(String shapeDetails) {
        String[] parts = shapeDetails.split(",");
        if (parts.length == 1) {
            double base = Double.parseDouble(parts[0].trim());
            return new Triangle(base);
        }
        return null;
    }
}

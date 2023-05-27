public class ShapeFactory {
    public static Shape createShape(String shapeType, double... dimensions) {
        if (shapeType.equalsIgnoreCase("Circle")) {
            if (dimensions.length != 1) {
                throw new IllegalArgumentException("Invalid dimensions for Circle. Expected: radius");
            }
            double radius = dimensions[0];
            return new Circle(radius);
        } else if (shapeType.equalsIgnoreCase("Square")) {
            if (dimensions.length != 1) {
                throw new IllegalArgumentException("Invalid dimensions for Square. Expected: side length");
            }
            double sideLength = dimensions[0];
            return new Square(sideLength);
        } else if (shapeType.equalsIgnoreCase("Triangle")) {
            if (dimensions.length != 2) {
                throw new IllegalArgumentException("Invalid dimensions for Triangle. Expected: base and height");
            }
            double base = dimensions[0];
            double height = dimensions[1];
            return new Triangle(base, height);
        } else {
            throw new IllegalArgumentException("Invalid shape type: " + shapeType);
        }
    }
}

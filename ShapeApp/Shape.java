public interface Shape {
    double getArea();

    double getPerimeter();
}

class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Circle: Radius = " + radius + ", Area = " + getArea() + ", Perimeter = " + getPerimeter();
    }
}

class Square implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }

    @Override
    public String toString() {
        return "Square: Side Length = " + sideLength + ", Area = " + getArea() + ", Perimeter = " + getPerimeter();
    }
}

class Triangle implements Shape {
    private double base;

    public Triangle(double base, double height) {
        this.base = base;
    }

    @Override
    public double getArea() {
        return (Math.sqrt(3) / 4) * base * base;
    }

    @Override
    public double getPerimeter() {
        return 3 * base;
    }

    @Override
    public String toString() {
        return "Triangle: Base = " + base + ", Area = " + getArea() + ", Perimeter = " + getPerimeter();
    }
}

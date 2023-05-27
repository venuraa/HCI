public class Triangle implements Shape {
    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    @Override
    public double getPerimeter() {
        // Assuming it's an equilateral triangle
        return 3 * base;
    }

    @Override
    public String toString() {
        return "Triangle: Base = " + base + ", Height = " + height + ", Area = " + getArea() + ", Perimeter = " + getPerimeter();
    }
}

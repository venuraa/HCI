import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShapeApp extends JFrame {
    private JComboBox<String> shapeComboBox;
    private JButton createButton;
    private JTextField dimensionsTextField;
    private JButton visualize2DButton;
    private JButton visualize3DButton;
    private ShapePanel shapePanel; // Added shapePanel

    public ShapeApp() {
        setTitle("Shape Learning App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        shapeComboBox = new JComboBox<>(new String[]{"Circle", "Square", "Triangle", "Sphere", "Cube", "Pyramid"});
        controlPanel.add(new JLabel("Select Shape: "));
        controlPanel.add(shapeComboBox);

        dimensionsTextField = new JTextField(10);
        controlPanel.add(new JLabel("Dimensions: "));
        controlPanel.add(dimensionsTextField);

        createButton = new JButton("Create");
        controlPanel.add(createButton);

        visualize2DButton = new JButton("Visualize 2D");
        controlPanel.add(visualize2DButton);

        visualize3DButton = new JButton("Visualize 3D");
        controlPanel.add(visualize3DButton);

        shapePanel = new ShapePanel();
        add(controlPanel, BorderLayout.NORTH);
        add(shapePanel, BorderLayout.CENTER);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String shape = (String) shapeComboBox.getSelectedItem();
                String dimensions = dimensionsTextField.getText();

                Shape newShape = null;

                if (shape.equals("Circle")) {
                    double radius = Double.parseDouble(dimensions);
                    newShape = new Circle(radius);
                } else if (shape.equals("Square")) {
                    double sideLength = Double.parseDouble(dimensions);
                    newShape = new Square(sideLength);
                } else if (shape.equals("Triangle")) {
                    double base = Double.parseDouble(dimensions);
                    newShape = new Triangle(base);
                } else if (shape.equals("Sphere")) {
                    double radius = Double.parseDouble(dimensions);
                    newShape = new Sphere(radius);
                } else if (shape.equals("Cube")) {
                    double sideLength = Double.parseDouble(dimensions);
                    newShape = new Cube(sideLength);
                } else if (shape.equals("Pyramid")) {
                    double baseLength = Double.parseDouble(dimensions);
                    newShape = new Pyramid(baseLength);
                }

                if (newShape != null) {
                    shapePanel.setShape(newShape);
                    shapePanel.repaint();
                }
            }
        });

        visualize2DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapePanel.setRender3D(false);
                shapePanel.repaint();
            }
        });

        visualize3DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shapePanel.setRender3D(true);
                shapePanel.repaint();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShapeApp();
            }
        });
    }
}

interface Shape {
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

    public Triangle(double base) {
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

class Sphere implements Shape {
    private double radius;

    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        return "Sphere: Radius = " + radius + ", Surface Area = " + getArea() + ", Circumference = " + getPerimeter();
    }
}

class Cube implements Shape {
    private double sideLength;

    public Cube(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return 6 * sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 12 * sideLength;
    }

    @Override
    public String toString() {
        return "Cube: Side Length = " + sideLength + ", Surface Area = " + getArea() + ", Perimeter = " + getPerimeter();
    }
}

class Pyramid implements Shape {
    private double baseLength;

    public Pyramid(double baseLength) {
        this.baseLength = baseLength;
    }

    @Override
    public double getArea() {
        return Math.pow(baseLength, 2) + (2 * baseLength) * Math.sqrt(Math.pow(baseLength / 2, 2) + Math.pow(baseLength, 2));
    }

    @Override
    public double getPerimeter() {
        return 4 * baseLength;
    }

    @Override
    public String toString() {
        return "Pyramid: Base Length = " + baseLength + ", Surface Area = " + getArea() + ", Perimeter = " + getPerimeter();
    }
}

class ShapePanel extends JPanel {
    private Shape shape;
    private boolean render3D;

    public ShapePanel() {
        setPreferredSize(new Dimension(300, 300));
        render3D = false;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public void setRender3D(boolean render3D) {
        this.render3D = render3D;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (shape != null) {
            int width = getWidth();
            int height = getHeight();

            int shapeWidth = (int) Math.min(0.8 * width, 0.8 * height);
            int shapeHeight = shapeWidth;

            int x = (width - shapeWidth) / 2;
            int y = (height - shapeHeight) / 2;

            if (render3D) {
                g.setColor(Color.GRAY);
                g.fill3DRect(x, y, shapeWidth, shapeHeight, true);
            } else {
                if (shape instanceof Circle) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x, y, shapeWidth, shapeHeight);
                } else if (shape instanceof Square) {
                    g.setColor(Color.RED);
                    g.fillRect(x, y, shapeWidth, shapeHeight);
                } else if (shape instanceof Triangle) {
                    g.setColor(Color.GREEN);
                    int[] xPoints = {x, x + shapeWidth / 2, x + shapeWidth};
                    int[] yPoints = {y + shapeHeight, y, y + shapeHeight};
                    g.fillPolygon(xPoints, yPoints, 3);
                } else if (shape instanceof Sphere) {
                    g.setColor(Color.ORANGE);
                    g.fillOval(x, y, shapeWidth, shapeHeight);
                } else if (shape instanceof Cube) {
                    g.setColor(Color.YELLOW);
                    g.fillRect(x, y, shapeWidth, shapeHeight);
                } else if (shape instanceof Pyramid) {
                    g.setColor(Color.PINK);
                    int[] xPoints = {x, x + shapeWidth / 2, x + shapeWidth};
                    int[] yPoints = {y + shapeHeight, y + shapeHeight, y + shapeHeight};
                    g.fillPolygon(xPoints, yPoints, 3);
                    g.drawLine(x, y + shapeHeight, x + shapeWidth / 2, y);
                    g.drawLine(x + shapeWidth, y + shapeHeight, x + shapeWidth / 2, y);
                }
            }
        }
    }
}

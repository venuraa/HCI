import javax.swing.*;
import java.awt.*;

public class ShapePanel extends JPanel {
    private Shape shape;

    public ShapePanel() {
        setPreferredSize(new Dimension(300, 300));
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Shape getShape() {
        return shape;
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
            }
        }
    }
}

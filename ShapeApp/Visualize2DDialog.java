import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visualize2DDialog extends JDialog {
    private Shape shape;

    public Visualize2DDialog(Frame owner, Shape shape) {
        super(owner, "2D Visualization", true);

        this.shape = shape;

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("2D Visualization of Shape");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel shapePanel = new JPanel() {
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
        };

        mainPanel.add(shapePanel, BorderLayout.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        mainPanel.add(closeButton, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(owner);
    }
}

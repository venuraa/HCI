import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateShapeDialog extends JDialog {
    private JComboBox<String> shapeComboBox;
    private JTextField dimensionsTextField;
    private JButton createButton;
    private ShapeManager shapeManager;

    public CreateShapeDialog(Frame owner, ShapeManager shapeManager) {
        super(owner, "Create Shape", true);
        this.shapeManager = shapeManager;

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        shapeComboBox = new JComboBox<>(new String[]{"Circle", "Square", "Triangle"});
        inputPanel.add(new JLabel("Select Shape: "));
        inputPanel.add(shapeComboBox);
        dimensionsTextField = new JTextField();
        inputPanel.add(new JLabel("Dimensions: "));
        inputPanel.add(dimensionsTextField);

        JPanel buttonPanel = new JPanel();
        createButton = new JButton("Create");
        buttonPanel.add(createButton);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createShape();
            }
        });

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(owner);
    }

    private void createShape() {
        String shapeType = (String) shapeComboBox.getSelectedItem();
        String dimensions = dimensionsTextField.getText();

        Shape newShape = null;

        if (shapeType.equals("Circle")) {
            double radius = Double.parseDouble(dimensions);
            newShape = new Circle(radius);
        } else if (shapeType.equals("Square")) {
            double sideLength = Double.parseDouble(dimensions);
            newShape = new Square(sideLength);
        } else if (shapeType.equals("Triangle")) {
            double base = Double.parseDouble(dimensions);
            newShape = new Triangle(base);
        }

        if (newShape != null) {
            shapeManager.addShape(newShape);
            JOptionPane.showMessageDialog(this, "Shape created successfully!", "Shape Creation", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid shape dimensions!", "Shape Creation", JOptionPane.ERROR_MESSAGE);
        }
    }
}

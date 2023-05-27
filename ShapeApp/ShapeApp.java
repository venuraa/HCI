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
    private JButton scaleButton;
    private JButton shadeButton;
    private JButton colorButton;
    private JButton saveButton;
    private JButton editDeleteButton;
    private ShapePanel shapePanel;
    private ShapeManager shapeManager;

    public ShapeApp() {
        setTitle("Shape Learning App");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        shapeComboBox = new JComboBox<>(new String[]{"Circle", "Square", "Triangle"});
        controlPanel.add(new JLabel("Select Shape: "));
        controlPanel.add(shapeComboBox);

        dimensionsTextField = new JTextField(10);
        controlPanel.add(new JLabel("Dimensions: "));
        controlPanel.add(dimensionsTextField);

        createButton = new JButton(AppConstants.BUTTON_LABEL_CREATE);
        controlPanel.add(createButton);

        visualize2DButton = new JButton(AppConstants.BUTTON_LABEL_VISUALIZE_2D);
        controlPanel.add(visualize2DButton);

        visualize3DButton = new JButton(AppConstants.BUTTON_LABEL_VISUALIZE_3D);
        controlPanel.add(visualize3DButton);

        scaleButton = new JButton(AppConstants.BUTTON_LABEL_SCALE);
        controlPanel.add(scaleButton);

        shadeButton = new JButton(AppConstants.BUTTON_LABEL_SHADE);
        controlPanel.add(shadeButton);

        colorButton = new JButton(AppConstants.BUTTON_LABEL_CHANGE_COLOR);
        controlPanel.add(colorButton);

        saveButton = new JButton(AppConstants.BUTTON_LABEL_SAVE);
        controlPanel.add(saveButton);

        editDeleteButton = new JButton(AppConstants.BUTTON_LABEL_EDIT_DELETE);
        controlPanel.add(editDeleteButton);

        shapePanel = new ShapePanel();
        add(controlPanel, BorderLayout.NORTH);
        add(shapePanel, BorderLayout.CENTER);

        shapeManager = new ShapeManager();

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreateShapeDialog createShapeDialog = new CreateShapeDialog(ShapeApp.this, shapeManager);
                createShapeDialog.setVisible(true);
            }
        });

        visualize2DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (shapePanel.getShape() != null) {
                    Visualize2DDialog visualize2DDialog = new Visualize2DDialog(ShapeApp.this, shapePanel.getShape());
                    visualize2DDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(ShapeApp.this, "No shape is created.");
                }
            }
        });

        visualize3DButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (shapePanel.getShape() != null) {
                    Visualize3DDialog visualize3DDialog = new Visualize3DDialog(ShapeApp.this, shapePanel.getShape());
                    visualize3DDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(ShapeApp.this, "No shape is created.");
                }
            }
        });

        scaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (shapePanel.getShape() != null) {
                    ScaleShapeDialog scaleShapeDialog = new ScaleShapeDialog(ShapeApp.this, shapePanel.getShape());
                    scaleShapeDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(ShapeApp.this, "No shape is created.");
                }
            }
        });

        shadeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (shapePanel.getShape() != null) {
                    ShadeShapeDialog shadeShapeDialog = new ShadeShapeDialog(ShapeApp.this, shapePanel.getShape());
                    shadeShapeDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(ShapeApp.this, "No shape is created.");
                }
            }
        });

        colorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (shapePanel.getShape() != null) {
                    ChangeColorDialog changeColorDialog = new ChangeColorDialog(ShapeApp.this, shapePanel.getShape());
                    changeColorDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(ShapeApp.this, "No shape is created.");
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (shapePanel.getShape() != null) {
                    SaveShapeDialog saveShapeDialog = new SaveShapeDialog(ShapeApp.this, shapePanel.getShape());
                    saveShapeDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(ShapeApp.this, "No shape is created.");
                }
            }
        });

        editDeleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (shapePanel.getShape() != null) {
                    EditDeleteShapeDialog editDeleteShapeDialog = new EditDeleteShapeDialog(ShapeApp.this, shapePanel.getShape());
                    editDeleteShapeDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(ShapeApp.this, "No shape is created.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ShapeApp shapeApp = new ShapeApp();
                shapeApp.setVisible(true);
            }
        });
    }
}

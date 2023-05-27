import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShadeShapeDialog extends JDialog {
    private Shape shape;

    public ShadeShapeDialog(Frame owner, Shape shape) {
        super(owner, "Add Shade", true);

        this.shape = shape;

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Add Shade");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel infoLabel = new JLabel("Select the shade color:");
        JComboBox<String> colorComboBox = new JComboBox<>(new String[]{"Red", "Green", "Blue"});

        contentPanel.add(infoLabel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(colorComboBox);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        JButton addShadeButton = new JButton("Add Shade");
        addShadeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor = (String) colorComboBox.getSelectedItem();

                // TODO: Implement add shade logic for the shape based on the selected color

                dispose();
            }
        });

        mainPanel.add(addShadeButton, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(owner);
    }
}

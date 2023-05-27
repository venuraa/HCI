import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DimensionsDialog extends JDialog {
    private JTextField dimensionsTextField;
    private JButton confirmButton;
    private double dimensions;

    public DimensionsDialog(Frame owner, String shapeType) {
        super(owner, "Enter Dimensions", true);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Enter Dimensions for " + shapeType);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        dimensionsTextField = new JTextField(10);
        inputPanel.add(dimensionsTextField);

        JPanel buttonPanel = new JPanel();
        confirmButton = new JButton("Confirm");
        buttonPanel.add(confirmButton);

        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateDimensions()) {
                    dimensions = Double.parseDouble(dimensionsTextField.getText());
                    dispose();
                }
            }
        });

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(owner);
    }

    private boolean validateDimensions() {
        String dimensionsText = dimensionsTextField.getText();

        if (dimensionsText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the dimensions.", "Invalid Dimensions", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        try {
            double value = Double.parseDouble(dimensionsText);
            if (value <= 0) {
                JOptionPane.showMessageDialog(this, "Dimensions must be a positive value.", "Invalid Dimensions", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid dimensions format. Please enter a numeric value.", "Invalid Dimensions", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    public double getDimensions() {
        return dimensions;
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveShapeDialog extends JDialog {
    private Shape shape;

    public SaveShapeDialog(Frame owner, Shape shape) {
        super(owner, "Save Shape", true);

        this.shape = shape;

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Save Shape");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel infoLabel = new JLabel("Enter a file name to save the shape:");
        JTextField fileNameTextField = new JTextField(20);

        contentPanel.add(infoLabel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(fileNameTextField);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameTextField.getText();

                // TODO: Implement save shape logic using the provided file name

                dispose();
            }
        });

        mainPanel.add(saveButton, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(owner);
    }
}

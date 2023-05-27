import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScaleShapeDialog extends JDialog {
    private Shape shape;

    public ScaleShapeDialog(Frame owner, Shape shape) {
        super(owner, "Scale Shape", true);

        this.shape = shape;

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Scale Shape");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel infoLabel = new JLabel("Enter the scale factor:");
        JTextField scaleTextField = new JTextField(10);

        contentPanel.add(infoLabel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(scaleTextField);

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        JButton scaleButton = new JButton("Scale");
        scaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String scaleText = scaleTextField.getText();
                double scale = Double.parseDouble(scaleText);

                // TODO: Implement scale logic for the shape

                dispose();
            }
        });

        mainPanel.add(scaleButton, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(owner);
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditDeleteShapeDialog extends JDialog {
    private Shape shape;

    public EditDeleteShapeDialog(Frame owner, Shape shape) {
        super(owner, "Edit/Delete Shape", true);

        this.shape = shape;

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel titleLabel = new JLabel("Edit/Delete Shape");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel infoLabel = new JLabel("Shape details:");
        JTextArea shapeDetailsTextArea = new JTextArea(5, 20);
        shapeDetailsTextArea.setEditable(false);
        shapeDetailsTextArea.setText(shape.toString());

        contentPanel.add(infoLabel);
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(new JScrollPane(shapeDetailsTextArea));

        mainPanel.add(contentPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement edit shape logic

                dispose();
            }
        });
        buttonPanel.add(editButton);

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement delete shape logic

                dispose();
            }
        });
        buttonPanel.add(deleteButton);

        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(owner);
    }
}

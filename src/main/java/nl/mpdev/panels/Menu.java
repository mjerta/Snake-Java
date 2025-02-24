package nl.mpdev.panels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.TextField;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JPanel {
  private JPanel inputPanel;
  private JTextField nameField;
  private JButton submitButton;

  public Menu() {
    this.inputPanel = new JPanel();
    this.inputPanel.setBackground(Color.RED);
    this.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
    this.nameField = new JTextField(13);
    this.submitButton = new JButton("Submit");
    formatInputs(nameField, new Insets(10, 20, 10, 20));
    formatInputs(submitButton, new Insets(20, 20, 10, 20);
  }

  private <T extends JComponent> void formatInputs(T component, Insets margins) {
    component.setFont(new Font("Arial", Font.PLAIN, 30));
    if(component instanceof JButton) {
      ((JButton) component).setMargin(margins);
    } else if (component instanceof JTextField) {
      ((JTextField) component).setMargin(margins);
    }
    nameField.setMaximumSize(nameField.getPreferredSize());
    nameField.setAlignmentX(Component.CENTER_ALIGNMENT);
  }

}

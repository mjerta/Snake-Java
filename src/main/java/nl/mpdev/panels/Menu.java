package nl.mpdev.panels;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Menu extends JPanel {
  private JPanel inputPanel;
  private JTextField nameField;
  private JButton submitButton;

  public Menu() {
    this.inputPanel = new JPanel();
    this.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
    this.nameField = new JTextField(13);
    this.submitButton = new JButton("Submit");
  }

}

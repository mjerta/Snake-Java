package nl.mpdev.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import nl.mpdev.GameManager;
import nl.mpdev.Player;

public class Menu extends JPanel implements ActionListener, KeyListener {
  private JPanel inputPanel;
  private JLabel nameLabel;
  private JTextField nameField;
  private JButton submitButton;

  public Menu() {
    this.setLayout(new BorderLayout());
    this.inputPanel = new Background();
    this.inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
    this.nameLabel = new JLabel("Enter your name");
    this.nameField = new JTextField(13);
    this.submitButton = new JButton("Submit");
    formatInputs(nameLabel, 1, Color.WHITE, 20, 20, 10, 20);
    formatInputs(nameField, 0, Color.BLACK, 20, 20, 10, 20);
    formatInputs(submitButton, 1, Color.BLACK, 20, 20, 10, 20);
    formatPanel();
    submitButton.addActionListener(this);
    submitButton.addKeyListener(this);
    nameField.addKeyListener(this);
  }

  private <T extends JComponent> void formatInputs(T component, int fontStyle, Color color, int... margins) {
    component.setFont(new Font("Arial", fontStyle, 30));
    component.setForeground(color);
    component.setAlignmentX(Component.CENTER_ALIGNMENT);
    if (margins.length == 4) {
      Insets insets = new Insets(margins[0], margins[1], margins[2], margins[3]);
      switch (component) {
        case JButton jButton -> jButton.setMargin(insets);
        case JTextField jTextField -> {
          jTextField.setMargin(insets);
          jTextField.setHorizontalAlignment(JTextField.CENTER);
        }
        case JLabel jLabel -> jLabel.setBorder(new EmptyBorder(margins[0], margins[1], margins[2], margins[3]));
        default -> {
        }
      }
    }
    component.setMaximumSize(component.getPreferredSize());
  }

  private void formatPanel() {
    inputPanel.add(Box.createVerticalGlue());
    inputPanel.add(nameLabel);
    inputPanel.add(Box.createVerticalStrut(100));
    inputPanel.add(nameField);
    inputPanel.add(Box.createVerticalStrut(10));
    inputPanel.add(submitButton);
    inputPanel.add(Box.createVerticalGlue());
    this.add(inputPanel);
  }

  protected void activateMenu() {
    this.setVisible(true);
    this.nameField.requestFocusInWindow();
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submitButton) {
      String inputText = nameField.getText();
      System.out.println(inputText);
      Player.getInstance().setName(inputText);
      Grid grid = GameManager.getInstance().getGrid();
      grid.setKeysEnabled(true);
      this.setVisible(false);
      grid.setRunning(true);
      grid.getTimer().start();
      this.nameField.requestFocusInWindow();
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if (e.getKeyCode() == 10) {
      submitButton.doClick();
    }
    if (e.getKeyCode() == 27) {
      System.exit(0);
    }
    if (e.getKeyCode() == 85) {
      nameField.requestFocusInWindow();
    }
    System.out.println(e.getKeyCode());
  }

  public JTextField getNameField() {
    return this.getNameField();
  }
}

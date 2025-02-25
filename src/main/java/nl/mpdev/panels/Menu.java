package nl.mpdev.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import nl.mpdev.Player;

public class Menu extends JPanel implements ActionListener, KeyListener {
  private JPanel inputPanel;
  private JTextField nameField;
  private JButton submitButton;

  public Menu() {
    this.setLayout(new BorderLayout());
    this.inputPanel = new Background();
    this.inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
    //this.inputPanel.setBackground(Color.RED);
    this.nameField = new JTextField(13);
    this.submitButton = new JButton("Submit");
    formatInputs(nameField, new Insets(20, 20, 10, 20));
    formatInputs(submitButton, new Insets(20, 20, 10, 20));
    formatPanel();
    submitButton.addActionListener(this);
    submitButton.addKeyListener(this);
    nameField.addKeyListener(this);
  }

  private <T extends JComponent> void formatInputs(T component, Insets margins) {
    component.setFont(new Font("Arial", Font.PLAIN, 30));
    if (component instanceof JButton) {
      ((JButton) component).setMargin(margins);
    }
    else if (component instanceof JTextField) {
      ((JTextField) component).setMargin(margins);
    }
    component.setMaximumSize(nameField.getPreferredSize());
    component.setAlignmentX(Component.CENTER_ALIGNMENT);
  }

  private void formatPanel() {
    inputPanel.add(Box.createVerticalGlue());
    inputPanel.add(nameField);
    inputPanel.add(Box.createVerticalStrut(10));
    inputPanel.add(submitButton);
    inputPanel.add(Box.createVerticalGlue());
    this.add(inputPanel);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == submitButton) {
      String inputText = nameField.getText();
      System.out.println(inputText);
      Player.getInstance().setName(inputText);
      this.setVisible(false);
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
  }
}

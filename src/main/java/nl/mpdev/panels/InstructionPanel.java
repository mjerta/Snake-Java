package nl.mpdev.panels;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import nl.mpdev.GameManager;
import nl.mpdev.enums.Instruction;
import nl.mpdev.interfaces.OverlayHandler;

public class InstructionPanel extends JPanel implements OverlayHandler, KeyListener {

  public InstructionPanel() {
    this.setBorder(new EmptyBorder(10, 250, 10, 250));
    this.setBackground(Color.BLACK);
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    this.setVisible(false);
    this.addKeyListener(this);
    formatInstructionLines();
  }

  private void formatInstructionLines() {
    this.add(Box.createVerticalGlue());

    Arrays.stream(Instruction.values()).forEach(instruction -> {
      JPanel linePanel = new JPanel(new BorderLayout());
      linePanel.setBackground(Color.BLACK);

      JLabel leftAlignedLabel = new JLabel(instruction.getKey() + " ");
      leftAlignedLabel.setFont(new Font("Arial", Font.BOLD, 14));
      leftAlignedLabel.setForeground(Color.WHITE);

      JLabel rightAlignedLabel = new JLabel(instruction.getDescription());
      rightAlignedLabel.setFont(new Font("Arial", Font.BOLD, 14));
      rightAlignedLabel.setForeground(Color.WHITE);

      linePanel.add(leftAlignedLabel, BorderLayout.WEST);
      linePanel.add(rightAlignedLabel, BorderLayout.EAST);

      // Ensure the panel does not stretch too much
      linePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, leftAlignedLabel.getPreferredSize().height));

      this.add(linePanel);
      this.add(Box.createVerticalStrut(15));
    });

    this.add(Box.createVerticalGlue());
  }

  @Override
  public void activatePanel() {
    this.setVisible(true);
    this.requestFocusInWindow();
  }

  @Override
  public void keyTyped(KeyEvent e) {
    if (e.getKeyChar() == 'i') {
      Grid grid = GameManager.getInstance().getGrid();
      this.setVisible(false);
      grid.setKeysEnabled(true);
      grid.setRunning(true);
      grid.getTimer().start();
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {
  }

  @Override
  public void keyReleased(KeyEvent e) {
    if(e.getKeyCode() == 27){
      System.exit(0);
    }
  }
}


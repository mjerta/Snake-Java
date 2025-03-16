package nl.mpdev.panels;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;
import javax.swing.*;

import nl.mpdev.GameManager;

public class InstructionPanel extends JPanel implements OverlayHandler, KeyListener {
  private Map<String, String> instructionLines;

  public InstructionPanel(Map<String, String> instructionLines) {
    this.instructionLines = instructionLines;
    this.setBackground(Color.BLACK);
    this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Use this panel for layout
    this.setVisible(false);
    this.addKeyListener(this);
    formatInstructionLines();
  }

  private void formatInstructionLines() {
    this.add(Box.createVerticalGlue()); // Pushes content towards the center

    instructionLines.forEach((firstPart, secondPart) -> {
      // Create a row panel
      JPanel linePanel = new JPanel(new BorderLayout());
      linePanel.setBackground(Color.BLACK);

      // Left-aligned label
      JLabel firstPartLabel = new JLabel(firstPart + ": ");
      firstPartLabel.setFont(new Font("Arial", Font.BOLD, 14));
      firstPartLabel.setForeground(Color.WHITE);

      // Right-aligned label
      JLabel secondPartLabel = new JLabel(secondPart);
      secondPartLabel.setFont(new Font("Arial", Font.BOLD, 14));
      secondPartLabel.setForeground(Color.WHITE);

      // Add labels to the row panel
      linePanel.add(firstPartLabel, BorderLayout.WEST);
      linePanel.add(secondPartLabel, BorderLayout.EAST);

      // Ensure the panel does not stretch too much
      linePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, firstPartLabel.getPreferredSize().height));

      // Add the row to the main panel
      this.add(linePanel);
      this.add(Box.createVerticalStrut(15)); // Add spacing between rows
    });

    this.add(Box.createVerticalGlue()); // Pushes content towards the center
  }

  @Override
  public void activatePanel() {
    this.setVisible(true);
    this.requestFocusInWindow();
  }

  @Override
  public void keyTyped(KeyEvent e) {
    System.out.println(e.getKeyChar());
    if (e.getKeyChar() == 'i') {
      Grid grid = GameManager.getInstance().getGrid();
      grid.setKeysEnabled(true);
      this.setVisible(false);
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


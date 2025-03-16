package nl.mpdev.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import nl.mpdev.GameManager;

public class InstructionPanel extends JPanel implements OverlayHandler, KeyListener {
  private JPanel detailsPanel;
  private Map<String, String> instructionLines;

  public InstructionPanel(Map<String, String> instructionLines) {
    this.detailsPanel = new JPanel();
    this.detailsPanel.setBackground(Color.BLACK);
    this.instructionLines = instructionLines;
    this.setLayout(new BorderLayout());
    this.setVisible(false);
    this.addKeyListener(this);
    this.detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
    // this.detailsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    this.add(detailsPanel);
    formatInstructionLines();
  }

  private void formatInstructionLines() {
    this.detailsPanel.add(Box.createVerticalGlue());
    instructionLines.forEach((firstPart, secondPart) -> {
      // Create a row panel
      JPanel linePanel = new JPanel(new BorderLayout()); // Ensures left & right alignment

      linePanel.setBackground(Color.BLACK);
      // Left panel with left-aligned label
      JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
      leftPanel.setOpaque(false);
      JLabel firstPartLabel = new JLabel(firstPart + ": ");
      firstPartLabel.setFont(new Font("Arial", Font.BOLD, 14));
      firstPartLabel.setForeground(Color.WHITE);
      leftPanel.add(firstPartLabel);

      // Right panel with right-aligned label
      JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
      rightPanel.setOpaque(false);
      JLabel secondPartLabel = new JLabel(secondPart);
      secondPartLabel.setFont(new Font("Arial", Font.BOLD, 14));
      secondPartLabel.setForeground(Color.WHITE);
      rightPanel.add(secondPartLabel);

      // Add panels to the row container
      linePanel.add(leftPanel, BorderLayout.WEST);
      linePanel.add(rightPanel, BorderLayout.EAST);

      // Add the row to the main details panel
      linePanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, firstPartLabel.getPreferredSize().height));
      detailsPanel.add(linePanel);
    });
    this.detailsPanel.add(Box.createVerticalGlue());
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
  }
}

package nl.mpdev.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import nl.mpdev.GameManager;

public class InstructionPanel extends JPanel implements OverlayHandler, KeyListener {
  private JPanel detailsPanel;
  private Map<String, String> instructionLines;

  public InstructionPanel(Map<String,String> instructionLines) {
    this.instructionLines = instructionLines;
    this.setLayout(new BorderLayout());
    this.setVisible(false);
    this.addKeyListener(this);
    this.setBackground(Color.BLACK);
    this.detailsPanel.setLayout(new BoxLayout(detailsPanel, BoxLayout.Y_AXIS));
    this.add(detailsPanel);
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

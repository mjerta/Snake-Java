package nl.mpdev.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
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
    formatInstructionLines();
  }

  private void formatInstructionLines(){
    instructionLines.forEach((firstPart, secondPart) -> {
      JPanel linePanel = new JPanel();
      linePanel.setLayout(new BorderLayout());

      JLabel firstPartLabel = new JLabel(firstPart + ": ");
      firstPartLabel.setFont(new Font("Arial",Font.BOLD, 14));
      firstPartLabel.setForeground(Color.WHITE);
      
      JLabel secondPartLabel = new JLabel(secondPart);
      secondPartLabel.setFont(new Font("Arial", Font.BOLD, 14));
      secondPartLabel.setForeground(Color.WHITE);
      
      //Putting everything together

      linePanel.add(firstPartLabel, BorderLayout.WEST);
      linePanel.add(secondPartLabel, BorderLayout.EAST);
      detailsPanel.add(linePanel);
    });
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

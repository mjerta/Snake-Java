package nl.mpdev.panels;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

public class InstructionPanel extends JPanel implements OverlayHandler {
  private Map<List, List> instructionLines;

  public InstructionPanel() {
    this.setLayout(new BorderLayout());
    this.setVisible(false);
    instructionLines = new HashMap<>();
  }

  @Override
  public void activatePanel() {
    this.setVisible(true);
  }
}

package nl.mpdev.panels;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

public class Instructions extends JPanel {
  private Map<List, List> instructionLines;

  public Instructions() {
    this.setLayout(new BorderLayout());
    
  }
}

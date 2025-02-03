package nl.mpdev.panels;

import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JPanel {

  public ScoreBoard(int width,int height) {
    this.setBackground(Color.BLACK);
    this.setPreferredSize(new Dimension(width, height));
  }
}

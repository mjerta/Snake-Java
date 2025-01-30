package nl.mpdev;

import javax.swing.*;
import java.awt.*;

public class Grid extends JPanel {

  public Grid(int width, int height) {
    this.setPreferredSize(new Dimension(width,height));
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
  }
}

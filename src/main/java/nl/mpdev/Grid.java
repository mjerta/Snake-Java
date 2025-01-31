package nl.mpdev;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class Grid extends JPanel {
  private double cellSize;
  private int width;
  private int height;

  public Grid(int width, int height) {
    this.width = width;
    this.height = height;
    this.cellSize = Math.floor((double) width / 10);
    this.setPreferredSize(new Dimension(width,height));
    this.setMaximumSize(new Dimension(width,height));
    this.setBackground(Color.BLACK);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    drawGrid(g);
  }

  private void drawGrid(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.white);
    Path2D.Double path = new Path2D.Double();

    // vertical lines
    for(double x = cellSize; x <= width; x+= cellSize) {
      path.moveTo(x,0);
      path.lineTo(x,height);
      g2d.draw(path);
    }

    for(double y = cellSize; y <= height; y+= cellSize) {
      path.moveTo(0,y);
      path.lineTo(width,y);
      g2d.draw(path);
    }
  }
}

package nl.mpdev;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

public class Grid extends JPanel {
  private double cellSize;

  public Grid(int width, int height) {
    this.cellSize = Math.floor((double) width / 10);
    this.setPreferredSize(new Dimension(width,height));
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
    for(double x = cellSize; x < getWidth(); x+= cellSize) {
      path.moveTo(x,0);
      path.lineTo(x,getHeight());
      g2d.draw(path);
    }

    for(double y = cellSize; y < getHeight(); y+= cellSize) {
      path.moveTo(0,y);
      path.lineTo(getWidth(),y);
      g2d.draw(path);
    }
  }
}

package nl.mpdev.components;

import java.awt.*;
import java.util.Random;

public class Ladder implements GridComponent {
  private final Random random;
  private int x;
  private int y;

  public Ladder() {
    this.random = new Random();
  }

  public void setInitialPosition(double cellSize, Dimension borderDimension) {
    this.x = random.nextInt((int) (borderDimension.width / cellSize)) * (int) cellSize;
    this.y = random.nextInt((int) (borderDimension.height / cellSize)) * (int) cellSize;
  }

  @Override
  public void draw(Graphics g, double cellSize) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.YELLOW);
    g2d.setStroke(new BasicStroke(3));
    g2d.drawLine(x + 3, y + 3, x + (int) cellSize - 3, y + (int) cellSize - 3);
    g2d.drawLine(x  + (int) cellSize - 3, y + 3, x + 3, y + (int) cellSize - 3);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
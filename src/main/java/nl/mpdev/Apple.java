package nl.mpdev;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class Apple {

  private final Random random;
  private int x;
  private int y;

  public Apple() {
    this.random = new Random();
  }

  public void respawn() {
  }

  public void draw(Graphics g, double cellsize) {
    g.setColor(Color.RED);
    g.fillOval(x, y, (int) cellsize, (int) cellsize);
  }

  public Apple setRandomApplePosition(double cellSize, Dimension borderDimension) {
    this.x = random.nextInt((int) (borderDimension.width / cellSize)) * (int) cellSize;
    this.y = random.nextInt((int) (borderDimension.height / cellSize)) * (int) cellSize;
    return this;
  }

}

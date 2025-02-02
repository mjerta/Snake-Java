package nl.mpdev;

import java.awt.*;
import java.util.Random;

public class Apple implements GridComponent {

  private final Random random;
  private int x;
  private int y;
  private double cellSize;
  private Dimension borderDimension;


  public Apple() {
    this.random = new Random();
  }

  public void respawn() {
    this.x = random.nextInt((int) (borderDimension.width / cellSize)) * (int) cellSize;
    this.y = random.nextInt((int) (borderDimension.height / cellSize)) * (int) cellSize;

  }

  @Override
  public void draw(Graphics g, double cellsize) {
    g.setColor(Color.RED);
    g.fillOval(x, y, (int) cellsize, (int) cellsize);
  }

  public Apple setInitialPosition(double cellSize, Dimension borderDimension) {
    this.cellSize = cellSize;
    this.borderDimension = borderDimension;
    respawn();
    return this;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}

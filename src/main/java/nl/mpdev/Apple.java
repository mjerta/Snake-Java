package nl.mpdev;

import java.awt.*;
import java.util.Random;
import java.util.Vector;

public class Apple {

  private int x;
  private int y;
  private final Random random;

  private Apple() {
    this.random = new Random();
  }

  public void respawn(){}

  public void draw(Graphics g, double cellsize) {
    g.setColor(Color.RED);
    g.fillOval(x, y, (int) cellsize, (int) cellsize);
  }

  public Apple setRandomApplePosition(double cellSize, Dimension borderDimension) {

    int randomX = random.nextInt((int) (borderDimension.width / cellSize)) * (int) cellSize;
    int randomY = random.nextInt((int) (borderDimension.height / cellSize)) * (int) cellSize;



  }


}

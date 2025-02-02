package nl.mpdev;

import java.awt.*;

public class Apple {

  private int x;
  private int y;

  public Apple(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void respawn(){}

  public void draw(Graphics g, double cellsize) {
    g.setColor(Color.RED);
    g.fillOval(x, y, (int) cellsize, (int) cellsize);
  }
}

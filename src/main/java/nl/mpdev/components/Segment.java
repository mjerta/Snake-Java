package nl.mpdev.components;

import java.awt.*;

public class Segment {

  private int x;
  private int y;
  private Color color;

  public Segment(int x, int y, Color color) {
    this.x = x;
    this.y = y;
    this.color = color;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public Color getColor() {
    return color;
  }
}

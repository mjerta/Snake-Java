package nl.mpdev;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class Snake {

  List<Segment> body;

  public Snake() {
    this.body = new LinkedList<>();
  }

  public void setBody(List<Segment> body) {
    this.body = body;
  }
  public void move() {}
  public void grow() {}


  public void draw(Graphics g, double cellSize) {
    g.setColor(Color.GREEN);
    body.forEach((segment -> g.fillRect(segment.getX(),segment.getY(),(int) cellSize,(int) cellSize)));
  }

}

package nl.mpdev;

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
  public void draw() {}

}

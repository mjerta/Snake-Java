package nl.mpdev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Snake{

  List<Segment> body;
  private final Random random;


  private Direction direction;

  public Snake() {
    this.body = new LinkedList<>();
    this.random = new Random();
  }

  public void setBody(List<Segment> body) {
    this.body = body;
  }
  public void move() {
    if(direction == null) return;
    switch (direction) {
      case LEFT:
        System.out.println("Left");
        break;
      case RIGHT:
        System.out.println("Right");
        break;
      case DOWN:
        System.out.println("Down");
        break;
      case UP:
        System.out.println("Up");
        break;
    }
  }
  public void grow() {}


  public void draw(Graphics g, double cellSize) {
    g.setColor(Color.GREEN);
    body.forEach((segment -> g.fillRect(segment.getX(),segment.getY(),(int) cellSize,(int) cellSize)));
  }

  public Snake setRandomSnakePosition(int width, int height, double cellSize) {
    new Snake();
    int randomX = random.nextInt((int) (width / cellSize)) * (int) cellSize;
    int randomY = random.nextInt((int) (height / cellSize)) * (int) cellSize;
    this.setBody(Arrays.asList(new Segment(randomX, randomY)));
    return this;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }
}

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

public class Snake {

  private final Random random;
  LinkedList<Segment> body;
  private Direction direction;

  public Snake() {
    this.body = new LinkedList<>();
    this.random = new Random();
  }

  public void setBody(LinkedList<Segment> body) {
    this.body = body;
  }

  public void move(int velocity) {
    if (direction == null) return;
    // Move the body segments
    for (int i = body.size() - 1; i > 0; i--) {
      body.get(i).setX(body.get(i - 1).getX());
      body.get(i).setY(body.get(i - 1).getY());
    }

    Segment head = body.getFirst();
    switch (direction) {
      case LEFT:
        head.setX(head.getX() - velocity);
        System.out.println("Left");
        break;
      case RIGHT:
        head.setX(head.getX() + velocity);
        System.out.println("Right");
        break;
      case DOWN:
        head.setY(head.getY() + velocity);
        System.out.println("Down");
        break;
      case UP:
        head.setY(head.getY() - velocity);
        System.out.println("Up");
        break;
    }
  }

  public void grow(double cellSize) {
    switch (direction) {
      case RIGHT:
        body.add(new Segment(body.getLast().getX() - (int) cellSize, body.getLast().getY()));
        break;
      case LEFT:
        body.add(new Segment(body.getLast().getX() + (int) cellSize, body.getLast().getY()));
        break;
      case UP:
        body.add(new Segment(body.getLast().getX(), body.getLast().getY() + (int) cellSize));
      case DOWN:
        body.add(new Segment(body.getLast().getX(), body.getLast().getY() - (int) cellSize));
    }
  }

  public void draw(Graphics g, double cellSize) {
    g.setColor(Color.GREEN);
    body.forEach((segment -> g.fillRect(segment.getX(), segment.getY(), (int) cellSize, (int) cellSize)));
  }

  public Snake setRandomSnakePosition(int width, int height, double cellSize) {
    new Snake();
    int randomX = random.nextInt((int) (width / cellSize)) * (int) cellSize;
    int randomY = random.nextInt((int) (height / cellSize)) * (int) cellSize;
    this.body.add(new Segment(randomX,randomY));
    return this;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }
}

package nl.mpdev.components;

import nl.mpdev.enums.Direction;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Snake implements GridComponent {
  private final Random random;
  private final Dimension borderDimension;
  LinkedList<Segment> body;
  private Direction direction;
  private boolean isAlive = true;

  public Snake() {
    this.body = new LinkedList<>();
    this.random = new Random();
    this.borderDimension = new Dimension();
  }

  public void move(int velocity) {
    if (direction == null || checkBorderCollision() || checkBodyCollision()) return;
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
    if (direction == null) return;
    Color randomColor = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    switch (direction) {
      case RIGHT:
        body.add(new Segment(body.getLast().getX() - (int) cellSize, body.getLast().getY(), randomColor));
        break;
      case LEFT:
        body.add(new Segment(body.getLast().getX() + (int) cellSize, body.getLast().getY(), randomColor));
        break;
      case UP:
        body.add(new Segment(body.getLast().getX(), body.getLast().getY() + (int) cellSize, randomColor));
        break;
      case DOWN:
        body.add(new Segment(body.getLast().getX(), body.getLast().getY() - (int) cellSize, randomColor));
        break;
    }
  }

  @Override
  public void draw(Graphics g, double cellSize) {
    body.stream()
      .skip(1)
      .forEach((segment -> {
        g.setColor(segment.getColor());
        g.fillRect(segment.getX(), segment.getY(), (int) cellSize, (int) cellSize);
      }));
    Segment head = body.getFirst();
    g.setColor(head.getColor());
    g.fillRect(head.getX(), head.getY(), (int) cellSize, (int) cellSize);
  }

  public Snake setRandomSnakePosition(double cellSize, Dimension borderDimension) {
    this.borderDimension.setSize(borderDimension);
    int randomX = random.nextInt((int) (borderDimension.width / cellSize)) * (int) cellSize;
    int randomY = random.nextInt((int) (borderDimension.height / cellSize)) * (int) cellSize;
    this.body.add(new Segment(randomX, randomY, Color.RED));
    return this;
  }

  private boolean checkBorderCollision() {
    Segment head = body.getFirst();
    if (head.getY() < 0 || head.getY() >= borderDimension.height || head.getX() < 0 || head.getX() >= borderDimension.width) {
      isAlive = false;
      return true;
    }
    return false;
  }

  public boolean checkAppleCollision(Apple apple) {
    Segment head = body.getFirst();
    return head.getX() == apple.getX() && head.getY() == apple.getY();
  }

  private boolean checkBodyCollision() {
    Segment head = body.getFirst();
    boolean headCollide = body.stream()
      .skip(1) // Skip the head
      .anyMatch(segment -> segment.getX() == head.getX() && segment.getY() == head.getY());
    if (headCollide) {
      isAlive = false;
      return true;
    }
    return false;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public boolean isAlive() {
    return isAlive;
  }
}

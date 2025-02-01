package nl.mpdev;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Snake {

  private final Random random;
  LinkedList<Segment> body;
  private Direction direction;

  public Snake() {
    this.body = new LinkedList<>();
    this.random = new Random();
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
    if(direction == null) return;
    Color randomColor = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));
      switch (direction) {
        case RIGHT:
          body.add(new Segment(body.getLast().getX() - (int) cellSize, body.getLast().getY(),randomColor));
          break;
        case LEFT:
          body.add(new Segment(body.getLast().getX() + (int) cellSize, body.getLast().getY(),randomColor));
          break;
        case UP:
          body.add(new Segment(body.getLast().getX(), body.getLast().getY() + (int) cellSize,randomColor));
        case DOWN:
          body.add(new Segment(body.getLast().getX(), body.getLast().getY() - (int) cellSize,randomColor));
      }
  }

  public void draw(Graphics g, double cellSize) {
    body.forEach((segment ->  {
      g.setColor(segment.getColor());
      g.fillRect(segment.getX(), segment.getY(), (int) cellSize, (int) cellSize);
    }));

  }

  public Snake setRandomSnakePosition(int width, int height, double cellSize) {
    new Snake();
    int randomX = random.nextInt((int) (width / cellSize)) * (int) cellSize;
    int randomY = random.nextInt((int) (height / cellSize)) * (int) cellSize;
    this.body.add(new Segment(randomX, randomY, Color.RED));
    return this;
  }

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }
}

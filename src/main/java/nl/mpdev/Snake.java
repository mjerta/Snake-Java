package nl.mpdev;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Snake implements KeyListener, ActionListener {

  List<Segment> body;
  private final Random random;

  public Snake() {
    this.body = new LinkedList<>();
    this.random = new Random();
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

  public Snake setRandomSnakePosition(int width, int height, double cellSize) {
    new Snake();
    int randomX = random.nextInt((int) (width / cellSize)) * (int) cellSize;
    int randomY = random.nextInt((int) (height / cellSize)) * (int) cellSize;
    this.setBody(Arrays.asList(new Segment(randomX, randomY)));
    return this;
  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}

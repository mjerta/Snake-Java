package nl.mpdev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Path2D;

public class Grid extends JPanel implements ActionListener, KeyListener {
  private final double cellSize;
  private final int width;
  private final int height;
  private final Snake snake;
  private final Apple apple;
  private final Timer timer;

  public Grid(int width, int height, double cellSize, Snake snake, Apple apple) {
    this.setBackground(Color.BLACK);
    this.width = width;
    this.height = height;
    this.cellSize = cellSize;
    this.snake = snake.setRandomSnakePosition(cellSize,new Dimension(width,height));
    this.apple= apple.setInitialPosition(cellSize, new Dimension(width,height));
    this.setPreferredSize(new Dimension(width, height));
    this.setFocusable(true);
    this.addKeyListener(this);
    this.timer = new Timer(100, this);
    timer.start();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    drawGrid(g);
    snake.draw(g, cellSize);
    apple.draw(g,cellSize);
  }

  private void drawGrid(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.white);
    Path2D.Double path = new Path2D.Double();
    // vertical lines
    for (double x = cellSize; x <= width; x += cellSize) {
      path.moveTo(x, 0);
      path.lineTo(x, height);
    }
    // Horizontal lines
    for (double y = cellSize; y <= height; y += cellSize) {
      path.moveTo(0, y);
      path.lineTo(width, y);
    }
    g2d.draw(path);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(!snake.isAlive()){
      timer.stop();
      System.out.println("The game has stopped, the snake is dead!");
      return;
    }
    snake.move((int) cellSize);
    if(snake.checkAppleCollision(apple)) {
      snake.grow(cellSize);
    }
    repaint();
  }

  @Override
  public void keyTyped(KeyEvent e) {
    Direction currentDirection = snake.getDirection();
    switch (e.getKeyChar()) {
      case 'a':
        if (currentDirection != Direction.RIGHT) {
          snake.setDirection(Direction.LEFT);
        }
        break;
      case 'd':
        if (currentDirection != Direction.LEFT) {
          snake.setDirection(Direction.RIGHT);
        }
        break;
      case 's':
        if (currentDirection != Direction.UP) {
          snake.setDirection(Direction.DOWN);
        }
        break;
      case 'w':
        if (currentDirection != Direction.DOWN) {
          snake.setDirection(Direction.UP);
        }
        break;
      case 'g':
        snake.grow(cellSize);
        break;
      default:
        break;
    }

  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }
}

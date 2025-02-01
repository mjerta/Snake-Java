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

  public Grid(int width, int height,double cellSize , Snake snake) {
    this.setBackground(Color.BLACK);
    this.width = width;
    this.height = height;
    this.cellSize = cellSize;
    this.snake = snake.setRandomSnakePosition(width,height,cellSize);
    this.setPreferredSize(new Dimension(width, height));
    this.setFocusable(true);
    this.addKeyListener(this);
    Timer timer = new Timer(100, this);
    timer.start();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    drawGrid(g);
    snake.draw(g,cellSize);
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
    snake.move();
    repaint();

  }

  @Override
  public void keyTyped(KeyEvent e) {

    switch (e.getKeyChar()) {
      case  'a':
        snake.setDirection(Direction.LEFT);
        break;
      case 'd':
        snake.setDirection(Direction.RIGHT);
        break;
      case 's':
        snake.setDirection(Direction.DOWN);
        break;
      case 'w':
        snake.setDirection(Direction.UP);
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

package nl.mpdev.panels;

import nl.mpdev.Player;
import nl.mpdev.components.Apple;
import nl.mpdev.components.Ladder;
import nl.mpdev.components.Snake;
import nl.mpdev.enums.Direction;
import nl.mpdev.factories.GridComponentFactory;

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
  private final Timer timer;
  private final int scoreToWin;
  private final int initialSpeed;
  private Snake snake;
  private Apple apple;
  private Ladder ladder;
  private boolean gridEnabled = true;
  private Player player;

  public Grid(int width, int height, double cellSize, int scoreToWin) {
    this.setBackground(Color.BLACK);
    this.width = width;
    this.height = height;
    this.cellSize = cellSize;
    this.scoreToWin = scoreToWin;
    this.snake = GridComponentFactory.createSnake(cellSize, new Dimension(width, height));
    this.apple = GridComponentFactory.createApple(cellSize, new Dimension(width, height));
    this.setPreferredSize(new Dimension(width, height));
    this.setFocusable(true);
    this.addKeyListener(this);
    this.initialSpeed = 100;
    this.timer = new Timer(initialSpeed, this);
    timer.start();
    player = Player.getInstance();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.BLACK);
    drawGrid(g);
    if (snake == null) {
      drawGameOver(g);
    }
    if (snake != null) {
      snake.draw(g, cellSize);
    }
    if (apple != null) {
      apple.draw(g, cellSize);
    }
    if (ladder != null) {
      ladder.draw(g, cellSize);
    }
  }

  private void drawGrid(Graphics g) {
    if (!gridEnabled) {
      return;
    }
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.lightGray);
    Path2D.Double path = new Path2D.Double();
    // vertical lines
    for (double x = 0; x < width; x += cellSize) {
      path.moveTo(x, 0);
      path.lineTo(x, height);
    }
    // Horizontal lines
    for (double y = cellSize; y < height; y += cellSize) {
      path.moveTo(0, y);
      path.lineTo(width, y);
    }
    g2d.draw(path);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (!snake.isAlive()) {
      handleSnakeDeath();
      return;
    }
    snake.move((int) cellSize);
    if (ladder == null && snake.checkAppleCollision(apple)) {
      handleAppleCollision();
    }
    handleRoundWon();
    repaint();
  }

  public void reset() {
    gridEnabled = true;
    if (snake == null) {
      snake = GridComponentFactory.createSnake(cellSize, new Dimension(width, height));
    }
    snake.reset(cellSize);
    if (apple != null) {
      apple.respawn();
    }
    else {
      apple = GridComponentFactory.createApple(cellSize, new Dimension(width, height));
    }
    if (player.isWonRound()) {
      player.setWonRound(false);
      ScoreBoard scoreBoard = ScoreBoard.getInstance();
      scoreBoard.setVictoryMessage(false);
      scoreBoard.updateScoreBoard();
    }
    ladder = null;
    timer.start();
  }

  private void handleSnakeDeath() {
    gridEnabled = false;
    apple = null;
    snake = null;
    ladder = null;
    repaint();
    timer.stop();
    System.out.println("The game has stopped, the snake is dead!");
  }

  private void drawGameOver(Graphics g) {
    g.setColor(Color.RED);
    g.setFont(new Font("Arial", Font.BOLD, 50));
    g.drawString("Game Over", width / 2 - 150, height / 2);
    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.BOLD, 20));
    g.drawString("Press Enter to restart", width / 2 - 115, height / 2 + 50);
  }

  private void handleAppleCollision() {
    snake.grow(cellSize);
    player.increaseScore();
    if (player.getScore() >= scoreToWin) {
      this.apple = null;
      this.ladder = GridComponentFactory.createLadder(cellSize, new Dimension(width, height));
    }
    else {
      System.out.println(player.getScore());// log out score in console
      apple.respawn();
    }
  }

  private void handleRoundWon() {
    if (ladder != null && snake.checkLadderCollision(ladder)) {
      timer.stop();
      player.setWonRound(true);
      ScoreBoard scoreBoard = ScoreBoard.getInstance();
      scoreBoard.setVictoryMessage(true);
      scoreBoard.addVictoryMessage();
      System.out.println("Congratulations! You have won the game!");
    }
  }

  @Override
  public void keyTyped(KeyEvent e) {
    if (snake != null) {
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

  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_SPACE) timer.setDelay(50);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    System.out.println(e.getKeyCode());
    switch (e.getKeyCode()) {
      case KeyEvent.VK_LEFT:
        snake.setDirection(Direction.LEFT);
        break;
      case KeyEvent.VK_RIGHT:
        snake.setDirection(Direction.RIGHT);
        break;
      case KeyEvent.VK_DOWN:
        snake.setDirection(Direction.DOWN);
        break;
      case KeyEvent.VK_UP:
        snake.setDirection(Direction.UP);
        break;
      case 10:
          reset();
        break;
      case 27:
        System.exit(0);
        break;
      case 32:
        timer.setDelay(initialSpeed);
        break;
      default:
        break;
    }

  }
}

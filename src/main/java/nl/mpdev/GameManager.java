package nl.mpdev;

import javax.swing.*;
import java.awt.*;

import java.awt.List.*;
import java.util.Arrays;
import java.util.Random;

public class GameManager extends JFrame {
  private static GameManager INSTANCE;
  private Snake snake;
  private Grid grid;
  private Apple apple;
  private ScoreBoard scoreBoard;
  private Timer timer;

  private GameManager() throws HeadlessException {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Snake (Java)");

    // Setup dimension for grid panel


    // SETUP SNAKE WITH INITIAL SEGMENT
    Snake snake = new Snake();
    this.grid = new Grid(640,640,20, snake);
    this.add(grid,BorderLayout.WEST);
    this.pack();
    this.setResizable(false);
    this.setVisible(true);
  }

  public static void getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new GameManager();
    }
  }

}

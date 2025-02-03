package nl.mpdev;

import nl.mpdev.components.Apple;
import nl.mpdev.components.Snake;
import nl.mpdev.panels.Grid;
import nl.mpdev.panels.ScoreBoard;

import javax.swing.*;
import java.awt.*;

public class GameManager extends JFrame {
  private static GameManager INSTANCE;
  private Snake snake;
  private Apple apple;
  private static ScoreBoard scoreBoard;
  private Timer timer;

  private GameManager() throws HeadlessException {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Snake (Java)");


    // SETUP PANELS
    Grid grid = new Grid(640, 640, 20, 150);
    scoreBoard = new ScoreBoard(200, 640);
    scoreBoard = new ScoreBoard(100, 640);
    this.add(grid,BorderLayout.WEST);
    this.add(scoreBoard,BorderLayout.EAST);
    this.pack();
    this.setResizable(false);
    this.setVisible(true);
  }

  public static void getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new GameManager();
    }
  }

  public static ScoreBoard getScoreBoard() {
    return scoreBoard;
  }

}

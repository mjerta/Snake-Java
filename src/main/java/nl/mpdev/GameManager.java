package nl.mpdev;

import javax.swing.*;
import java.awt.*;

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
    this.grid = new Grid(640,640, new Snake());
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

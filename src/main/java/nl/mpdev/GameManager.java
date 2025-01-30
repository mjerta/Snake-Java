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
    this.setPreferredSize(new Dimension(600,450));
    this.setTitle("Snake (Java)");
    this.setLayout(new BorderLayout()); // Testing with layout
    this.setVisible(true);
    this.grid = new Grid(450,450);
    this.pack();
    this.add(grid,BorderLayout.WEST);

  }

  public static GameManager getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new GameManager();
    }
    return INSTANCE;
  }

}

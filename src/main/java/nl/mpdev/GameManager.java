package nl.mpdev;

import nl.mpdev.panels.Grid;
import nl.mpdev.panels.ScoreBoard;

import javax.swing.*;
import java.awt.*;

public class GameManager extends JFrame {
  private static GameManager INSTANCE;
  private int level = 0;
  private int scoreTowin = 150;

  private GameManager() throws HeadlessException {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Snake (Java)");

    // SETUP PANELS
    Grid grid = new Grid(640, 640, 20, scoreTowin);
    this.add(grid, BorderLayout.WEST);
    this.add(ScoreBoard.getInstance(), BorderLayout.EAST);
    this.pack();
    this.setResizable(false);
    this.setVisible(true);
  }

  public GameManager getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new GameManager();
    }
    return INSTANCE;
  }

  public void increaseLevel(){
    level++;
    scoreTowin += 150;
  }
}
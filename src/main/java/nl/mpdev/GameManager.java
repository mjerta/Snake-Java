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
  private Grid grid;
  private Apple apple;
  private ScoreBoard scoreBoard;
  private Timer timer;
  private Player player;

  private GameManager() throws HeadlessException {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Snake (Java)");
    this.player = new Player("Player 1");


    // SETUP GRID PANEL
    this.grid = new Grid(640,640,20);
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

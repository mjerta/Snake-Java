package nl.mpdev;

import nl.mpdev.panels.Grid;
import nl.mpdev.panels.ScoreBoard;

import javax.swing.*;
import java.awt.*;

public class GameManager extends JFrame {
  private static GameManager INSTANCE;
  private int level = 1;
  private int scoreToWin = 150;

  private GameManager() throws HeadlessException {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Snake (Java)");

    // SETUP PANELS

    // Create the top panel with a layout manager
    JPanel topPanel = new JPanel();
    topPanel.setLayout(new FlowLayout()); // You can also use other layout managers
    topPanel.setBackground(Color.GREEN);

    // Add dynamic panels or components to topPanel
    // JLabel exampleLabel = new JLabel("Top Panel Label");
    // topPanel.add(exampleLabel); // Add more components as needed

    Grid grid = new Grid(640, 640, 20);
    this.add(grid, BorderLayout.WEST);
    this.add(ScoreBoard.getInstance(), BorderLayout.EAST);
    this.add(topPanel, BorderLayout.NORTH);
    this.pack();
    System.out.println(this.getWidth() + " " + this.getHeight());
    SwingUtilities.invokeLater(() -> {
      topPanel.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
      topPanel.revalidate();
    });
    this.setResizable(false);
    this.setVisible(true);
  }

  public static GameManager getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new GameManager();
    }
    return INSTANCE;
  }

  public void increaseLevel() {
    level++;
    scoreToWin = scoreToWin * 2;
  }

  public int getScoreToWin() {
    return scoreToWin;
  }

  public void resetGameStatus() {
    level = 1;
    scoreToWin = 150;
  }

  public int getLevel() {
    return level;
  }

}

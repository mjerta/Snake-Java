package nl.mpdev;

import nl.mpdev.panels.Grid;
import nl.mpdev.panels.Menu;
import nl.mpdev.panels.ScoreBoard;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

import java.awt.*;

public class GameManager extends JFrame {
  private static GameManager INSTANCE;
  private int level = 1;
  private int scoreToWin = 150;

  private GameManager() throws HeadlessException {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Snake (Java)");

    // SETUP PANELS
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setLayout(new OverlayLayout(layeredPane));

    // The 2 panels that will hold some sub panels
    JPanel mainPanel = new JPanel();
    JPanel overlayPanel = new Menu();

    Grid grid = new Grid(640, 640, 20);
    mainPanel.add(grid, BorderLayout.WEST);
    mainPanel.add(ScoreBoard.getInstance(), BorderLayout.EAST);


    layeredPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
    layeredPane.add(overlayPanel, JLayeredPane.PALETTE_LAYER);

    this.add(layeredPane);
    this.pack();
    System.out.println(this.getWidth() + " " + this.getHeight());
    SwingUtilities.invokeLater(() -> {
      overlayPanel.setPreferredSize(new Dimension(getWidth(), getHeight()));
      overlayPanel.revalidate();
    });
    System.out.println(overlayPanel.getWidth() + " " + overlayPanel.getHeight());
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

package nl.mpdev;

import nl.mpdev.panels.Background;
import nl.mpdev.panels.Grid;
import nl.mpdev.panels.Menu;
import nl.mpdev.panels.InstructionPanel;
import nl.mpdev.panels.ScoreBoard;

import javax.swing.*;

import java.awt.*;

public class GameManager extends JFrame {
  private static GameManager INSTANCE;
  private int level = 1;
  private int scoreToWin = 150;
  private Menu menu;
  private InstructionPanel instructionPanel;
  private Grid grid;

  private GameManager() throws HeadlessException {
    this.setTitle("Snake (Java)");
    // SETUP PANELS
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setOpaque(true);
    layeredPane.setLayout(new OverlayLayout(layeredPane));

    JPanel mainPanel = new JPanel();
    menu = new Menu();
    instructionPanel = new InstructionPanel();
    grid = new Grid(640, 640, 20);
    // The 2 panels that will hold some sub panels
    mainPanel.add(grid, BorderLayout.WEST);
    mainPanel.add(ScoreBoard.getInstance(), BorderLayout.EAST);

    layeredPane.add(mainPanel, JLayeredPane.DEFAULT_LAYER);
    layeredPane.add(instructionPanel, JLayeredPane.PALETTE_LAYER);
    layeredPane.add(menu, JLayeredPane.MODAL_LAYER);

    this.add(layeredPane);
    this.pack();
    SwingUtilities.invokeLater(() -> {
      instructionPanel.setPreferredSize(new Dimension(getWidth(), getHeight()));
      instructionPanel.revalidate();
      instructionPanel.repaint();
      menu.setPreferredSize(new Dimension(getWidth(), getHeight()));
      menu.revalidate();
      menu.repaint();
    });
    this.setVisible(true);
    this.setResizable(false);
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

  public Menu getMenu() {
    return menu;
  }

  public Grid getGrid() {
    return grid;
  }

  public InstructionPanel getInstuctionPanel() {
    return instructionPanel;
  }
}

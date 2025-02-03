package nl.mpdev.panels;

import nl.mpdev.Player;

import javax.swing.*;
import java.awt.*;

public class ScoreBoard extends JPanel {
  private static ScoreBoard INSTANCE;

  private ScoreBoard() {
    int width = 200;
    int height = 640;
    this.setBackground(Color.BLACK);
    this.setPreferredSize(new Dimension(width, height));
  }

  public static ScoreBoard getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new ScoreBoard();
    }
    return INSTANCE;
  }

  private void drawScore(Graphics g) {
    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.PLAIN, 20));
    g.drawString("Score: " + Player.getInstance().getScore(), 10, 20);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawScore(g);
  }

  public void updateScore() {
    repaint();
  }
}

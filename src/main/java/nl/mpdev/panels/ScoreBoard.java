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
    this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
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
    g.drawString("Player: " + Player.getInstance().getName(), 20, 40);
    g.drawString("Score: " + Player.getInstance().getScore(), 20, 80);
  }

  public void addVictoryMessage() {
    Graphics g = this.getGraphics();
    g.setColor(Color.WHITE);
    g.setFont(new Font("Arial", Font.PLAIN, 20));
    g.drawString("You won!", 20, 120);
    g.setFont(new Font("Arial", Font.PLAIN, 13));
    g.drawString("Press enter for another round", 20, 160);
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

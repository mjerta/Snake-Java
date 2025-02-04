package nl.mpdev.components;

import org.kordamp.ikonli.material.Material;
import java.awt.*;
import java.util.Random;

public class Ladder implements GridComponent {
  private final Random random;
  private int x;
  private int y;
  private double cellSize;
  private Dimension borderDimension;

  public Ladder() {
    this.random = new Random();
  }

  public void setInitialPosition(double cellSize, Dimension borderDimension) {
    this.cellSize = cellSize;
    this.borderDimension = borderDimension;
    this.x = random.nextInt((int) (borderDimension.width / cellSize)) * (int) cellSize;
    this.y = random.nextInt((int) (borderDimension.height / cellSize)) * (int) cellSize;
  }

  @Override
  public void draw(Graphics g, double cellSize) {
    FontIcon ladderIcon = FontIcon.of(Material.LADDER)
    g.setColor(Color.YELLOW);
    g.fillRect(x, y, (int) cellSize, (int) cellSize);
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}
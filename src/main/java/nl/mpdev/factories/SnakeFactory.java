package nl.mpdev.factories;

import nl.mpdev.GridComponent;
import nl.mpdev.Snake;

import java.awt.*;
import java.rmi.server.ServerNotActiveException;

public class SnakeFactory extends GridComponentFactory{

  private final double cellSize;
  private final Dimension borderDimension;

  public SnakeFactory(double cellSize, Dimension borderDimension) {
    this.cellSize = cellSize;
    this.borderDimension = borderDimension;
  }

  @Override
  public GridComponent createGridObject() {
    Snake snake = new Snake();
    snake.setRandomSnakePosition(cellSize,borderDimension);
    return new Snake();
  }
}

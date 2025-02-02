package nl.mpdev.factories;

import nl.mpdev.Apple;
import nl.mpdev.GridComponent;

import java.awt.*;

public class AppleFactory extends GridComponentFactory {
  private final double cellSize;
  private final Dimension borderDimension;

  public AppleFactory(double cellSize, Dimension borderDimension) {
    this.cellSize = cellSize;
    this.borderDimension = borderDimension;
  }

  @Override
  public GridComponent createGridObject() {
    Apple apple = new Apple();
    apple.setInitialPosition(cellSize, borderDimension);
    return apple;
  }
}

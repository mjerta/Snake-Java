package nl.mpdev.factories;

import nl.mpdev.components.Apple;
import nl.mpdev.components.Ladder;
import nl.mpdev.components.Snake;
import java.awt.*;

public class GridComponentFactory {

  public static Snake createSnake(double cellSize, Dimension borderDimension) {
    Snake snake = new Snake();
    snake.setRandomSnakePosition(cellSize, borderDimension);
    return snake;
  }

  public static Apple createApple(double cellSize, Dimension borderDimension) {
    Apple apple = new Apple();
    apple.setInitialPosition(cellSize, borderDimension);
    return apple;
  }

  public static Ladder createLadder(double cellSize, Dimension borderDimension) {
    Ladder ladder = new Ladder();
    ladder.setInitialPosition(cellSize, borderDimension);
    return ladder;
  }
}

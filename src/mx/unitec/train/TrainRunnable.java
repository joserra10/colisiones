/**
 * 
 */
package mx.unitec.train;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Componente para mover los trenes.
 * 
 * @author ramonsalas
 */
public class TrainRunnable implements Runnable {

	/**
	 * @param panel
	 *            The panel
	 */
	public TrainRunnable(final RailPanel panel) {
		this.panel = panel;
	}

	/** The panel. */
	private final RailPanel panel;

	/** Cross flag. */
	private AtomicBoolean cross = new AtomicBoolean(Boolean.FALSE);

	/** The map position. */
	private Map<Integer, Position> mapPosition = new TreeMap<>();
	/** The cross y. */
	private int crossY;
	/** The corss x. */
	private int crossX;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true) {
			final List<RailVO> listRailVO = panel.getListRailVO();
			listRailVO.forEach(railVO -> {
				final int x = railVO.getxPosition();
				final int y = railVO.getyPosition();
				final int xy = railVO.getyPosition() + railVO.getHeight();
				final int yx = x + railVO.getWidth();
				railVO.getListImage().forEach(image -> {
					switch (image.getTrainRoute()) {
					case DOWN:
						image.setyPosition(image.getyPosition() + 10);
						if (image.getyPosition() >= xy) {
							image.setTrainRoute(TrainRoute.RIGHT);
						}
						break;
					case RIGHT:
						image.setxPosition(image.getxPosition() + 10);
						if (image.getxPosition() >= yx) {
							image.setTrainRoute(TrainRoute.UP);
						}
						break;
					case UP:
						image.setyPosition(image.getyPosition() - 10);
						if (image.getyPosition() <= y) {
							image.setTrainRoute(TrainRoute.LEFT);
						}
						break;
					case LEFT:
						image.setxPosition(image.getxPosition() - 10);
						if (image.getxPosition() <= x) {
							image.setTrainRoute(TrainRoute.DOWN);
						}
					default:
						break;
					}

					findCross(image.getxPosition(), image.getyPosition());
					mapPosition.put(image.getId(), new Position(image.getxPosition(), image.getyPosition()));
				});
			});

			if (cross.get()) {
				panel.setBoomImageValue(crossX, crossY);
			}

			panel.repaint();
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				System.err.println("Se genero un error en el transcurso de los trenes: " + e.getMessage());
				Thread.currentThread().interrupt();
			}
			cross.compareAndSet(Boolean.TRUE, Boolean.FALSE);
			panel.restartBoomImage();
		}
	}

	/**
	 * Se encarga de encontrar un choque de los trenes.
	 * 
	 * @param x
	 *            The x position
	 * @param y
	 *            The y position
	 */
	private void findCross(final int x, final int y) {
		for (Entry<Integer, Position> item : mapPosition.entrySet()) {
			if (item.getValue().getX() == x && item.getValue().getY() == y) {
				crossY = y;
				crossX = x;
				cross.compareAndSet(Boolean.FALSE, Boolean.TRUE);
			}
		}
	}

	class Position {

		public Position(final int x, final int y) {
			this.x = x;
			this.y = y;
		}

		/** The x. */
		private int x;
		/** The y. */
		private int y;

		/**
		 * @return the x
		 */
		public int getX() {
			return x;
		}

		/**
		 * @param x
		 *            the x to set
		 */
		public void setX(int x) {
			this.x = x;
		}

		/**
		 * @return the y
		 */
		public int getY() {
			return y;
		}

		/**
		 * @param y
		 *            the y to set
		 */
		public void setY(int y) {
			this.y = y;
		}

	}

}

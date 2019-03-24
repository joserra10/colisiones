/**
 * 
 */
package mx.unitec.train;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Shape;
import java.util.List;

/**
 * Clase que sirve para dibujar los rieles del tren.
 * 
 * @author ramonsalas
 */
public class RailPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6694713751172006406L;

	/**
	 * @param listRailVO
	 *            Lista de configuraci&oacute;n de los rieles.
	 */
	public RailPanel(final List<RailVO> listRailVO, final Image boomImage) {
		this.listRailVO = listRailVO;
		this.boomImage = boomImage;
	}

	/** Lista de configuracion de los rieles. */
	private final List<RailVO> listRailVO;

	/** The boom image. */
	private Image boomImage;
	/** The boom x position. */
	private int boomXPosition = 800;
	/** The boom y position. */
	private int boomYPosition = 800;
	/** The boom width position. */
	private int boomWidthPosition = 50;
	/** The boom height position. */
	private int boomHeightPosition = 50;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics graphics) {
		final Graphics2D graphics2d = (Graphics2D) graphics;
		listRailVO.forEach(railVO -> {
			final Shape rectangle = new Rectangle(railVO.getxPosition(), railVO.getyPosition(), railVO.getWidth(),
					railVO.getHeight());
			graphics2d.setColor(railVO.getRailColor());
			graphics2d.draw(rectangle);
			railVO.getListImage().forEach(image -> {
				graphics.drawImage(image.getTrainImage(), image.getxPosition(), image.getyPosition(),
						image.getImageWidth(), image.getImageHeight(), this);
			});
		});
		graphics.drawImage(boomImage, boomXPosition, boomYPosition, boomWidthPosition, boomHeightPosition, this);
	}

	/**
	 * Se encarga de establacer los valores a la imagen Boom.
	 * 
	 * @param xPosition
	 *            Posicion X
	 * @param yPosition
	 *            Posicion Y
	 * @param width
	 *            Width
	 * @param height
	 *            Height
	 */
	public void setBoomImageValue(final int xPosition, final int yPosition) {
		this.boomXPosition = xPosition;
		this.boomYPosition = yPosition;
	}

	/**
	 * Se encarga de restaurar los valores de la imagen boom.
	 */
	public void restartBoomImage() {
		this.boomXPosition = 800;
		this.boomYPosition = 800;
	}

	/**
	 * @return the listRailVO
	 */
	public List<RailVO> getListRailVO() {
		return listRailVO;
	}

	/**
	 * Componente Train.
	 * 
	 * @author ramonsalas
	 */
	class TrainComponent extends Component {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1173655098564672107L;

	}

}

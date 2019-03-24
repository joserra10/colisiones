/**
 * 
 */
package mx.unitec.train;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;

/**
 * Este componente tiene como objetivo crear un {@link Panel} por cada Tren.
 * 
 * @author ramonsalas
 */
public class TrainPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2176814970263208464L;

	/**
	 * @param trainImage
	 *            Imagen del tren.
	 * @param imageWidth
	 *            ancho de la imagen
	 * @param imageHeight
	 *            Alto de la imagen
	 * @param xPosition
	 *            Posici&oacute;n X
	 * @param yPosition
	 *            Posici&oacute;n Y
	 */
	public TrainPanel(final Image trainImage, final int imageWidth, final int imageHeight, final int xPosition,
			final int yPosition) {
		super();
		this.trainImage = trainImage;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	/** Imagen del tren. */
	private final Image trainImage;
	/** The image width. */
	private final int imageWidth;
	/** The image height. */
	private final int imageHeight;

	/** Posicion X del tren. */
	private int xPosition;
	/** Posicion Y del tren. */
	private int yPosition;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(final Graphics graphics) {
		graphics.drawImage(trainImage, xPosition, yPosition, imageWidth, imageHeight, this);
	}

	/**
	 * Se encarga de actualizar las coordadas del tren.
	 * 
	 * @param yPosition
	 *            Posici&oacute;n X del tren
	 * @param xPosition
	 *            Posici&oacute;n Y del tren
	 */
	public void updateCoordinates(final int yPosition, final int xPosition) {
		this.yPosition = yPosition;
		this.xPosition = xPosition;
	}

}

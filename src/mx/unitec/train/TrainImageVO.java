/**
 * 
 */
package mx.unitec.train;

import java.awt.Image;

/**
 * VO con la informai&oacute;n de la imagen del tren o vagon.
 * 
 * @author ramonsalas
 */
public class TrainImageVO {

	/**
	 * @param trainImage
	 *            Imagen.
	 * @param imageWidth
	 *            Width de la imagen
	 * @param imageHeight
	 *            Height de la imagen
	 * @param xPosition
	 *            Posicion X
	 * @param yPosition
	 *            Posicion Y
	 */
	public TrainImageVO(final int id, final Image trainImage, final int imageWidth, final int imageHeight,
			final int xPosition, final int yPosition, final TrainRoute trainRoute) {
		this.id = id;
		this.trainImage = trainImage;
		this.imageWidth = imageWidth;
		this.imageHeight = imageHeight;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.trainRoute = trainRoute;
	}

	/** The id image. */
	private final int id;
	/** The train image. */
	private final Image trainImage;
	/** The image width. */
	private final int imageWidth;
	/** The image height. */
	private final int imageHeight;
	/** The x position. */
	private int xPosition;
	/** The y position. */
	private int yPosition;
	/** The train route. */
	private TrainRoute trainRoute;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the xPosition
	 */
	public int getxPosition() {
		return xPosition;
	}

	/**
	 * @param xPosition
	 *            the xPosition to set
	 */
	public void setxPosition(final int xPosition) {
		this.xPosition = xPosition;
	}

	/**
	 * @return the yPosition
	 */
	public int getyPosition() {
		return yPosition;
	}

	/**
	 * @param yPosition
	 *            the yPosition to set
	 */
	public void setyPosition(final int yPosition) {
		this.yPosition = yPosition;
	}

	/**
	 * @return the trainImage
	 */
	public Image getTrainImage() {
		return trainImage;
	}

	/**
	 * @return the imageWidth
	 */
	public int getImageWidth() {
		return imageWidth;
	}

	/**
	 * @return the imageHeight
	 */
	public int getImageHeight() {
		return imageHeight;
	}

	/**
	 * @return the trainRoute
	 */
	public TrainRoute getTrainRoute() {
		return trainRoute;
	}

	/**
	 * @param trainRoute
	 *            the trainRoute to set
	 */
	public void setTrainRoute(TrainRoute trainRoute) {
		this.trainRoute = trainRoute;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(this.getClass().getName());
		builder.append("[trainImage=");
		builder.append(trainImage);
		builder.append(", imageWidth=");
		builder.append(imageWidth);
		builder.append(", imageHeight=");
		builder.append(imageHeight);
		builder.append(", xPosition=");
		builder.append(xPosition);
		builder.append(", yPosition=");
		builder.append(yPosition);
		builder.append(", trainRoute=");
		builder.append(trainRoute);
		builder.append("]");
		return builder.toString();
	}

}

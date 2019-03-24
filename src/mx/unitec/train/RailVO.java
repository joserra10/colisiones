/**
 * 
 */
package mx.unitec.train;

import java.awt.Color;
import java.util.List;

/**
 * VO con informaci&oacute;n el riel del tren.
 * 
 * @author ramonsalas
 */
public class RailVO {

	/**
	 * @param xPosition
	 *            The x position
	 * @param yPosition
	 *            The y position
	 * @param width
	 *            The width
	 * @param heigth
	 *            The height
	 * @param railColor
	 *            The rail color
	 */
	public RailVO(final int xPosition, final int yPosition, final int width, final int heigth, final Color railColor,
			final List<TrainImageVO> listImage) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.width = width;
		this.height = heigth;
		this.railColor = railColor;
		this.listImage = listImage;
	}

	/** Posicion X. */
	private int xPosition;
	/** Posicion Y. */
	private int yPosition;
	/** Ancho. */
	private int width;
	/** Alto. */
	private int height;
	/** Color del riel. */
	private Color railColor;

	/** Lista de imagenes del tren. */
	private final List<TrainImageVO> listImage;

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
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(final int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(final int height) {
		this.height = height;
	}

	/**
	 * @return the railColor
	 */
	public Color getRailColor() {
		return railColor;
	}

	/**
	 * @param railColor
	 *            the railColor to set
	 */
	public void setRailColor(Color railColor) {
		this.railColor = railColor;
	}

	/**
	 * @return the listImage
	 */
	public List<TrainImageVO> getListImage() {
		return listImage;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(this.getClass().getName());
		builder.append("[xPosition=");
		builder.append(xPosition);
		builder.append(", yPosition=");
		builder.append(yPosition);
		builder.append(", width=");
		builder.append(width);
		builder.append(", height=");
		builder.append(height);
		builder.append(", railColor=");
		builder.append(railColor);
		builder.append(", listImage=");
		builder.append(listImage);
		builder.append("]");
		return builder.toString();
	}

}

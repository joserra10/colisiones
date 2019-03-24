/**
 * 
 */
package mx.unitec.train;

import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase principal que genera la GUI.
 * 
 * @author ramonsalas
 */
public class TrainGUI extends Frame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4867274100682729059L;

	/** The wagon image path. */
	private static final String BOOM_IMAGE_PATH = "/home/ramonsalas/boom.png";

	/** The frame title. */
	private static final String TITLE = "Monitor de Trenes";
	/** The frame width. */
	private static final int WIDTH = 800;
	/** The frame height. */
	private static final int HEIGHT = 800;
	/** The frame resizable flag. */
	private static final boolean RESIZABLE = Boolean.FALSE;
	/** The frame visible flag. */
	private static final boolean VISIBLE = Boolean.TRUE;
	/** The train image path. */
	private static final String TRAIN_IMAGE_PATH = "/home/ramonsalas/train.png";
	/** The wagon image path. */
	private static final String WAGON_IMAGE_PATH = "/home/ramonsalas/wagon.png";
	/** The image width. */
	private static final int IMAGE_WIDTH = 30;
	/** The image height. */
	private static final int IMAGE_HEIGHT = 20;
	/** The train component. */
	private static TrainComponent TRAINT_COMPONENT;

	/**
	 * Constructor.
	 */
	public TrainGUI() {
		super(TITLE);
		TRAINT_COMPONENT = new TrainComponent();
		this.init();
	}

	/**
	 * Inicializa la GUI.
	 */
	private void init() {
		this.addWindowListener(this.getWindowAdapter());
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(RESIZABLE);
		this.setVisible(VISIBLE);
		final RailPanel railPanel = new RailPanel(this.createListRialConfig(),
				TRAINT_COMPONENT.getToolkit().createImage(BOOM_IMAGE_PATH));
		this.add(railPanel);
		initRunTrain(railPanel);
	}

	/**
	 * Se encarga de generar el hilo para mover los trenes.
	 * 
	 * @param panel
	 *            Panel
	 */
	private void initRunTrain(final RailPanel panel) {
		final Thread trainThread = new Thread(new TrainRunnable(panel));
		trainThread.start();
	}

	/**
	 * Se encarga de generar una lista de configuraciones de rieles del tren.
	 * 
	 * @return Lista de rieles del tren
	 */
	private List<RailVO> createListRialConfig() {
		final List<RailVO> listRailVO = new ArrayList<>();
		listRailVO.add(this.createRailVO(10, 10, 300, 200, Color.RED, 10));
		listRailVO.add(this.createRailVO(150, 100, 100, 300, Color.BLUE, 20));
		listRailVO.add(this.createRailVO(300, 50, 200, 200, Color.MAGENTA, 30));
		listRailVO.add(this.createRailVO(250, 250, 400, 100, Color.ORANGE, 40));
		listRailVO.add(this.createRailVO(350, 150, 100, 400, Color.YELLOW, 50));

		return listRailVO;
	}

	/**
	 * Se encarga de generar un riel de tren.
	 * 
	 * @param xPosition
	 *            The x position
	 * @param yPosition
	 *            The y position
	 * @param width
	 *            The rail width
	 * @param height
	 *            The rail height
	 * @param railColor
	 *            The rail color
	 * @return Riel del tren
	 */
	private RailVO createRailVO(final int xPosition, final int yPosition, final int width, final int height,
			final Color railColor, final int id) {
		return new RailVO(xPosition, yPosition, width, height, railColor,
				createListTrainImage(xPosition, yPosition, id));
	}

	/**
	 * Se encarga de generar una lista de imagenes del tren.
	 * 
	 * @param xPosition
	 *            Posicion X
	 * @param yPosition
	 *            Posicion Y
	 * @return Lista de imagenes del tren
	 */
	private List<TrainImageVO> createListTrainImage(final int xPosition, final int yPosition, final int id) {
		final List<TrainImageVO> listTrainImageVO = new ArrayList<>();

		listTrainImageVO.add(
				createTrainItem(xPosition, yPosition, TRAINT_COMPONENT, TRAIN_IMAGE_PATH, TrainRoute.DOWN, id + 1));
		final int secondXPosition = xPosition + IMAGE_WIDTH;
		listTrainImageVO.add(createTrainItem(secondXPosition, yPosition, TRAINT_COMPONENT, WAGON_IMAGE_PATH,
				TrainRoute.LEFT, id + 2));
		final int thirdXPosition = secondXPosition + IMAGE_WIDTH;
		listTrainImageVO.add(createTrainItem(thirdXPosition, yPosition, TRAINT_COMPONENT, WAGON_IMAGE_PATH,
				TrainRoute.LEFT, id + 3));

		return listTrainImageVO;
	}

	/**
	 * Se encarga de genera una nueva imagen del tren.
	 * 
	 * @param xPosition
	 *            Posicion X
	 * @param yPosition
	 *            Posicion Y
	 * @param component
	 *            Objeto que hereda de coponente
	 * @param imagePath
	 *            Path de la imagen
	 * @return
	 */
	private TrainImageVO createTrainItem(final int xPosition, final int yPosition, final Component component,
			final String imagePath, final TrainRoute trainRoute, final int id) {
		final Image image = component.getToolkit().createImage(imagePath);
		return new TrainImageVO(id, image, IMAGE_WIDTH, IMAGE_HEIGHT, xPosition, yPosition, trainRoute);
	}

	/**
	 * Se encarga de generar un adapter para escuchar el closing de la GUI.
	 * 
	 * @return Window Adapater
	 */
	private WindowAdapter getWindowAdapter() {
		return new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(-1);
			}
		};
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

# colisiones
Proyecto que genera una GUI para demostrar como se generan ciertas colisiones con trenes

Este proyecto es en respuesta a la siguiente petición

Se requiere el desarrollo de una aplicación que simule trenes corriendo en vías que se cruzan
como se ilustra en la imagen, la aplicación deberá registrar las colisiones de los trenes con sonidos
e imágenes de explosiones, cuando coincidan en un cruce de vías

Este proyecto cuanta con una clase principal desde la cual se tiene que inicializar el programa

    mx.unitec.train.TrainMain
    
Existen también ciertos parametros que hay que configurar con el fin de encontrar las imagenes correspondientes

En la clase:

    mx.unitec.train.TrainGUI
    
Se tendrá que configurar las constantes:

    private static final String BOOM_IMAGE_PATH = <IMAGE_PATH>
    private static final String TRAIN_IMAGE_PATH = <IMAGE_PATH>
    private static final String WAGON_IMAGE_PATH = <IMAGE_PATH>

Donde IMAGE_PATH es el path ABSOLUTO de la imagen correspondiente, en los fuentes se encontrarán estas imagenes

    src/train.png
    src/wagon.png
    src/boom.png

/*
 * Definição de uma imagem PPM em caracteres ASCII.
 */
package Image;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Caldeirão
 */
public class ImagePPM extends Image implements Cloneable {

    private int[][] matrixR;
    private int[][] matrixG;
    private int[][] matrixB;

    /**
     * Construtor vazio.
     *
     * @author Caldeirão
     */
    public ImagePPM() {
        super();
    }

    /**
     * Construtor com parametros.
     *
     * @author Caldeirão
     * @param type
     * @param width
     * @param height
     * @param intensity
     */
    public ImagePPM(String type, int width, int height, int intensity) {
        super(type, width, height, intensity);
        this.matrixR = new int[width][height];
        this.matrixG = new int[width][height];
        this.matrixB = new int[width][height];
    }

    /**
     * Inicializa as matrizes com o tamanho indicado.
     *
     * @author Caldeirão
     * @param width
     * @param height
     */
    @Override
    public void setImageSize(int width, int height) {
        super.setImageSize(width, height);
        this.matrixR = new int[width][height];
        this.matrixG = new int[width][height];
        this.matrixB = new int[width][height];
    }

    /**
     * Retorna a matriz RED de imagem.
     *
     * @author Caldeirão
     * @return
     */
    @Override
    public int[][] getMatrixR() {
        return matrixR;
    }

    /**
     * Altera a matriz RED de imagem.
     *
     * @author Caldeirão
     * @param matrixR
     */
    @Override
    public void setMatrixR(int[][] matrixR) {
        this.matrixR = matrixR;
    }

    /**
     * Retorna a matriz GREEN de imagem.
     *
     * @author Caldeirão
     * @return
     */
    @Override
    public int[][] getMatrixG() {
        return matrixG;
    }

    /**
     * Altera a matriz GREEN de imagem.
     *
     * @author Caldeirão
     * @param matrixG
     */
    @Override
    public void setMatrixG(int[][] matrixG) {
        this.matrixG = matrixG;
    }

    /**
     * Retorna a matriz BLUE de imagem.
     *
     * @author Caldeirão
     * @return
     */
    @Override
    public int[][] getMatrixB() {
        return matrixB;
    }

    /**
     * Altera a matriz BLUE de imagem.
     *
     * @author Caldeirão
     * @param matrixB
     */
    @Override
    public void setMatrixB(int[][] matrixB) {
        this.matrixB = matrixB;
    }

    /**
     * Método que desenha a imagem.
     *
     * @author Caldeirão
     * @return
     */
    @Override
    public BufferedImage draw() {
        //Instancia a nova bufferedImage com o tamanho da imagem.
        BufferedImage bufferedImage = new BufferedImage(width + 1, height + 1, BufferedImage.TYPE_INT_ARGB);
        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                //Retorna o color da matriz.
                Color color = new Color(matrixR[i][j], matrixG[i][j], matrixB[i][j]);
                bufferedImage.setRGB(i, j, color.getRGB());
            }
        }
        return bufferedImage;
    }

    /**
     * Método que clona a imagem.
     *
     * @author Caldeirão
     * @return
     */
    @Override
    public ImagePPM getClone() {
        try {
            // call clone in Object.
            return (ImagePPM) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(" Cloning not allowed. ");
            return this;
        }
    }

//==============================================================================     
    //Métodos não utilizados na imagem PPM.
    @Override
    public int[][] getMatrix() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMatrix(int[][] matrix) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

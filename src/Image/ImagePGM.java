/*
 * Definição de uma imagem PGM em caracteres ASCII.
 */
package Image;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author Caldeirão
 */
public class ImagePGM extends Image implements Cloneable {

    private int[][] matrix;  //Cada célula da matriz corresponde a um pixel.

    /**
     * Construtor vazio.
     *
     * @author Caldeirão
     */
    public ImagePGM() {
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
    public ImagePGM(String type, int width, int height, int intensity) {
        super(type, width, height, intensity);
        this.matrix = new int[width][height];
    }

    /**
     * Inicializa a matriz com o tamanho indicado.
     *
     * @author Caldeirão
     * @param width
     * @param height
     */
    @Override
    public void setImageSize(int width, int height) {
        super.setImageSize(width, height);
        this.matrix = new int[width][height];
    }

    /**
     * Retorna a matriz de imagem.
     *
     * @author Caldeirão
     * @return
     */
    @Override
    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * Altera a matriz de imagem.
     *
     * @author Caldeirão
     * @param matrix
     */
    @Override
    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
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
                int value = matrix[i][j];
                Color color = new Color(value, value, value);
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
    public ImagePGM getClone() {
        try {
            // call clone in Object.
            return (ImagePGM) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(" Cloning not allowed. ");
            return this;
        }
    }

//==============================================================================     
    //Métodos não utilizados na imagem PGM.
    @Override
    public int[][] getMatrixR() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[][] getMatrixG() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[][] getMatrixB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMatrixR(int[][] matrix) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMatrixG(int[][] matrix) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMatrixB(int[][] matrix) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

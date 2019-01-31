/*
 * Definição abstrata de uma imagem.
 */
package Image;

import java.awt.image.BufferedImage;

/**
 *
 * @author Caldeirão
 */
public abstract class Image implements Cloneable {

    protected String type;    //Formato. 
    protected int width;      //Largura/Eixo X.    
    protected int height;     //Altura/eixo Y.
    protected int intensity;  //Intensidade == Nº de tonalidades de cinza.    

    /**
     * Construtor vazio.
     *
     * @author Caldeirão
     */
    public Image() {

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
    public Image(String type, int width, int height, int intensity) {
        this.type = type;
        this.width = width;
        this.height = height;
        this.intensity = intensity;
    }

    /**
     * Inicializa a matriz com o tamanho indicado.
     *
     * @author Caldeirão
     * @param width
     * @param height
     */
    public void setImageSize(int width, int height) {
        this.width = width;
        this.height = height;
    }

    /**
     * Retorna o tipo de imagem (PGM,PBM,PPM). Por hora tra\balhamos apenas com
     * PGM.
     *
     * @author Caldeirão
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     * Altera o tipo de image..
     *
     * @author Caldeirão
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Retorna a largura da imagem.
     *
     * @author Caldeirão
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     * Retorna a altura da imagem..
     *
     * @author Caldeirão
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * Retorna o nº de tonalidades de cinza da imagem.
     *
     * @author Caldeirão
     * @return
     */
    public int getIntensity() {
        return intensity;
    }

    /**
     * Altera o nº de tonalidades de cinza.
     *
     * @author Caldeirão
     * @param intensity
     */
    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    /**
     * Retorna a matriz de imagem.
     *
     * @author Caldeirão
     * @return
     */
    public abstract int[][] getMatrix();

    /**
     * Retorna a matriz de imagem.
     *
     * @author Caldeirão
     * @return
     */
    public abstract int[][] getMatrixR();

    /**
     * Retorna a matriz de imagem.
     *
     * @author Caldeirão
     * @return
     */
    public abstract int[][] getMatrixG();

    /**
     * Retorna a matriz de imagem.
     *
     * @author Caldeirão
     * @return
     */
    public abstract int[][] getMatrixB();

    /**
     * Altera a matriz de imagem.
     *
     * @author Caldeirão
     * @param matrix
     */
    public abstract void setMatrix(int[][] matrix);

    /**
     * Altera a matriz de imagem RED.
     *
     * @author Caldeirão
     * @param matrix
     */
    public abstract void setMatrixR(int[][] matrix);

    /**
     * Altera a matriz de imagem GREEN.
     *
     * @author Caldeirão
     * @param matrix
     */
    public abstract void setMatrixG(int[][] matrix);

    /**
     * Altera a matriz de imagem BLUE.
     *
     * @author Caldeirão
     * @param matrix
     */
    public abstract void setMatrixB(int[][] matrix);

    /**
     * Método que desenha a imagem deve ser implementado em subclasses.
     *
     * @author Caldeirão
     * @return
     */
    public abstract BufferedImage draw();
    
    /**
     * Método que clona a imagem.
     *
     * @author Caldeirão
     * @return
     */
    public abstract Image getClone();
}

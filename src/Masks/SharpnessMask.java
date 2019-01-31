/*
 * Classe que representa a mascara de nitidez utiizada no filtro da mediana.
 */
package Masks;

/**
 *
 * @author Caldeirão
 */
public class SharpnessMask {

    private final int[][] mask;
    private final int width;
    private final int height;

    /**
     * Construtor vazio.
     *
     * @author Caldeirão
     * @param width
     * @param height
     */
    public SharpnessMask(int width, int height) {
        mask = new int[width][height];
        this.width = width;
        this.height = height;
    }

    /**
     * Retorna os valores da mascara de nitidez.
     *
     * @author Caldeirão
     * @return 
     */
    public int[][] getMask() {
        return mask;
    }

    /**
     * Inicializa a mascara do filtro laplaciano com peso central 4.
     *
     *
     * @author Caldeirão
     * @param image
     * @param burryImage
     */
    public void setSharpnessMask(int[][] image, int[][] burryImage) {

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.mask[i][j] = image[i][j] - burryImage[i][j];
            }
        }
    }
}

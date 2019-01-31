/*
 * Classe que representa a mascara utiizada no filtro laplaciano.
 */
package Masks;

/**
 *
 * @author Caldeirão
 */
public class LaplaceMask {

    private static final int SIZE = 3;
    private final int[][] mask;
    private final int[][] neighbors;
    private int constant;
    private int width;
    private int height;

    /**
     * Construtor vazio.
     *
     * @author Caldeirão
     */
    public LaplaceMask() {
        mask = new int[SIZE][SIZE];
        neighbors = new int[SIZE][SIZE];
        constant = 0;
    }

    /**
     * Retorna o tamanho da mascara. Width == Height.
     *
     * @author Caldeirão
     * @return
     */
    public static int getSize() {
        return SIZE;
    }

    /**
     * Inicializa a mascara do filtro laplaciano com peso central 4.
     *
     *
     * @author Caldeirão
     */
    public void setLaplaceFourMask() {
        mask[0][0] = 0;
        mask[0][1] = -1;
        mask[0][2] = 0;
        mask[1][0] = -1;
        mask[1][1] = 4;
        mask[1][2] = -1;
        mask[2][0] = 0;
        mask[2][1] = -1;
        mask[2][2] = 0;
    }

    /**
     * Inicializa a mascara do filtro laplaciano com peso central 8.
     *
     *
     * @author Caldeirão
     */
    public void setLaplaceEightMask() {
        mask[0][0] = -1;
        mask[0][1] = -1;
        mask[0][2] = -1;
        mask[1][0] = -1;
        mask[1][1] = 8;
        mask[1][2] = -1;
        mask[2][0] = -1;
        mask[2][1] = -1;
        mask[2][2] = -1;
    }

    /**
     * Calcula a média da mascara de laplace.
     *
     * @author Caldeirão
     * @param image
     * @param x
     * @param y
     * @return
     */
    public int getLaplaceAverage(int[][] image, int x, int y) {
        //Pega os vizinhos do pixel nas coordenadas passadas como parametro.
        this.getNeighbors(image, x, y);

        //Resultado do calculo da média.
        int average = 0;
        constant = 1;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                average += (neighbors[i][j] * mask[i][j]);
            }
        }
        return (average / constant);
    }

    /**
     * Retorna os vizinhos do pixel.
     *
     * @author Caldeirão
     */
    private void getNeighbors(int[][] image, int i, int j) {
        switch (i) {
            case 0: //Linha 0. 
                switch (j) {
                    case 0:    //Coluna 0.
                        //Quina superior esquerda, trabalharemos apenas com 4 pixeis válidos..                        
                        neighbors[0][0] = 0;
                        neighbors[0][1] = 0;
                        neighbors[0][2] = 0;
                        neighbors[1][0] = 0;
                        neighbors[1][1] = image[i][j];   //Valor que será alterado (Pixel central).
                        neighbors[1][2] = image[i][j + 1];
                        neighbors[2][0] = 0;
                        neighbors[2][1] = image[i + 1][j];
                        neighbors[2][2] = image[i + 1][j + 1];
                        break;
                    default:
                        if (j == height - 1) {    //Coluna final.
                            //Quina superior direita, trabalharemos apenas com 4 pixeis válidos.                      
                            neighbors[0][0] = 0;
                            neighbors[0][1] = 0;
                            neighbors[0][2] = 0;
                            neighbors[1][0] = image[i][j - 1];
                            neighbors[1][1] = image[i][j];   //Valor que será alterado (Pixel central).
                            neighbors[1][2] = 0;
                            neighbors[2][0] = image[i + 1][j - 1];
                            neighbors[2][1] = image[i + 1][j];
                            neighbors[2][2] = 0;
                        } else {
                            //Extremidade superior da matriz, 6 pixeis validos.                       
                            neighbors[0][0] = 0;
                            neighbors[0][1] = 0;
                            neighbors[0][2] = 0;
                            neighbors[1][0] = image[i][j - 1];
                            neighbors[1][1] = image[i][j];   //Valor que será alterado (Pixel central).
                            neighbors[1][2] = image[i][j + 1];
                            neighbors[2][0] = image[i + 1][j - 1];
                            neighbors[2][1] = image[i + 1][j];
                            neighbors[2][2] = image[i + 1][j + 1];
                        }
                        break;
                }
                break;
            default:
                if (i == width - 1) {    //Última linha.
                    switch (j) {
                        case 0:    //Coluna 0.
                            //Quina inferior esquerda, 4 pixeis válidos.                       
                            neighbors[0][0] = 0;
                            neighbors[0][1] = image[i - 1][j];
                            neighbors[0][2] = image[i - 1][j + 1];
                            neighbors[1][0] = 0;
                            neighbors[1][1] = image[i][j];   //Valor que será alterado (Pixel central).
                            neighbors[1][2] = image[i][j + 1];
                            neighbors[2][0] = 0;
                            neighbors[2][1] = 0;
                            neighbors[2][2] = 0;
                            break;
                        default:
                            if (j == height - 1) {   //Última coluna.
                                //Quina inferior direita, 4 pixeis válidos.                       
                                neighbors[0][0] = image[i - 1][j - 1];
                                neighbors[0][1] = image[i - 1][j];
                                neighbors[0][2] = 0;
                                neighbors[1][0] = image[i][j - 1];
                                neighbors[1][1] = image[i][j];   //Valor que será alterado (Pixel central).
                                neighbors[1][2] = 0;
                                neighbors[2][0] = 0;
                                neighbors[2][1] = 0;
                                neighbors[2][2] = 0;
                            } else {
                                //Extremidade inferior da matriz, 6 pixeis válidos.                       
                                neighbors[0][0] = image[i - 1][j - 1];
                                neighbors[0][1] = image[i - 1][j];
                                neighbors[0][2] = image[i - 1][j + 1];
                                neighbors[1][0] = image[i][j - 1];
                                neighbors[1][1] = image[i][j];   //Valor que será alterado (Pixel central).
                                neighbors[1][2] = image[i][j + 1];
                                neighbors[2][0] = 0;
                                neighbors[2][1] = 0;
                                neighbors[2][2] = 0;
                            }
                            break;
                    }
                } else {
                    switch (j) {
                        case 0:    //Coluna 0.
                            //Extremidade da esquerda, 6 pixeis válidos.                       
                            neighbors[0][0] = 0;
                            neighbors[0][1] = image[i - 1][j];
                            neighbors[0][2] = image[i - 1][j + 1];
                            neighbors[1][0] = 0;
                            neighbors[1][1] = image[i][j];   //Valor que será alterado (Pixel central).
                            neighbors[1][2] = image[i][j + 1];
                            neighbors[2][0] = 0;
                            neighbors[2][1] = image[i + 1][j];
                            neighbors[2][2] = image[i + 1][j + 1];
                            break;
                        default:
                            if (j == height - 1) {   //Última coluna.
                                //Extremidade da direita, 6 pixeis válidos.                      
                                neighbors[0][0] = image[i - 1][j - 1];
                                neighbors[0][1] = image[i - 1][j];
                                neighbors[0][2] = 0;
                                neighbors[1][0] = image[i][j - 1];
                                neighbors[1][1] = image[i][j];   //Valor que será alterado (Pixel central).
                                neighbors[1][2] = 0;
                                neighbors[2][0] = image[i + 1][j - 1];
                                neighbors[2][1] = image[i + 1][j];
                                neighbors[2][2] = 0;
                            } else {
                                //Valores centrais, 9 pixeis válidos.                       
                                neighbors[0][0] = image[i - 1][j - 1];
                                neighbors[0][1] = image[i - 1][j];
                                neighbors[0][2] = image[i - 1][j + 1];
                                neighbors[1][0] = image[i][j - 1];
                                neighbors[1][1] = image[i][j];   //Valor que será alterado (Pixel central).
                                neighbors[1][2] = image[i][j + 1];
                                neighbors[2][0] = image[i + 1][j - 1];
                                neighbors[2][1] = image[i + 1][j];
                                neighbors[2][2] = image[i + 1][j + 1];
                            }
                            break;
                    }
                    break;
                }
        }
    }

    /**
     * Seta o tamanho original da imagem.
     *
     * @author Caldeirão
     * @param width
     * @param height
     */
    public void setImageSize(int width, int height) {
        this.width = width;
        this.height = height;
    }
}

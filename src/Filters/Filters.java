/*
 * Classe que contém os filtros que podem ser aplicados na imagem.
 */
package Filters;

import Masks.AverageMask;
import Image.Image;
import Image.ImagePGM;
import Image.ImagePPM;
import Masks.LaplaceMask;
import Masks.SharpnessMask;

/**
 *
 * @author Caldeirão
 */
public class Filters {

    /**
     * Método que retorna a imagem negativa.
     *
     * @author Caldeirão
     * @param image
     */
    public void negativeFilter(Image image) {
        int bufferImage[][] = image.getMatrix();
        int intensity = image.getIntensity();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int color = bufferImage[i][j];
                color = intensity - color;
                if (color > intensity) {
                    color = intensity;
                }
                if (color < 0) {
                    color = 0;
                }
                bufferImage[i][j] = color;
            }
        }
    }

    /**
     * Método que retorna a imagem escurecida por subtração.
     *
     * @author Caldeirão
     * @param image
     * @param value
     */
    public void darknedSubFilter(Image image, float value) {
        int bufferImage[][] = image.getMatrix();
        int intensity = image.getIntensity();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int color = bufferImage[i][j];
                color = Math.round(color - value);
                if (color > intensity) {
                    color = intensity;
                }
                if (color < 0) {
                    color = 0;
                }
                bufferImage[i][j] = color;
            }
        }
    }

    /**
     * Método que retorna a imagem escurecida por divisão.
     *
     * @author Caldeirão
     * @param image
     * @param value
     */
    public void darknedDivFilter(Image image, float value) {
        int bufferImage[][] = image.getMatrix();
        int intensity = image.getIntensity();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int color = bufferImage[i][j];
                if (value > 0) {
                    color = Math.round(color / value);
                    if (color > intensity) {
                        color = intensity;
                    }
                    if (color <= 0) {
                        color = 0;
                    }
                    bufferImage[i][j] = color;
                }
            }
        }
    }

    /**
     * Método que retorna a imagem clareada por soma.
     *
     * @author Caldeirão
     * @param image
     * @param value
     */
    public void lightenedAddFilter(Image image, float value) {
        int bufferImage[][] = image.getMatrix();
        int intensity = image.getIntensity();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int color = bufferImage[i][j];
                color = Math.round(color + value);
                if (color > intensity) {
                    color = intensity;
                }
                if (color < 0) {
                    color = 0;
                }
                bufferImage[i][j] = color;
            }
        }
    }

    /**
     * Método que retorna a imagem clareada por multiplicação.
     *
     * @author Caldeirão
     * @param image
     * @param value
     */
    public void lightenedMultFilter(Image image, float value) {
        int bufferImage[][] = image.getMatrix();
        int intensity = image.getIntensity();

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                int color = bufferImage[i][j];
                if (value > 0) {
                    color = Math.round(color * value);
                    if (color > intensity) {
                        color = intensity;
                    }
                    if (color < 0) {
                        color = 0;
                    }
                    bufferImage[i][j] = color;
                }
            }
        }
    }

    /**
     * Método que retorna a imagem rotacionada no angulo passado pelo parametro
     * value.
     *
     * @author Caldeirão
     * @param image
     * @param value
     */
    public void rotateImage(Image image, int value) {
        int width = image.getWidth();
        int height = image.getHeight();
        int bufferImage[][] = image.getMatrix();
        int newImage[][];

        switch (value) {
            case 1: //90º
                newImage = new int[height][width];
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        int color = bufferImage[i][j];
                        newImage[image.getWidth() - 1 - j][i] = color;
                    }
                }
                image.setMatrix(newImage);
                break;
            case -1: //-90º
                newImage = new int[height][width];
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        int color = bufferImage[i][j];
                        newImage[j][image.getHeight() - 1 - i] = color;
                    }
                }
                image.setMatrix(newImage);
                break;
            case 2: //180º
                newImage = new int[width][height];
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        int color = bufferImage[i][j];
                        newImage[image.getHeight() - 1 - i][image.getWidth() - 1 - j] = color;
                    }
                }
                image.setMatrix(newImage);
                break;
        }
    }

    /**
     * Método que retorna a imagem espelhada verticalmente.
     *
     * @author Caldeirão
     * @param image
     */
    public void verticalMirror(Image image) {
        int bufferImage[][] = image.getMatrix();
        int width = image.getWidth();
        int height = image.getHeight();
        int[][] newImage = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int color = bufferImage[i][j];
                newImage[image.getHeight() - 1 - i][j] = color;
            }
        }
        image.setMatrix(newImage);
    }

    /**
     * Método que retorna a imagem espelhada horizontalmente.
     *
     * @author Caldeirão
     * @param image
     */
    public void horizontalMirror(Image image) {
        int bufferImage[][] = image.getMatrix();
        int width = image.getWidth();
        int height = image.getHeight();
        int newImage[][] = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int color = bufferImage[i][j];
                newImage[i][image.getWidth() - 1 - j] = color;
            }
        }
        image.setMatrix(newImage);
    }

    /**
     * Aumenta o tamanho da imagem (zoom) em relação a uma constante passada por
     * parâmetro.
     *
     * @author Caldeirão
     * @param image
     * @param zoom
     * @return
     */
    public Image zoom(Image image, int zoom) {
        int bufferImage[][] = image.getMatrix();
        int width = image.getWidth();
        int height = image.getHeight();
        int newImage[][] = new int[width * zoom][height * zoom];

        //Copia para a oldImage.
        ImagePGM oldImage = new ImagePGM();
        oldImage.setType(image.getType());
        oldImage.setIntensity(image.getIntensity());
        oldImage.setImageSize(width, height);

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                oldImage.getMatrix()[i][j] = bufferImage[i][j];
                applyZoomOnPixel(i, j, zoom, bufferImage[i][j], newImage);
            }
        }
        image.setMatrix(newImage);
        return oldImage;
    }

    /**
     * Aplica o zoom a um único pixel.
     *
     * @author Caldeirão
     */
    private void applyZoomOnPixel(int i, int j, int zoom, int color, int[][] transformedMatrix) {
        for (int m = i * zoom; m < i * zoom + zoom; m++) {
            for (int n = j * zoom; n < j * zoom + zoom; n++) {
                transformedMatrix[m][n] = color;
            }
        }
    }

    /**
     * Calcula a média padrão no pixel central utilizando uma mascara 3x3.
     *
     * @author Caldeirão
     * @param image
     */
    public void standardAverage(Image image) {
        AverageMask mask = new AverageMask();
        //Mascara para média padrão.
        mask.setStandardAverageMask();

        //Size.
        int width = image.getWidth();
        int height = image.getHeight();
        mask.setImageSize(width, height);

        int bufferImage[][] = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                bufferImage[i][j] = mask.getStandardAverage(image.getMatrix(), i, j);
            }
        }
        image.setMatrix(bufferImage);
    }

    /**
     * Calcula a média padrão no pixel central utilizando uma mascara 3x3.
     *
     * @author Caldeirão
     * @param image
     */
    public void weightedAverage(Image image) {
        AverageMask mask = new AverageMask();
        //Mascara para média ponderada.
        mask.setWeightedAverageMask();

        //Size.
        int width = image.getWidth();
        int height = image.getHeight();
        mask.setImageSize(width, height);

        int bufferImage[][] = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                bufferImage[i][j] = mask.getWeightedAverage(image.getMatrix(), i, j);
            }
        }
        image.setMatrix(bufferImage);
    }

    /**
     * Método de laplace (média + original). Peso 4.
     *
     * @author Caldeirão
     * @param image
     */
    public void laplaceFour(Image image) {
        //Imagem original.
        int bufferImage[][] = image.getMatrix();
        //Intensidade.
        int intensity = image.getIntensity();
        //Mascara com centro de peso 4.
        LaplaceMask mask = new LaplaceMask();
        mask.setLaplaceFourMask();

        //Size.
        int width = image.getWidth();
        int height = image.getHeight();
        mask.setImageSize(width, height);

        int newImage[][] = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //Soma a imagem original com a média.
                int color = bufferImage[i][j] + mask.getLaplaceAverage(bufferImage, i, j);
                newImage[i][j] = this.getNewColor(color, intensity);
            }
        }
        image.setMatrix(newImage);
    }

    /**
     * Método de laplace (média + original). Peso 8.
     *
     * @author Caldeirão
     * @param image
     */
    public void laplaceEight(Image image) {
        //Imagem original.
        int bufferImage[][] = image.getMatrix();
        //Intensidade.
        int intensity = image.getIntensity();
        //Mascara com centro de peso 4.
        LaplaceMask mask = new LaplaceMask();
        mask.setLaplaceEightMask();

        //Size.
        int width = image.getWidth();
        int height = image.getHeight();
        mask.setImageSize(width, height);

        int newImage[][] = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //Soma a imagem original com a média.
                int color = bufferImage[i][j] + mask.getLaplaceAverage(bufferImage, i, j);
                newImage[i][j] = this.getNewColor(color, intensity);
            }
        }
        image.setMatrix(newImage);
    }

    /**
     * Método de Potência de gamma.
     *
     * @author Caldeirão
     * @param image
     * @param c
     * @param gamma
     */
    public void gammaPow(Image image, float c, float gamma) {
        int bufferImage[][] = image.getMatrix();
        //Intensidade.
        int intensity = image.getIntensity();
        //Size.
        int width = image.getWidth();
        int height = image.getHeight();
        //Nova imagem.
        int newImage[][] = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //Divide o valor atual do pixel por sua intensidade(obtendo um valor entre 0 e 1).
                float r = (float) bufferImage[i][j] / (float) intensity;
                //Calcula a potencia de gamma.
                float value = c * (float) Math.pow(r, gamma);
                //Retorna a escala normal de intensidade.
                //Arredonda o valor da cor.
                int color = Math.round(value * intensity);
                newImage[i][j] = getNewColor(color, intensity);
            }
        }
        image.setMatrix(newImage);
    }

    /**
     * Método de Potência de gamma que intensifica os valores no intervalo e
     * mantém os outros valores.
     *
     * @author Caldeirão
     * @param image
     * @param min
     * @param max
     */
    public void highlightsRangeAndPreserveRest(Image image, int min, int max) {
        int bufferImage[][] = image.getMatrix();
        //Intensidade.
        int intensity = image.getIntensity();
        //Size.
        int width = image.getWidth();
        int height = image.getHeight();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int color = bufferImage[i][j];
                //Se o valor estiver contido no intervalo é maximizado.
                if ((color >= min) && (color <= max)) {
                    bufferImage[i][j] = intensity;
                }
            }
        }
    }

    /**
     * Método de Potência de gamma que intensifica os valores no intervalo e
     * reduz ao minimo os outros valores.
     *
     * @author Caldeirão
     * @param image
     * @param min
     * @param max
     */
    public void highlightsRangeAndLowerRest(Image image, int min, int max) {
        int bufferImage[][] = image.getMatrix();
        //Intensidade.
        int intensity = image.getIntensity();
        //Size.
        int width = image.getWidth();
        int height = image.getHeight();

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int color = bufferImage[i][j];
                //Se o valor estiver contido no intervalo é maximizado.
                if ((color >= min) && (color <= max)) {
                    bufferImage[i][j] = intensity;
                } else {
                    bufferImage[i][j] = 0;
                }
            }
        }
    }

    /**
     * Método que reduz a intensidade da imagem.
     *
     * @author Caldeirão
     * @param image
     * @param newIntensity
     */
    public void intensityReduction(Image image, int newIntensity) {
        int bufferImage[][] = image.getMatrix();
        //Intensidade.
        int intensity = image.getIntensity();
        //Size.
        int width = image.getWidth();
        int height = image.getHeight();
        //Nova imagem.
        int newImage[][] = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int color = (newIntensity * bufferImage[i][j]) / intensity;
                newImage[i][j] = color;
            }
        }
        image.setMatrix(newImage);
    }

    /**
     * Método que atribui pseudocores à uma foto em tons de cinza.
     *
     * @author Caldeirão
     * @param image
     * @return
     */
    public ImagePPM pseudocolors(ImagePGM image) {
        int bufferImage[][] = image.getMatrix();
        //Intensidade.
        int intensity = image.getIntensity();
        //Size.
        int width = image.getWidth();
        int height = image.getHeight();
        //Nova imagem PPM.
        ImagePPM newImage = new ImagePPM("P3", width, height, intensity);
        int newMatrixR[][] = newImage.getMatrixR();
        int newMatrixG[][] = newImage.getMatrixG();
        int newMatrixB[][] = newImage.getMatrixB();

        //Intervalos
        //0 < min < max < intensity
        int min = intensity / 3;
        int max = 2 * intensity / 3;

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int color = bufferImage[i][j];
                if ((0 <= color) && (color <= min)) {    //Tonalidades baixas em azul.
                    newMatrixR[i][j] = 0;
                    newMatrixG[i][j] = 0;
                    newMatrixB[i][j] = color;
                } else if ((min < color) && (color <= max)) {    //Tonalidades médias em verde.
                    newMatrixR[i][j] = 0;
                    newMatrixG[i][j] = color;
                    newMatrixB[i][j] = 0;
                } else if ((max < color) && (color <= intensity)) {  ////Tonalidades altas em vermelho.
                    newMatrixR[i][j] = color;
                    newMatrixG[i][j] = 0;
                    newMatrixB[i][j] = 0;
                }
            }
        }
        return newImage;
    }

    /**
     * Método que aumenta a tonalizade vermelha.
     *
     * @author Caldeirão
     * @param image
     * @param value
     */
    public void moreRed(ImagePPM image, float value) {
        int bufferR[][] = image.getMatrixR();
        //Intensidade.
        int intensity = image.getIntensity();
        //Size.
        int width = image.getWidth();
        int height = image.getHeight();
        //Nova imagem.
        int newMatrixR[][] = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int color = Math.round(value + bufferR[i][j]);
                newMatrixR[i][j] = this.getNewColor(color, intensity);
            }
        }
        image.setMatrixR(newMatrixR);
    }

    /**
     * Método que aumenta a tonalizade verde.
     *
     * @author Caldeirão
     * @param image
     * @param value
     */
    public void moreGreen(ImagePPM image, float value) {
        int bufferG[][] = image.getMatrixG();
        //Intensidade.
        int intensity = image.getIntensity();
        //Size.
        int width = image.getWidth();
        int height = image.getHeight();
        //Nova imagem.
        int newMatrixG[][] = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int color = Math.round(value + bufferG[i][j]);
                newMatrixG[i][j] = this.getNewColor(color, intensity);
            }
        }
        image.setMatrixG(newMatrixG);
    }

    /**
     * Método que aumenta a tonalizade azul.
     *
     * @author Caldeirão
     * @param image
     * @param value
     */
    public void moreBlue(ImagePPM image, float value) {
        int bufferB[][] = image.getMatrixB();
        //Intensidade.
        int intensity = image.getIntensity();
        //Size.
        int width = image.getWidth();
        int height = image.getHeight();
        //Nova imagem.
        int newMatrixB[][] = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int color = Math.round(value * bufferB[i][j]);
                newMatrixB[i][j] = this.getNewColor(color, intensity);
            }
        }
        image.setMatrixB(newMatrixB);
    }

    /**
     * Método que aplica o filtro da mediana.
     *
     * @author Caldeirão
     * @param image
     * @param k
     */
    public void medianFilter(Image image, float k) {
        //Borrando a imagem.
        Image blurryImage = image.getClone();
        this.weightedAverage(blurryImage);
        //Size.
        int width = image.getWidth();
        int height = image.getHeight();
        SharpnessMask mask = new SharpnessMask(width, height);
        //Setando a mascara de nitidez.
        mask.setSharpnessMask(image.getMatrix(), blurryImage.getMatrix());
        //Nova Imagem.
        int[][] originalMatrix = image.getMatrix();
        int[][] maskMatrix = mask.getMask();
        int[][] newMatrix = new int[width][height];
        //nova cor.
        int newColor;
        int intensity = image.getIntensity();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) { 
                newColor = Math.round(originalMatrix[i][j] + (k * maskMatrix[i][j]));
                newMatrix[i][j] = this.getNewColor(newColor, intensity);
            }
        }
        image.setMatrix(newMatrix);
    }

//==============================================================================
//======================== Conversões (Somente PPM) ============================    
//==============================================================================
    /**
     * Método que converte o modelo de cor da imagem de RGB para CMY.
     *
     * @author Caldeirão
     * @param image
     */
    public void rgbToCmy(ImagePPM image) {
        int bufferR[][] = image.getMatrixR();
        int bufferG[][] = image.getMatrixG();
        int bufferB[][] = image.getMatrixB();
        //Intensidade.
        int intensity = image.getIntensity();
        //Size.
        int width = image.getWidth();
        int height = image.getHeight();
        //Nova imagem.
        int newMatrixR[][] = new int[width][height];
        int newMatrixG[][] = new int[width][height];
        int newMatrixB[][] = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                newMatrixR[i][j] = intensity - bufferR[i][j];
                newMatrixG[i][j] = intensity - bufferG[i][j];
                newMatrixB[i][j] = intensity - bufferB[i][j];
            }
        }
        image.setMatrixR(newMatrixR);
        image.setMatrixG(newMatrixG);
        image.setMatrixB(newMatrixB);
    }

    /**
     * Método que converte o modelo de cor da imagem de RGB para HSI. Não ta
     * funcionando.
     *
     * @author Caldeirão
     * @param image
     */
    public void rgbToHsi(ImagePPM image) {
        int bufferR[][] = image.getMatrixR();
        int bufferG[][] = image.getMatrixG();
        int bufferB[][] = image.getMatrixB();
        //Intensidade.
        int intensity = image.getIntensity();
        //Size.
        int width = image.getWidth();
        int height = image.getHeight();
        //Nova imagem.
        int newMatrixR[][] = new int[width][height];
        int newMatrixG[][] = new int[width][height];
        int newMatrixB[][] = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                float[] hsi = setNewColor(bufferR[i][j], bufferG[i][j], bufferB[i][j]);
                newMatrixR[i][j] = Math.round(hsi[0] * intensity);
                newMatrixG[i][j] = Math.round(hsi[1] * intensity);
                newMatrixB[i][j] = Math.round(hsi[2] * intensity);
            }
        }
        image.setMatrixR(newMatrixR);
        image.setMatrixG(newMatrixG);
        image.setMatrixB(newMatrixB);
    }

//==============================================================================
//========================= Métodos auxiliares =================================    
//==============================================================================
    /**
     * Retorna uma cor dentro dos limites de intensidade.
     *
     * @author Caldeirão
     * @param value
     * @param intensity
     * @return
     */
    public int getNewColor(int value, int intensity) {
        if (value > intensity) {
            return intensity;
        } else if (value < 0) {
            return 0;
        } else {
            return value;
        }
    }

    /**
     * Método que seta uma nova cor no pixel da imagem PPM. (Usado no metodo
     * rgbToHsi).
     *
     * @author Caldeirão
     * @param R
     * @param G
     * @param B
     * @return
     */
    public float[] setNewColor(int R, int G, int B) {
        float r = (float) R / (R + G + B);
        float g = (float) G / (R + G + B);
        float b = (float) B / (R + G + B);

        //Achando o H.           
        double h1 = (0.5 * ((r - g) + (r - b))) / Math.pow((Math.pow(r - g, 2) + ((r - b) * (g - b))), 0.5);
        //Intervalo 0 < h < PI.
        if (b <= g) {
            h1 = (1 / Math.cos(h1));
        } else {   //Intervalo PI < h < 2*PI.
            h1 = 2 * Math.PI - (1 / Math.cos(h1));
        }
        float h = (float) h1;
        //Identificando o minimo entre r,g,b.
        float min = Math.min(r, g);
        min = Math.min(min, b);
        float s = 1 - (3 * min);
        //Calcula I.
        int i = (R + G + B) / 255;
        //Montando um vetor HSI.
        float[] newPixel = {h, s, i};
        return newPixel;
    }
}

/*
 * Histograma da imagem.
 */
package Filters;

import Image.Image;

/**
 *
 * @author Caldeirão
 */
public class Histogram {

    private final int[] histogram;
    private final float[] histogramProportion;
    private final int[] histogramEqualized;
    private final int size;
    private final int intensity;

    /**
     * Contrutor da classe. O tamanho do histograma depende do numero de
     * tonalidades de cores da imagem.
     *
     * @author Caldeirão
     * @param intensity
     * @param width
     * @param height
     */
    public Histogram(int intensity, int width, int height) {
        this.histogram = new int[intensity];
        this.histogramProportion = new float[intensity];
        this.histogramEqualized = new int[intensity];
        //Nº total de pixels.
        this.size = width * height;
        //Intensidade.
        this.intensity = intensity;
    }

    /**
     * Equalização global da imagem.
     *
     * @author Caldeirão
     */
    public void globalEqualization() {
        for (int i = 0; i < histogramProportion.length; i++) {
            //Proporção acumulada.
            float pAcumulated = 0;
            for (int j = 0; j <= i; j++) {
                pAcumulated += histogramProportion[j];
            }
            //Calculo da nova cor (L - 1) * Σ pi, onde i=1 até i=intensity.
            int color = Math.round(intensity * pAcumulated);
            histogramEqualized[i] = color;
        }
    }

    /**
     * Equalização local da imagem.
     *
     * @author Caldeirão
     * @param image
     */
    public void localEqualization(Image image) {
        int bufferImage[][] = image.getMatrix();
        //Size.
        int width = image.getWidth();
        int height = image.getHeight();
        //Nova imagem.
        int newImage[][] = new int[width][height];        

        for(int i = 0; i < width; i += 2) {
            for(int j = 0; j < height; j += 2) {

            }
        }
    }
    
    /**
     * Estatistica de histograma.
     * (Regiões escuras)
     *
     * @author Caldeirão
     */
    public void histogramStatistics() {
//        int bufferImage[][] = image.getMatrix();
//        //Size.
//        int width = image.getWidth();
//        int height = image.getHeight();
//        //Nova imagem.
//        int newImage[][] = new int[width][height];        
//        //Média global.
//        float globalAverage = 0;
//        for(int i = 0; i < histogram.length; i++) {
//            globalAverage += (float)(i * histogram[i]);
//        }
//        globalAverage = globalAverage/(width * height);
//        //Desvio padrão global.
//
//        float globalPatternDeviation;  
        //Implementar depois.
    }    

    /**
     * Gerao histograma.
     *
     * @author Caldeirão
     * @param image
     */
    public void createHistogram(Image image) {
        int bufferImage[][] = image.getMatrix();
        int value;

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {
                value = bufferImage[i][j];
                //Incrementa.
                histogram[value]++;
            }
        }

        //Calcula a proporção.
        proportionCalculation();
    }

    /**
     * Seta as cores equalizadas na imagem.
     * (Equalização global).
     *
     * @author Caldeirão
     * @param image
     */
    public void setNewColors(Image image) {
        int bufferImage[][] = image.getMatrix();
        //Size.
        int width = image.getWidth();
        int height = image.getHeight();
        int index;
        //Nova imagem.
        int newImage[][] = new int[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                index = bufferImage[i][j];
                newImage[i][j] = histogramEqualized[index];
            }
        }
        image.setMatrix(newImage);
    }

    /**
     * Calcula a proporção do histograma.
     *
     * @author Caldeirão
     * @param image
     */
    private void proportionCalculation() {
        for (int i = 0; i < histogram.length; i++) {
            //proporção de pixels com a intensidade indicada.
            float p = (float) histogram[i] / size;
            histogramProportion[i] = p;
        }
    } 
    
    /**
     * Calcula a proporção do histograma.
     *
     * @author Caldeirão
     */
    private void localCalculation() {
        for (int i = 0; i < histogram.length; i++) {

        }
    }   
}
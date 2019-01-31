/*
 * Controlador geral.
 */
package Controller;

import FileReader.FileReader;
import Filters.Filters;
import Filters.Histogram;
import Image.Image;
import Image.ImagePGM;
import Image.ImagePPM;
import Masks.SharpnessMask;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author Caldeirão
 */
public class GeneralController {

    private final Filters filters;
    private Image image;
    private Image oldImage;
    private Histogram histogram;

    /**
     * Construtor vazio. Inicializa a classe de filtros.
     *
     * @author Caldeirão
     */
    public GeneralController() {
        this.filters = new Filters();
    }

//==============================================================================
//================================ Imagem ======================================    
//==============================================================================
    /**
     * Método que desenha a imagem.
     *
     * @author Caldeirão
     * @return
     */
    public BufferedImage drawImage() {
        return this.image.draw();
    }

    /**
     * Método que retorna a imagem.
     *
     * @author Caldeirão
     * @return
     */
    public Image getImage() {
        return image;
    }

//==============================================================================
//================================ Arquivo =====================================    
//==============================================================================
    /**
     * Método que lê o arquivo e gera a imagem.
     *
     * @author Caldeirão
     * @param file
     * @return
     * @throws java.io.IOException
     */
    public boolean readFile(File file) throws IOException {
        //Lê o arquivo.
        image = FileReader.readFile(file);
        return image != null; //Falha na leitura.
    }

    /**
     * Método que salva o arquivo da imagem.
     *
     * @author Caldeirão
     * @param file
     * @return
     * @throws java.io.IOException
     */
    public boolean saveFile(File file) throws IOException {
        return FileReader.saveFile(file, image);
    }

//==============================================================================
//================================ Filtros =====================================    
//==============================================================================
    /**
     * Método que retorna a imagem negativa.
     *
     * @author Caldeirão
     */
    public void negativeFilter() {
        filters.negativeFilter(image);
    }

    /**
     * Método que retorna a imagem escurecida por subtração.
     *
     * @author Caldeirão
     * @param value
     */
    public void darknedSubFilter(float value) {
        filters.darknedSubFilter(image, value);
    }

    /**
     * Método que retorna a imagem escurecida por divisão.
     *
     * @author Caldeirão
     * @param value
     */
    public void darknedDivFilter(float value) {
        filters.darknedDivFilter(image, value);
    }

    /**
     * Método que retorna a imagem clareada por soma.
     *
     * @author Caldeirão
     * @param value
     */
    public void lightenedAddFilter(float value) {
        filters.lightenedAddFilter(image, value);
    }

    /**
     * Método que retorna a imagem clareada por multiplicação.
     *
     * @author Caldeirão
     * @param value
     */
    public void lightenedMultFilter(float value) {
        filters.lightenedMultFilter(image, value);
    }

    /**
     * Método que retorna a imagem rotacionada no angulo passado pelo parametro
     * value.
     *
     * @author Caldeirão
     * @param value
     */
    public void rotateImage(int value) {
        filters.rotateImage(image, value);
    }

    /**
     * Método que retorna a imagem espelhada verticalmente.
     *
     * @author Caldeirão
     */
    public void verticalMirror() {
        filters.verticalMirror(image);
    }

    /**
     * Método que retorna a imagem espelhada horizontalmente.
     *
     * @author Caldeirão
     */
    public void horizontalMirror() {
        filters.horizontalMirror(image);
    }

    /**
     * Método que retorna a imagem em zoom. Value especifica o nivel do zoom.
     *
     * @author Caldeirão
     * @param value
     */
    public void zoom(int value) {
        oldImage = filters.zoom(image, value);
    }

    /**
     * Calcula a média padrão no pixel central utilizando uma mascara 3x3.
     *
     * @author Caldeirão
     */
    public void standardAverage() {
        filters.standardAverage(image);
    }

    /**
     * Calcula a média ponderada no pixel central utilizando uma mascara 3x3.
     *
     * @author Caldeirão
     */
    public void weightedAverage() {
        filters.weightedAverage(image);
    }

    /**
     * Método de laplace (média + original). Peso 4.
     *
     * @author Caldeirão
     */
    public void laplaceFour() {
        filters.laplaceFour(image);
    }

    /**
     * Método de laplace (média + original). Peso 8.
     *
     * @author Caldeirão
     */
    public void laplaceEight() {
        filters.laplaceEight(image);
    }

    /**
     * Método de Potência de gamma.
     *
     * @author Caldeirão
     * @param gamma
     */
    public void gammaPow(float gamma) {
        //Constante.
        float c = 1;
        filters.gammaPow(image, c, gamma);
    }

    /**
     * Método de Potência de gamma que intensifica os valores no intervalo e
     * preserva os outros valores.
     *
     * @author Caldeirão
     * @param min
     * @param max
     */
    public void highlightsRangeAndPreserveRest(int min, int max) {
        filters.highlightsRangeAndPreserveRest(image, min, max);
    }

    /**
     * Método de Potência de gamma que intensifica os valores no intervalo e
     * reduz ao minimo os outros valores.
     *
     * @author Caldeirão
     * @param min
     * @param max
     */
    public void highlightsRangeAndLowerRest(int min, int max) {
        filters.highlightsRangeAndLowerRest(image, min, max);
    }

    /**
     * Método que reduz a intensidade da imagem.
     *
     * @author Caldeirão
     * @param newIntensity
     */
    public void intensityReduction(int newIntensity) {
        filters.intensityReduction(image, newIntensity);
    }

    /**
     * Método que atribui pseudocores à uma foto em tons de cinza.
     *
     * @author Caldeirão
     */
    public void pseudocolors() {
        image = filters.pseudocolors((ImagePGM) image);
    }

    /**
     * Método que aumenta a tonalizade vermelha.
     *
     * @author Caldeirão
     * @param value
     */
    public void moreRed(float value) {
        filters.moreRed((ImagePPM) image, value);
    }

    /**
     * Método que aumenta a tonalizade verde.
     *
     * @author Caldeirão
     * @param value
     */
    public void moreGreen(float value) {
        filters.moreGreen((ImagePPM) image, value);
    }

    /**
     * Método que aumenta a tonalizade azul.
     *
     * @author Caldeirão
     * @param value
     */
    public void moreBlue(float value) {
        filters.moreBlue((ImagePPM) image, value);
    }
    
    /**
     * Método que aplica o filtro da mediana.
     *
     * @author Caldeirão
     * @param k
     */
    public void medianFilter(float k) {
        filters.medianFilter(image, k);
    }

//==============================================================================
//============================== Histograma ====================================    
//==============================================================================
    /**
     * Cria o histograma.
     *
     * @author Caldeirão
     */
    public void createHistogram() {
        if(image != null) {
            //Gera o histograma.
            this.histogram = new Histogram(image.getIntensity(), image.getWidth(), image.getHeight());
        }
        histogram.createHistogram(image);
    }

    /**
     * Equalização global.
     *
     * @author Caldeirão
     */
    public void globalEqualization() {
        histogram.globalEqualization();
        histogram.setNewColors(image);
    }

    /**
     * Equalização global.
     *
     * @author Caldeirão
     */
    public void localEqualization() {
        histogram.localEqualization(image);
    }

//==============================================================================
//======================== Conversões (Somente PPM) ============================    
//==============================================================================
    /**
     * Método que converte o modelo de cor da imagem de RGB para CMY.
     *
     * @author Caldeirão
     */
    public void rgbToCmy() {
        if (image.getType().equals("P3")) {
            filters.rgbToCmy((ImagePPM) image);
        }
    }

    /**
     * Método que converte o modelo de cor da imagem de RGB para HSI.
     *
     * @author Caldeirão
     */
    public void rgbToHsi() {
        if (image.getType().equals("P3")) {
            filters.rgbToHsi((ImagePPM) image);
        }
    }

//==============================================================================
//========================= Métodos Auxiliares =================================    
//==============================================================================
    /**
     * Sai do zoom.
     *
     * @author Caldeirão
     */
    public void lessZoom() {
        if (oldImage != null) {
            this.image = oldImage;
            this.oldImage = null;
        }
    }
}

/*
 * Classe que lê/salva o arquivo da imagem.
 * Apenas formato PGM e PPM em ASCII.
 */
package FileReader;

import Image.Image;
import Image.ImagePGM;
import Image.ImagePPM;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Caldeirão
 */
public class FileReader {

    /**
     * Método que faz a leitura do file para a matriz da imagem.
     *
     * @author Caldeirão
     * @param file
     * @return
     * @throws java.io.IOException
     */
    public static Image readFile(File file) throws IOException {

        try (Scanner scan = new Scanner(file)) {
            Image image = null;

            //Atributos da imagem.
            String type = "";    //Tipo.                  
            int width = 0;  //Eixo X.
            int height = 0; //Eixo Y.
            int intensity = 0;  //Intensidade.

            //Variaveis auxiliares.
            int buffer; //Buffer dos valores obtidos pelo scanner.
            int contHeader = 0; //0 = formato, 1 = width, 2 = height, 3 = grayScale.  

            //Montando o cabeçalho.
            while (contHeader < 3) {
                String line = scan.nextLine();
                if (line.contains("#")) {
                    //Comentário serão ignorados.
                } else if (!line.equals("")) {
                    switch (contHeader) {
                        case 0: //Type.
                            type = String.valueOf(line);
                            contHeader++;
                            break;
                        case 1: //Size. 
                            //Formata a linha primeiro, para evitar erros.
                            line = line.replace("  ", " ");
                            String size[] = line.split(" ");

                            width = Integer.valueOf(size[0]);
                            height = Integer.valueOf(size[1]);
                            contHeader++;
                            break;
                        case 2: //GrayScale.
                            intensity = Integer.valueOf(line);
                            contHeader++;
                            break;
                    }
                }
            }
            switch (type) {

                case "P2": { //PGM
                    //Instanciando a imagem PGM.
                    image = new ImagePGM(type, width, height, intensity);
                    int[][] matrix = image.getMatrix();

                    for (int j = 0; j < height; j++) {
                        for (int i = 0; i < width; i++) {
                            if (scan.hasNext()) {
                                buffer = scan.nextInt();
                                matrix[i][j] = buffer;
                            }
                        }
                    }
                    break;
                }
                case "P3":  //PPM
                    //Instanciando a imagem PPM.                    
                    image = new ImagePPM(type, width, height, intensity);
                    int[][] matrixR = image.getMatrixR();
                    int[][] matrixG = image.getMatrixG();
                    int[][] matrixB = image.getMatrixB();

                    for (int j = 0; j < height; j++) {
                        for (int i = 0; i < width; i++) {
                            for (int k = 0; k < 3; k++) {
                                switch (k) {
                                    case 0:
                                        if (scan.hasNext()) {
                                            buffer = scan.nextInt();
                                            matrixR[i][j] = buffer;
                                        }
                                        break;
                                    case 1:
                                        if (scan.hasNext()) {
                                            buffer = scan.nextInt();
                                            matrixG[i][j] = buffer;
                                        }
                                        break;
                                    case 2:
                                        if (scan.hasNext()) {
                                            buffer = scan.nextInt();
                                            matrixB[i][j] = buffer;
                                        }
                                        break;
                                }
                            }
                        }
                    }
                    break;
                default:
                    //Não é PGM nem PPM em formato texto.
                    break;
            }
            return image;
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return null;
        }
    }

    /**
     * Método que faz salva a imagem no file.
     *
     * @author Caldeirão
     * @param file
     * @param image
     * @return
     * @throws java.io.IOException
     */
    public static boolean saveFile(File file, Image image) throws IOException {
        try (FileWriter out = new FileWriter(file.getPath())) {

            //Header.
            out.write(image.getType() + "\n");    //Type.
            out.write(image.getWidth() + "\n");    //Width.
            out.write(image.getHeight() + "\n");    //Height.
            out.write(image.getIntensity() + "\n");    //Intensity.

            switch (image.getType()) {
                case "P2":  //PGM.
                    //Matriz de pixels.
                    int[][] matrix = image.getMatrix();

                    for (int i = 0; i < image.getWidth(); i++) {
                        for (int j = 0; j < image.getHeight(); j++) {
                            out.write(String.valueOf(matrix[i][j]) + " ");
                        }
                        out.write("\n");
                    }
                    out.close();
                    return true;
                case "P3":  //PPM.
                    int[][] matrixR = image.getMatrixR();
                    int[][] matrixG = image.getMatrixG();
                    int[][] matrixB = image.getMatrixB();

                    for (int i = 0; i < image.getWidth(); i++) {
                        for (int j = 0; j < image.getHeight(); j++) {
                            out.write(String.valueOf(matrixR[i][j] + " " + matrixG[i][j] + " " + matrixB[i][j] + " "));
                        }
                        out.write("\n");
                    }
                    out.close();
                    return true;
                default:
                    //Erro! Não deve cair aqui.
                    return false;
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            return false;
        }
    }
}

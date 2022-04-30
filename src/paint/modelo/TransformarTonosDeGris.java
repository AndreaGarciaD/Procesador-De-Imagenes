package paint.modelo;

import java.awt.*;
import java.awt.image.BufferedImage;

public class TransformarTonosDeGris extends Transformacion {

    public TransformarTonosDeGris(Imagen img) {
        this.imagen = img;
    }

    public TransformarTonosDeGris(BufferedImage bi) {
        this.biImagen = bi;
    }

    @Override
    public void transformarGris() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int c = pixeles[i][j];

                int r = (c >> 16);
                int g = (c >> 8) & 0x000000ff;
                int b = c & 0x000000ff;

                //int gris = (r + g + b) / 3;
                int gris = (int) (((double) r + (double) g + (double) b) / 3.0);

                //int intGris = gris & (gris << 8) & (gris << 16);
                int intGris = gris + gris * 256 + gris * 256 * 256;
                imagen.setColor(intGris, i, j);
                //pixeles[i][j] = r | g | b;
            }
        }
        imagen.transformada();
    }

    public void transformarEspejo() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int c = pixeles[i][j];

            }
        }
        imagen.transformada();
    }

    public void transformarAzul() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int c = pixeles[j][i];

                int r = (c >> 16) & 0x000000ff;
                int g = (c & 0x0000ff00);
                int b = (c & 0x000000ff) << 16;

                pixeles[j][i] = r | g | b;
            }
        }
        imagen.transformada();
    }

    public void transformarVerde() { //arreglar
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int rgb = pixeles[j][i];

                int a = (rgb >> 24) & 0x0000ff00;
                int g = (rgb >> 8) & 0x000000ff00;

                /*int promedio = (int) (((double) r + (double) g + (double) b) / 3.0);
                int bicolor;
                if (promedio < 127) {
                    bicolor = promedio + promedio * 0 + promedio * 0; //blanco
                } else {
                    bicolor = promedio + promedio * 255 + promedio * 255; //negro
                }
                imagen.setColor(bicolor, i, j);*/
                rgb = (a << 24) | (0 << 16) | (g << 8) | 0;
                imagen.setColor(rgb, i, j);
                //pixeles[i][j] = r | g | b;
            }
        }
        imagen.transformada();
    }
}

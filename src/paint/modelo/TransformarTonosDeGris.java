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
                int gris = (int)(((double)r + (double)g + (double)b) / 3.0);

                //int intGris = gris & (gris << 8) & (gris << 16);
                int intGris = gris + gris * 155 + gris * 155*155;
                imagen.setColor(intGris, i, j);
            }
        }
        imagen.transformada();
    }

    public void transformarBN() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAlto(); i++) {
            for (int j = 0; j < imagen.getAncho(); j++) {
                int c = pixeles[i][j];
                int r = (c >> 16);
                int g = (c >> 8) & 0x000000ff;
                int b = c & 0x000000ff;
                int promedio = (int) (((double) r + (double) g + (double) b) / 3.0);
                if (promedio <  100) {
                    c = 0x00000000;
                } else {
                    c = 0xffffffff;
                }
                imagen.setColor(c, i, j);
            }
        }
        imagen.transformada();
    }

    public void transformarAzul() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int rgb = pixeles[i][j];

                int a = (rgb >> 24) & 0xff;
                int b = rgb & 0xff;

                rgb = (a << 24) | (0) | b;
                imagen.setColor(rgb, i, j);
            }
        }
        imagen.transformada();
    }

    public void transformarVerde() { //arreglar
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int rgb = pixeles[i][j];

                int a = (rgb >> 24) & 0xff;
                int g = (rgb >> 8) & 0xff;

                rgb = (a << 24) | (0) | (g << 8);
                imagen.setColor(rgb, i, j);
                //pixeles[i][j] = r | g | b;
            }
        }
        imagen.transformada();
    }

    public void transformarRojo(){
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int rgb = pixeles[i][j];

                int a = (rgb >> 24) & 0xff;
                int r = (rgb >> 16) & 0xff;

                rgb = (a<<24) | (0) | r << 16;
                imagen.setColor(rgb, i, j);
            }
        }
        imagen.transformada();
    }
}

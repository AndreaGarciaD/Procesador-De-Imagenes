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
                int rgb = pixeles[i][j];
                int a = (rgb >> 24) & 0xff;
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                int promedio = (r + g + b) / 3;
                rgb = (a << 24) | (promedio << 16) | (promedio << 8) | promedio;


                imagen.setColor(rgb, i, j);
            }
        }
        imagen.transformada();
    }

    public void transformarBN() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int rgb = pixeles[i][j];
                int r = (rgb >> 16);
                int g = (rgb >> 8) & 0x000000ff;
                int b = rgb & 0x000000ff;
                int promedio = (int) (((double) r + (double) g + (double) b) / 3.0);
                if (promedio < 100) {
                    rgb = 0x00000000;
                } else {
                    rgb = 0xffffffff;
                }
                imagen.setColor(rgb, i, j);
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

    public void transformarVerde() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int rgb = pixeles[i][j];

                int a = (rgb >> 24) & 0xff;
                int g = (rgb >> 8) & 0xff;

                rgb = (a << 24) | (0) | (g << 8);
                imagen.setColor(rgb, i, j);
            }
        }
        imagen.transformada();
    }

    public void transformarRojo() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            for (int j = 0; j < imagen.getAlto(); j++) {
                int rgb = pixeles[i][j];

                int a = (rgb >> 24) & 0xff;
                int r = (rgb >> 16) & 0xff;

                rgb = (a << 24) | (0) | r << 16;
                imagen.setColor(rgb, i, j);
            }
        }
        imagen.transformada();
    }

    public void transformarEspejoVertical() {
        int[][] pixeles = imagen.getPixeles();
        for (int j = 0; j < imagen.getAlto(); j++) {
            int l = 0, r = imagen.getAncho() - 1;
            while (l < r) {

                int pl = pixeles[l][j];
                int pr = pixeles[r][j];

                imagen.setColor(pr, l, j);
                imagen.setColor(pl, r, j);

                l++;
                r--;
            }
        }
        imagen.transformada();
    }

    public void transformarEspejoHorizontal() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i++) {
            int l = imagen.getAlto() - 1, r = 0;
            while (r < l) {

                int pl = pixeles[i][l];
                int pr = pixeles[i][r];

                imagen.setColor(pr, i, l);
                imagen.setColor(pl, i, r);

                l--;
                r++;
            }
        }
        imagen.transformada();
    }

    public void transformarPixelar() {
        int fila = 0;
        int columna = 0;
        int limite = 166;
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho(); i = i + 3) {
            for (int j = 0; j < imagen.getAlto(); j = j+3) {
                pixeles[i][j] = pixeles[fila][columna];

            }
        }
        imagen.transformada();
        /*int filaRegion = 0;
        int columnaRegion = 0;
        do {
            for (int i = filaRegion; i < filaRegion + 3 || i < imagen.getAncho() - 1; i++) {
                for (int j = columnaRegion; j < columnaRegion + 3 || i <imagen.getAlto() - 1; j++) {
                    int rgb = pixeles[filaRegion][columnaRegion];
                    imagen.setColor(rgb, i, j);
                }
            }
            filaRegion += 3;
            columnaRegion += 3;
        } while (filaRegion < imagen.getAncho() - 1 && columnaRegion < imagen.getAlto() - 1);*/

    }

    /*
    Obtener los pixeles de una Buffered image
    int[][] pixeles = imagen.getPixeles();
        int rgb = pixeles[0][0];

        int a = (rgb >> 24) & 0xff;
        int r = (rgb>>16) & 0xff;
        int g = (rgb >> 8) & 0xff;
        int b = rgb & 0xff;

        a= 255;
        r= 100;
        g = 150;
        b = 200;

        rgb = (a<<24) | (r<<16) | (g<<8) | b;
        imagen.setColor(rgb, 0, 0);
        imagen.transformada();*/

    public void transformarBlur(){
        int [][] pixeles = imagen.getPixeles();
        Color color[];
        int i = 0;
        int max = 400, rad = 10;
        int a1 = 0, r1 = 0, g1 = 0, b1 = 0;
        color = new Color[max];

        int x = 1, y = 1, x1, y1, ex = 5, d=0;
        for ( x = rad; x < imagen.getAlto() - rad; x++) {
            for (y = rad; y < imagen.getAncho() - rad; y++) {
                 for (x1 = x - rad; x1 < x + rad; x1++){
                     for (y1 = y - rad; y1 < y + rad; y1++){
                         color[i++] = new Color(pixeles[y1][x1]);
                     }
                 }
                 i = 0;
                for (d = 0; d < max; d++) {
                    a1 = a1 + color[d].getAlpha();
                }
                a1 = a1 / (max);
                for (d = 0; d < max; d++) {
                    r1 = r1 + color[d].getRed();
                }
                r1 = r1 / (max);
                for (d = 0; d < max; d++) {
                    g1 = g1 + color[d].getGreen();
                }
                g1 = g1 / (max);
                for (d = 0; d < max; d++) {
                    b1 = b1 + color[d].getBlue();
                }
                b1 = b1 / (max);
                int sum1 = (a1 << 24) + (r1 << 16) + (g1 << 8) + b1;
                imagen.setColor(sum1, y, x);
            }
        }
        imagen.transformada();
    }

}

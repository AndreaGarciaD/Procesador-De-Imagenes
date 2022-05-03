package paint.modelo;

public class TransformarTonosDeGris extends Transformacion {

    public TransformarTonosDeGris(Imagen img) {
        this.imagen = img;
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
                if (promedio < 50) {
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
                //int b = (rgb) & 0xff;

                rgb = (a << 24) | (0) | r << 16;
                //rgb = (r<<16);
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
        int[][] pixeles = imagen.getPixeles();
        for (int fila = 0; fila < imagen.getAncho() - 2; fila += 3) {
            for (int columna = 0; columna < imagen.getAlto() - 2; columna +=3) {
                int pos1 = pixeles[fila][columna];
                imagen.setColor(pos1, fila, columna);
                imagen.setColor(pos1, fila, columna + 1);
                 imagen.setColor(pos1, fila, columna + 2);
                imagen.setColor(pos1, fila + 1, columna);
                imagen.setColor(pos1, fila + 1, columna + 1);
                 imagen.setColor(pos1, fila + 1, columna + 2);
            }
        }
        imagen.transformada();
    }
        /*int fila = 0;
        int columna = 0;
        int[][] pixeles = imagen.getPixeles();
        do {
            fila += 3;
            columna += 3;
            for (int i = fila; i < fila + 5; i++) {
                for (int j = columna; j < columna + 5; j++) {
                    pixeles[i][j] = pixeles[columna][fila];

                }
            }
        } while (fila <= imagen.getAncho() - 10 || columna <= imagen.getAlto() - 10);

        imagen.transformada();*/
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



    /*
    Obtener los pixeles de una Buffered image
    int[][] pixeles = imagen.getPixeles();
        int rgb = pixeles[0][0];

        int a = (rgb >> 24) & 0xff;
        int r = (rgb>>16) & 0xff;
        int g = (rgb >> 8) & 0xff;
        int b = rgb & 0xff;

        a= 255;
        r= 100 -10;
        g = 150;
        b = 200;

        rgb = (a<<24) | (r<<16) | (g<<8) | b;
        imagen.setColor(rgb, 0, 0);
        imagen.transformada();*/

    private float[][] matriz = {
            {-1, -1, -1},
            {-1, 9, -1},
            {-1, -1, -1}
    };


    public void transformarBlur() {
        int[][] pixeles = imagen.getPixeles();
        for (int i = 0; i < imagen.getAncho() - 2; i += 3) {
            for (int j = 0; j < imagen.getAlto() - 2; j += 3) {
                int a11 = pixeles[i][j];
                int r = (a11 >> 16) & 0x000000ff;
                int g = (a11 >> 8) & 0x000000ff;
                int b = a11 & 0x000000ff;

                int a12 = pixeles[i][j + 1];
                r = (int) (((a12 >> 16) & 0x000000ff) * (0.125));
                g = (int) (((a12 >> 8) & 0x000000ff) * (0.125));
                b = (int) ((a12 & 0x000000ff) * (0.125));
                //imagen.setColor(r+g+b, i, j);
                int a13 = pixeles[i][j + 2];
                r = (a13 >> 16) & 0x000000ff;
                g = (a13 >> 8) & 0x000000ff;
                b = a13 & 0x000000ff;
                int a21 = pixeles[i + 1][j];
                r = ((a21 >> 16) & 0x000000ff) * 2;
                g = ((a21 >> 8) & 0x000000ff) * 2;
                b = (a21 & 0x000000ff) * 2;
                int a22 = pixeles[i + 1][j + 1];
                r = ((a22 >> 16) & 0x000000ff) * 4;
                g = ((a22 >> 8) & 0x000000ff) * 4;
                b = (a22 & 0x000000ff) * 4;
                int a23 = pixeles[i + 1][j + 2];
                r = ((a23 >> 16) & 0x000000ff) * 2;
                g = ((a23 >> 8) & 0x000000ff) * 2;
                b = (a23 & 0x000000ff) * 2;
                int a31 = pixeles[i + 2][j];
                r = (a31 >> 16) & 0x000000ff;
                g = (a31 >> 8) & 0x000000ff;
                b = a31 & 0x000000ff;

                int a32 = pixeles[i + 2][j + 1];
                r = ((a32 >> 16) & 0x000000ff) * 2;
                g = ((a32 >> 8) & 0x000000ff) * 2;
                b = (a32 & 0x000000ff) * 2;
                int a33 = pixeles[i + 2][j + 2];
                r = (a33 >> 16) & 0x000000ff;
                g = (a33 >> 8) & 0x000000ff;
                b = a33 & 0x000000ff;
                //int promedio = (int) (((double) r + (double) g + (double) b)/9);
                /*int promedio = (a11/16 + a12/8 + a13/16 + a21/8 + a22/4 + a23/8 + a31/16 + a32/8 + a33/16);
                //promedio = promedio + promedio*256 + promedio + 256*256;*/

                //imagen.setColor(rgb, i, j);
                int[] vector = {a11, a12, a13, a21, a22, a23, a31, a32, a33};
                int res = ordenar(vector);
                imagen.setColor(res, i + 1, j + 1);
                imagen.setColor(res-10, i, j);
                imagen.setColor(res-10, i, j + 1);
                imagen.setColor(res-10, i, j + 2);
                imagen.setColor(res-10, i + 1, j);
                imagen.setColor(res-10, i + 1, j + 1);
                imagen.setColor(res-10, i + 1, j + 2);
                imagen.setColor(res-10, i + 2, j);
                imagen.setColor(res-10, i + 2, j + 1);
                imagen.setColor(res-10, i + 2, j + 2);
            }
            imagen.transformada();
        }
    }

    private int ordenar(int[] vector) {
        int temporal;
        for (int i = 0; i < vector.length; i++) {
            for (int j = 1; j < (vector.length - i); j++) {
                if (vector[j - 1] > vector[j]) {
                    temporal = vector[j - 1];
                    vector[j - 1] = vector[j];
                    vector[j] = temporal;
                }
            }
        }
        return vector[5];
    }

}

package paint.modelo;

public class Filtros extends Transformacion {

    public Filtros(Imagen img) {
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
            for (int columna = 0; columna < imagen.getAlto() - 2; columna += 3) {
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

}

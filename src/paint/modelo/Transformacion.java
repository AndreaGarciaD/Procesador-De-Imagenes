package paint.modelo;

import java.awt.image.BufferedImage;

public abstract class Transformacion {
    protected Imagen imagen;
    protected BufferedImage biImagen;

    public abstract void transformarGris(); //funciona
    public abstract void transformarAzul(); //funciona
    public abstract void transformarVerde();
    public abstract void transformarEspejo();
}

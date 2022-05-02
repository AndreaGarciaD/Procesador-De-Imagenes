package paint.modelo;

import java.awt.image.BufferedImage;

public abstract class Transformacion {
    protected Imagen imagen;
    protected BufferedImage biImagen;

    public abstract void transformarGris(); //funciona
    public abstract void transformarAzul(); //funciona
    public abstract void transformarVerde(); // funciona
    public abstract void transformarRojo(); //funciona
    public abstract void transformarBN(); // funciona
    public abstract void transformarEspejoVertical(); //funciona
    public abstract void transformarEspejoHorizontal(); //funciona
    public abstract void transformarPixelar();
    public abstract void transformarBlur(); // arreglar
}

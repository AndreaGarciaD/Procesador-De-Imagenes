package paint.modelo;

public abstract class Transformacion {

    protected Imagen imagen;

    public abstract void transformarGris();

    public abstract void transformarAzul();

    public abstract void transformarVerde();

    public abstract void transformarRojo();

    public abstract void transformarBN();

    public abstract void transformarEspejoVertical();

    public abstract void transformarEspejoHorizontal();

    public abstract void transformarPixelar();
    //public abstract void transformarBlur();
}

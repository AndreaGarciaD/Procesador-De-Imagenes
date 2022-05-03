package paint.vista;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import paint.modelo.Imagen;
import paint.modelo.Transformacion;
import paint.modelo.Filtros;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintFrame extends JFrame implements ActionListener {

    private Logger logger = LogManager.getRootLogger();
    private Imagen modelo;
    private PaintPanel panel;

    private JButton btnGris = new JButton("Gris");
    private JButton btnRojo = new JButton("Rojo");
    private JButton btnVerde = new JButton("Verde");
    private JButton btnAzul = new JButton("Azul");
    private JButton btnBN = new JButton("Blanco y negro");
    private JButton btnHorizontal = new JButton("Horizontal");
    private JButton btnVertical = new JButton("Vertical");
    private JButton btnPixelar = new JButton("Pixelado");
    private JButton btnReset = new JButton("Reset");
    private JMenuItem cargarImagen = new JMenuItem("Cargar");
    private JMenuItem salir = new JMenuItem("Salir");

    private int x = 10;
    private int y = 20;

    private JPanel panel_opciones = new JPanel();

    //JButton btnGris = new JButton("Blanco y negro");

    public PaintFrame() {
        setSize(700, 620);
        setLocationRelativeTo(null);
        setVisible(true);
        cargarImagen.addActionListener(this);
        btnGris.addActionListener(this);
        btnRojo.addActionListener(this);
        btnAzul.addActionListener(this);
        btnVerde.addActionListener(this);
        btnBN.addActionListener(this);
        btnHorizontal.addActionListener(this);
        btnVertical.addActionListener(this);
        btnPixelar.addActionListener(this);
        btnReset.addActionListener(this);
        init();
    }

    public void init() {
        modelo = new Imagen(550, 550);
        panel = new PaintPanel(modelo);
        this.add(panel);

        JMenuBar menu = new JMenuBar();
        JMenu archivo = new JMenu("Archivo");
        archivo.add(cargarImagen);
        archivo.add(salir);
        menu.add(archivo);
        this.setJMenuBar(menu);

        panel_opciones.setLayout(null);

        btnGris.setBounds(x, y, 120, 30);
        y += 40;
        btnRojo.setBounds(x, y, 120, 30);
        y += 40;
        btnVerde.setBounds(x, y, 120, 30);
        y += 40;
        btnAzul.setBounds(x, y, 120, 30);
        y += 40;
        btnBN.setBounds(x, y, 120, 30);
        y += 40;
        btnHorizontal.setBounds(x, y, 120, 30);
        y += 40;
        btnVertical.setBounds(x, y, 120, 30);
        y += 40;
        btnPixelar.setBounds(x, y, 120, 30);
        y += 40;
        btnReset.setBounds(x, y, 120, 30);

        panel_opciones.add(btnGris);
        panel_opciones.add(btnRojo);
        panel_opciones.add(btnVerde);
        panel_opciones.add(btnAzul);
        panel_opciones.add(btnBN);
        panel_opciones.add(btnHorizontal);
        panel_opciones.add(btnVertical);
        panel_opciones.add(btnPixelar);
        panel_opciones.add(btnReset);

        panel_opciones.setPreferredSize(new Dimension(140, 130));
        this.add(panel_opciones, BorderLayout.EAST);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cargarImagen) {
            btnHacer_clicked();
        }
        if (e.getSource() == btnGris) {
            btnGris_clicked();
        }
        if (e.getSource() == btnRojo) {
            btnHacer_clicked();
            btnRojo_clicked();
        }
        if (e.getSource() == btnVerde) {
            btnHacer_clicked();
            btnVerde_clicked();
        }
        if (e.getSource() == btnAzul) {
            btnHacer_clicked();
            btnAzul_clicked();
        }
        if (e.getSource() == btnBN) {
            btnHacer_clicked();
            btnBN_clicked();
        }
        if (e.getSource() == btnHorizontal) {
            btnHorizontal_clicked();
        }
        if (e.getSource() == btnVertical) {
            btnVertical_clicked();
        }
        if (e.getSource() == btnPixelar) {
            btnPixelar_clicked();
        }
        if (e.getSource() == btnReset) {
            btnReset_clicked();
        }
        if (e.getSource() == salir) {
            System.exit(0);
        }

    }

    private void btnGris_clicked() {
        Transformacion tonosDeGris = new Filtros(modelo);
        tonosDeGris.transformarGris();
    }

    private void btnRojo_clicked() {
        Transformacion tonosRojo = new Filtros(modelo);
        tonosRojo.transformarRojo();
    }

    private void btnVerde_clicked() {
        Transformacion tonosVerde = new Filtros(modelo);
        tonosVerde.transformarVerde();
    }

    private void btnAzul_clicked() {
        Transformacion tonosRojo = new Filtros(modelo);
        tonosRojo.transformarAzul();
    }

    private void btnBN_clicked() {
        Transformacion tonosBN = new Filtros(modelo);
        tonosBN.transformarBN();
    }

    private void btnHorizontal_clicked() {
        Transformacion espejoHorizontal = new Filtros(modelo);
        espejoHorizontal.transformarEspejoHorizontal();
    }

    private void btnVertical_clicked() {
        Transformacion espejoVertical = new Filtros(modelo);
        espejoVertical.transformarEspejoVertical();
    }

    private void btnPixelar_clicked() {
        Transformacion pixelado = new Filtros(modelo);
        pixelado.transformarPixelar();
    }

    private void btnReset_clicked() {
        modelo.leerDeArchivo("C:\\Pro III imagenes\\MicrosoftTeams-image (2).png");
    }


    private void btnHacer_clicked() {
        logger.debug("Cargando Imagen");
        modelo.leerDeArchivo("C:\\Pro III imagenes\\Saeyoung.jpg");
    }


}

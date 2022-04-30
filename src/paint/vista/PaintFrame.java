package paint.vista;

import paint.modelo.Imagen;
import paint.modelo.Transformacion;
import paint.modelo.TransformarTonosDeGris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintFrame extends JFrame {
    private Imagen modelo;
    private PaintPanel panel;

    public PaintFrame() {
        init();
    }

    public void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Imagen(400,400);
        panel = new PaintPanel(modelo);

        this.getContentPane().add(panel, BorderLayout.CENTER);

        JButton btnHacer = new JButton("Hacer");
        btnHacer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnHacer_clicked();
            }
        });

        this.getContentPane().add(btnHacer, BorderLayout.SOUTH);

        JButton btnGris = new JButton("Gris");
        btnGris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnGris_clicked();
            }
        });

        this.getContentPane().add(btnGris, BorderLayout.EAST);

        this.pack();
    }

    private void btnGris_clicked() {
        Transformacion tonosDeGris = new TransformarTonosDeGris(modelo);
        tonosDeGris.transformarAzul();
    }

    private void btnHacer_clicked() {
        modelo.leerDeArchivo("C:\\Pro III imagenes\\Saeyoung.jpg");
    }
}

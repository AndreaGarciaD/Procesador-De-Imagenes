package paint.vista;

import paint.modelo.Imagen;
import paint.modelo.Transformacion;
import paint.modelo.TransformarTonosDeGris;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaintFrame extends JFrame {
    private Imagen modelo;
    private PaintPanel panel;

    //JButton btnGris = new JButton("Blanco y negro");

    public PaintFrame() {
        //btnGris.setBackground(Color.CYAN);
        //btnGris.setBounds(10,500, 20,20);
        init();
    }

    public void init() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.getContentPane().setLayout(new BorderLayout());

        modelo = new Imagen(550,500);
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

        JButton btnGris = new JButton("Blanco y negro");
        btnGris.setSize(20,20);
        btnGris.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnGris_clicked();
            }
        });

        this.getContentPane().add(btnGris, BorderLayout.EAST);

        JButton btnRojo = new JButton("Rojo");
        btnGris.setBounds(10, 500, 20,20);
        btnRojo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRojo_clicked();
            }
        });

        //this.getContentPane().add(btnRojo, BorderLayout.EAST);
        this.pack();
    }

    private void btnGris_clicked() {
        Transformacion tonosDeGris = new TransformarTonosDeGris(modelo);
        tonosDeGris.transformarBN();
    }

    private void btnRojo_clicked(){
        Transformacion tonosRojo = new TransformarTonosDeGris(modelo);
        tonosRojo.transformarRojo();
    }

    private void btnHacer_clicked() {
        modelo.leerDeArchivo("C:\\Pro III imagenes\\Saeyoung.jpg");
    }
}

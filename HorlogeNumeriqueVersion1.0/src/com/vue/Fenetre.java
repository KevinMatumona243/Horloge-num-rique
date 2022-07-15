package com.vue;

import com.horloge.Horloge;
import com.obeserver.Observateur;

import javax.swing.*;
import java.awt.*;
import java.awt.color.*;
public class Fenetre extends JFrame implements Observateur {
    private JPanel fondFenetre = new JPanel();
    private JLabel label = new JLabel();
    private Horloge horloge;
    public Fenetre(){
        this.setTitle("Horloge");
        this.setSize(200,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        Font policeLabel = new Font("Courrier",Font.BOLD,30);
        label.setFont(policeLabel);
        label.setForeground(Color.GREEN);
        this.horloge = new Horloge();
        this.horloge.addObservateur(new Observateur() {
            @Override
            public void update(String heure) {
                label.setText(heure);
            }
        });
        fondFenetre.add(label,BorderLayout.CENTER);
        fondFenetre.setBackground(Color.BLACK);
        fondFenetre.setVisible(true);
        this.setContentPane(fondFenetre);
        this.setVisible(true);
        this.horloge.executionHorloge();
    }

    @Override
    public void update(String heure) {

    }
}

package com.horloge;
import com.obeserver.Observable;
import com.obeserver.Observateur;

import java.util.ArrayList;
import java.util.Calendar;
public class Horloge implements Observable {
    private Calendar calendar;
    private String heures = "";
    private ArrayList<Observateur> listeObservateur = new ArrayList<>();

    public void executionHorloge(){
        while(true){
            this.calendar = Calendar.getInstance();
            this.heures =
                    ((this.calendar.get(Calendar.HOUR) < 10) ?
                            ("0" + this.calendar.get(Calendar.HOUR)) : this.calendar.get(Calendar.HOUR)) +
                            " : "
                            + ((this.calendar.get(Calendar.MINUTE) < 10) ?
                            ("0" + this.calendar.get(Calendar.MINUTE)) : this.calendar.get(Calendar.MINUTE)) +
                            " : "
                            + ((this.calendar.get(Calendar.SECOND) < 10) ?
                            ("0" + this.calendar.get(Calendar.SECOND)) : this.calendar.get(Calendar.SECOND));
            this.upadateObservateur();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addObservateur(Observateur observateur) {
        listeObservateur.add(observateur);
    }

    @Override
    public void delObservateur() {
        listeObservateur = new ArrayList<>();
    }

    @Override
    public void upadateObservateur() {
        for (Observateur observateur : listeObservateur)
            observateur.update(this.heures);
    }
}

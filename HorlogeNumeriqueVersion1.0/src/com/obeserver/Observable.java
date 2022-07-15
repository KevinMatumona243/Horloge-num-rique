package com.obeserver;

public interface Observable {
    void addObservateur(Observateur observateur);
    void delObservateur();
    void upadateObservateur();
}

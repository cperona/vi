package com.somelier.model;

import java.util.ArrayList;
import java.util.List;

public class ViExpert {
    private ArrayList<Vins> vins = new ArrayList<>();

    public void AddVins(Vins vi) {
        this.vins.add(vi);
    }

    public List<String> getMarques(String tipusVi) {
        List<String> llistaMarques = new ArrayList<>();

        for (Vins vi : vins) {
            if (vi.getTipus().equals(tipusVi)) {
                llistaMarques.add(vi.getMarca());
            }
        }
        return llistaMarques;
    }
}
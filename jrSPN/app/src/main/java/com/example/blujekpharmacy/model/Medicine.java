package com.example.blujekpharmacy.model;

import android.util.Log;

import com.example.blujekpharmacy.R;
import com.example.blujekpharmacy.controller.Login;

import java.io.Serializable;
import java.util.ArrayList;

public class Medicine implements Serializable {

//    public static ArrayList<Medicine> dbMed = new ArrayList<>();
    private int ID;
    private int price;
    private String name;
    private String manufacturer;
    private String image;
    private String desc;

    public Medicine(int ID, String name, String manufacturer, int price, String image, String desc) {
        this.ID = ID;
        this.price = price;
        this.name = name;
        this.manufacturer = manufacturer;
        this.image = image;
        this.desc = desc;
    }

    public Medicine(int price, String name, String manufacturer, String image, String desc) {
        this.price = price;
        this.name = name;
        this.manufacturer = manufacturer;
        this.image = image;
        this.desc = desc;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static void initMedicine(){
        Login.dbMed.add(new Medicine(1,"paramex", "PT mantap", 10000, Integer.toString(R.drawable.paramex), "obat pusing"));
        Login.dbMed.add(new Medicine(2,"tolak angin", "PT bagus", 2000, Integer.toString(R.drawable.tolakangin), "obat masuk angin"));
        Login.dbMed.add(new Medicine(3,"panadol", "PT goodd", 3000, Integer.toString(R.drawable.panadol), "obat demam"));
    }

    public static Medicine getMedicine(int id){
        for (Medicine m : Login.dbMed) {
            if (m.ID == id){
                return m;
            }
        }
        return null;
    }

}



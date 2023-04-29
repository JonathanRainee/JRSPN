package com.example.blujekpharmacy.model;

import android.content.ContentValues;
import android.util.Log;

import com.example.blujekpharmacy.controller.Login;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {

    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private int ID;
    private int userid;
    private int quantity;
    private String date;
    private int gameID;

    public Transaction(int userid, int gameID, int quantity) {
        this.setUserid(userid);
        this.setGameID(gameID);
        this.setQuantity(quantity);
        this.setDate(df.format(new Date()));
    }

    public static void insertTransaction(Transaction trans){
        ContentValues val = new ContentValues();
        Login.transactionList.add(trans);
        return;
    }

    public static ArrayList<Transaction> getTrans(int id){
        ArrayList<Transaction> trans = new ArrayList<>();
        for (Transaction t : Login.transactionList) {
            if(t.userid == id){
                trans.add(t);
            }
        }
        return trans;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getGameID() {return gameID;}

    public void setGameID(int gameID) {this.gameID = gameID;}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

package com.example.blujekpharmacy.model;

import com.example.blujekpharmacy.controller.Login;

public class Game {


    private String homeTeam;
    private String awayTeam;
    private String date;
    private int price;
    private String seatType;

    private int id;

    public Game(String homeTeam, String awayTeam, String date, int price, String seatType, int id) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
        this.price = price;
        this.seatType = seatType;
        this.id = id;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static Game getGameData(int id){
        for (Game g : Login.gameList) {
            if (g.getId() == id){
                return g;
            }
        }
        return null;
    }

    public static void initGame(){
        Login.gameList.add(new Game("Golden State Warriors", "Oklahoma City Thunder", "20-12-2023", 50, "VIP", 1));
        Login.gameList.add(new Game("Cleveland Cavaliers", "Memphis Grizlies", "20-11-2023", 30, "Regular", 2));
        Login.gameList.add(new Game("Brooklyn Nets", "Detroit Piston", "10-12-2023", 50, "IP", 3));
    }
}

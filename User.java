package com.bookzone;

import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String password;
    private int coins;
    private int totalScore;
    private int votes;
    private ArrayList<String> courses;
    private ArrayList<Order> sellOrders;
    private ArrayList<Order> buyOrders;

    public User(String name,String email, String password){

        this.name = name;
        this.email = email;
        this.password = password;
        coins = 100;
        totalScore = 0;
        votes = 0;
        courses = new ArrayList<>();
        sellOrders = new ArrayList<>();
        buyOrders = new ArrayList<>();

    }

    public boolean checkPassword(String password){
        return password.equals(this.password);
    }

    public boolean canAfford(int price){
        return coins >= price;
    }

    public int getScore(){
        if(votes == 0)
            return 0;
        return totalScore/votes;
    }

    public int rateUser(int score){
        totalScore += score;
        votes++;
        return getScore();
    }

    public void addCoins(int coins){this.coins += coins;}

    public boolean removeCoins(int coins){
        if(canAfford(coins)) {
            this.coins -= coins;
            return true;
        }
        return false;
    }

    public void createSellOrder(String name, int price, String type, int conditionScore, ArrayList<String> relatedCourses){
        sellOrders.add(new Order(name,price,type,this,conditionScore,relatedCourses,true));
    }
    public void createBuyOrder(String name, int price, String type, ArrayList<String> relatedCourses){
        buyOrders.add(new Order(name,price,type,this,0,relatedCourses,false));
    }
    public void removeSellOrder(Order order){sellOrders.remove(order);}

    public void removeBuyOrder(Order order){buyOrders.remove(order);}

    public void addCourse(String course){
        if (!courses.contains(course))
            courses.add(course);
    }
    public void removeCourse(String course){courses.remove(course);}

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", coins=" + coins +
                ", score=" + getScore() +
                ", courses=" + courses +
                ", sellOrders=" + sellOrders +
                ", buyOrders=" + buyOrders +
                '}';
    }

    public String getName(){return name;}
    public String getEmail(){return email;}
    public String getPassword(){return password;}
    public int getCoins(){return coins;}
    public ArrayList<Order> getSellOrders(){return sellOrders;}
    public ArrayList<Order> getBuyOrders(){return buyOrders;}
    public int getTotalScore(){return totalScore;}
    public ArrayList<String> getCourses(){return courses;}





    public void setName(String name){this.name = name;}
    public void setEmail(String email){this.email = email;}
    public void setPassword(String password){this.password = password;}
    public void setCoins(int coins){this.coins = coins;}
    public void setSellOrders(ArrayList<Order> orders){sellOrders = orders;}
    public void setBuyOrders(ArrayList<Order> orders){buyOrders = orders;}
    public void setTotalScore(int score){totalScore = score;}



}

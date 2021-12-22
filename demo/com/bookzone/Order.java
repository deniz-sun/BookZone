package com.bookzone;

import java.util.ArrayList;

public class Order {

    private String name;
    private int price;
    private String type;
    private User advertiser;
    private int conditionScore;
    private ArrayList<String> relatedCourses;
    private boolean sellOrder;
    private ArrayList<User> candidates;
    private Transaction transaction;

    public Order(String name, int price, String type, User advertiser, int conditionScore, ArrayList<String> relatedCourses, boolean sellOrder){
        this.name = name;
        this.price = price;
        this.type = type;
        this.advertiser = advertiser;
        this.conditionScore = conditionScore;
        this.relatedCourses = relatedCourses;
        this.sellOrder = sellOrder;
        candidates = new ArrayList<>();
    }

    public void addRelatedCourse(String course){
        if(!relatedCourses.contains(course))
            relatedCourses.add(course);
    }

    public void removeRelatedCourse(String course){relatedCourses.remove(course);}

    public boolean isRelated2Course(String course){
        return relatedCourses.contains(course);
    }

    public void addCandidate(User candidate){
        if (!candidates.contains(candidate))
            candidates.add(candidate);
    }

    public void removeCandidate(User candidate){candidates.remove(candidate);}

    public boolean isCandidate(User candidate){
        return candidates.contains(candidate);
    }

    public void createTransaction(User other){
        if (getTransaction() == null) {
            if (isSellOrder())
                transaction = new Transaction(other, advertiser, this);
            else
                transaction = new Transaction(advertiser, other, this);
        }
    }

    public void removeOrder(){
        for (int i = 0; i < candidates.size(); i++) {
            candidates.get(i).removeOngoing(this);
        }
        if (sellOrder)
            advertiser.removeSellOrder(this);
        else
            advertiser.removeBuyOrder(this);
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", advertiser=" + advertiser.getName() +
                ", conditionScore=" + conditionScore +
                ", relatedCourses=" + relatedCourses +
                ", sellOrder=" + sellOrder +
                ", candidates=" + candidates +
                ", transaction=" + transaction +
                '}';
    }

    public String getName(){return name;}
    public int getPrice(){return price;}
    public String getType() {return type;}
    public User getAdvertiser(){return advertiser;}
    public int getConditionScore(){return conditionScore;}
    public ArrayList<String> getRelatedCourses(){return relatedCourses;}
    public ArrayList<User> getCandidates() {return candidates;}
    public Transaction getTransaction() {return transaction;}

    public boolean isSellOrder() {return sellOrder;}

    public void setName(String name) {this.name = name;}
    public void setPrice(int price) {this.price = price;}
    public void setType(String type) {this.type = type;}
    public void setAdvertiser(User advertiser) {this.advertiser = advertiser;}
    public void setConditionScore(int conditionScore) {this.conditionScore = conditionScore;}
    public void setRelatedCourses(ArrayList<String> relatedCourses) {this.relatedCourses = relatedCourses;}
    public void setSellOrder(boolean sellOrder) {this.sellOrder = sellOrder;}
    public void setCandidates(ArrayList<User> candidates) {this.candidates = candidates;}
    public void setTransaction(Transaction transaction) {this.transaction = transaction;}
}






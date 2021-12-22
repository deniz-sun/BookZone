package com.bookzone;

public class Transaction {
    private User buyer;
    private User seller;
    private Order order;
    private boolean buyerConfirm;
    private boolean sellerConfirm;


    public Transaction(User buyer, User seller, Order order){
        this.buyer = buyer;
        this.seller = seller;
        this.order = order;
        buyerConfirm = false;
        sellerConfirm = false;
    }

    public void buyerConfirm(){buyerConfirm = true;}
    public void buyerConfirmCancel(){buyerConfirm = false;}

    public void sellerConfirm(){sellerConfirm = true;}
    public void sellerConfirmCancel(){sellerConfirm = false;}

    public boolean enactTransaction(){
        if(getConfirmation()&&buyer.canAfford(order.getPrice())) {
            buyer.removeCoins(order.getPrice());
            seller.addCoins(order.getPrice());
            order.removeOrder();
            cancel();
            return true;
        }
        return false;
    }

    public void cancel(){order.setTransaction(null);}

    @Override
    public String toString() {
        return "Transaction{" +
                "buyer=" + buyer.getName() +
                ", seller=" + seller.getName() +
                ", order=" + order.getName() +
                ", buyerConfirm=" + buyerConfirm +
                ", sellerConfirm=" + sellerConfirm +
                '}';
    }

    public User getBuyer() {
        return buyer;
    }
    public Order getOrder() {
        return order;
    }
    public User getSeller() {
        return seller;
    }
    public boolean isBuyerConfirm() {
        return buyerConfirm;
    }
    public boolean isSellerConfirm() {
        return sellerConfirm;
    }
    public boolean getConfirmation(){return buyerConfirm && sellerConfirm && buyer.canAfford(order.getPrice());}
}

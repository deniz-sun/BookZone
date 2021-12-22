import com.bookzone.*;

import java.util.ArrayList;
import java.util.Arrays;

public class BookZoneMain {

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Order> orders = new ArrayList<Order>();
        ArrayList<Transaction> transactions = new ArrayList<Transaction>();

        User baris = new User("Barış Kıcıman","EEE","baris.kiciman@ug.bilkent.edu.tr","k1ngp1n");
        baris.rateUser(9);
        User deniz = new User("Deniz Sun","CS","deniz.sun@ug.bilkent.edu.tr","d3n1z5un");
        deniz.rateUser(8);
        User alper = new User("Alper Bozkurt","CS","alper.bozkurt@ug.bilkent.edu.tr","4lp3rk1r4l");
        alper.rateUser(7);
        User ece = new User("Ece Yaren Gürbüz","CS","ece.gürbüz@ug.bilkent.edu.tr","y4r3nqu1n");
        ece.rateUser(6);

        users.add(baris);
        users.add(deniz);
        users.add(alper);
        users.add(ece);

        orders.add(baris.createBuyOrder("BigJava",32,"Textbook",new ArrayList<String>(Arrays.asList("CS101"))));
        orders.add(baris.createSellOrder("Campbell Biology: Concepts and Connections",28,"Textbook",9,new ArrayList<String>(Arrays.asList("MBG110"))));
        orders.add(ece.createSellOrder("BigJava",30,"Textbook",8,new ArrayList<String>(Arrays.asList("CS101","CS102"))));
        orders.add(ece.createSellOrder("Notes Chapters 7-9",15,"Lecture Notes",8,new ArrayList<String>(Arrays.asList("CS102"))));
        orders.add(ece.createBuyOrder("Discrete Mathematics and its Applications",35,"Textbook",new ArrayList<String>(Arrays.asList("MATH132"))));
        orders.add(alper.createSellOrder("Calculus, Metric Version",40,"Textbook",6,new ArrayList<String>(Arrays.asList("MATH101","MATH102"))));
        orders.add(alper.createSellOrder("Lab Notes",20,"Lecture Notes",5,new ArrayList<String>(Arrays.asList("CS102"))));
        orders.add(alper.createSellOrder("BigJava",29,"Textbook",7,new ArrayList<String>(Arrays.asList("CS101","CS102"))));
        orders.add(deniz.createSellOrder("Campbell Biology: Concepts and Connections",20,"Textbook",7,new ArrayList<String>(Arrays.asList("MBG110"))));
        orders.add(deniz.createSellOrder("Old Exams",25,"Textbook",8,new ArrayList<String>(Arrays.asList("MBG110"))));
        orders.add(deniz.createSellOrder("Notes Chapters 3-7",35,"Lecture Notes",3,new ArrayList<String>(Arrays.asList("MBG110"))));

        new login_page(users,orders,transactions);

    }

}

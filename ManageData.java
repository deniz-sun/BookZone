package com.bookzone;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import io.netty.handler.ssl.util.KeyManagerFactoryWrapper;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class ManageData {
    private final Firestore db;
    String name, email, phone, password;
    User user = new User("deniz", "deniz@gmail.com", "bookzone");
    String bookName, course;

    ManageData(Firestore db, String name, String email, String phone, String password){
        this.db = db;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
    /*
    ManageData(Firestore db, String email, String password){
        this.db = db;
        this.email = email;
        this.password = password;
    }

     */
    ManageData(Firestore db, String bookName, String course){
        this.db = db;
        this.bookName = bookName;
        this.course = course;
    }


    Map<String, Object> addUserDocsAsMap() throws ExecutionException, InterruptedException {
        Map<String, Object> docData = new HashMap<>();

        docData.put("name", name);
        docData.put("email", email);
        docData.put("phone", phone);
        docData.put("password", password);

        ApiFuture<WriteResult> future = db.collection("users").document(name).set(docData);
        System.out.println("Update time: " + future.get().getUpdateTime());
        return docData;
    }

    Map<String, Object> addBookDocsAsMap() throws ExecutionException, InterruptedException {
        Map<String, Object> docData = new HashMap<>();

        docData.put("name", bookName);
        docData.put("course", course);


        ApiFuture<WriteResult> future = db.collection("books").document(bookName).set(docData);
        System.out.println("Update time: " + future.get().getUpdateTime());
        return docData;
    }


    // ?? CollectionReference collectionReference = FirestoreClient.getFirestore().collection(getCollectionPath());

    public boolean checkUsers(Firestore db, String inputEmail, String inputPassword) throws ExecutionException, InterruptedException {
        DocumentReference docRefEmail = db.collection("users").document(inputEmail);
     //   DocumentReference docRefPass = db.collection("users").document(password);


        ApiFuture<DocumentSnapshot> futureEmail = docRefEmail.get();
      //  ApiFuture<DocumentSnapshot> futurePass = docRefPass.get();


        DocumentSnapshot document1 = futureEmail.get();
      //  DocumentSnapshot document2 = futurePass.get();

        User user = null;
        if (document1.exists()) {
            user = document1.toObject(User.class);
            System.out.println(user);
            System.out.println("Document data: " + document1.getData());

            return password.equals(inputPassword);
        }
        else {
            System.out.println("No user with matching data");
        }
        return false;

    }







}

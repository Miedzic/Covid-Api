package com.example.SpringFirstProject.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

//CRUD operations
@Service
public class CountryService {

    public static final String COL_NAME="Country";




    public void saveCountryDetails(Country country) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).add(country).get();
        System.out.println(documentReference.getPath());
    }

    public Country getCountryDetails(String name) throws InterruptedException, ExecutionException, TimeoutException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = future.get();
        Country country = null;

        if(document.exists()) {
            country = document.toObject(Country.class);
            return country;
        }else {
            return null;
        }
    }

    public String updateCountryDetails(Country country) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document(country.getName()).set(country);
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public String deleteCountry(String name) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(name).delete();
        return "Document with Country ID "+name+" has been deleted";
    }

}
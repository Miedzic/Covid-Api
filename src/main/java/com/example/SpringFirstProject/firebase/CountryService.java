package com.example.SpringFirstProject.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

//CRUD operations
@Service
public class CountryService {

    public static final String COL_NAME="Country";




    public void saveCountryDetails(Country country) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).add(country).get();
        System.out.println(documentReference.getPath());
    }

    public List<Country> getCountryDetails(String name) throws InterruptedException, ExecutionException, TimeoutException {

        Firestore dbFirestore = FirestoreClient.getFirestore();
        return dbFirestore.collection(COL_NAME).whereEqualTo("name",name).get().get().getDocuments().stream()
                .map(queryDocumentSnapshot -> new Country(queryDocumentSnapshot.getData().get("name").toString(),
                        (long)queryDocumentSnapshot.getData().get("infected"),
                        (long)queryDocumentSnapshot.getData().get("recovered"),
                        (long)queryDocumentSnapshot.getData().get("deceased"),
                        queryDocumentSnapshot.getData().get("sourceLastUpdate").toString(),
                        (long)queryDocumentSnapshot.getData().get("tested"),
                        (String) queryDocumentSnapshot.getData().get("countryImgURL")

                        )
                ).collect(Collectors.toList());

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
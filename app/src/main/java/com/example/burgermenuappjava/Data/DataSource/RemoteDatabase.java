package com.example.burgermenuappjava.Data.DataSource;

import androidx.annotation.NonNull;

import com.example.burgermenuappjava.Data.Model.MenuItemEntity;
import com.example.burgermenuappjava.Utility.Result;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class RemoteDatabase implements DataBaseClient {

    private final FirebaseFirestore firestore = FirebaseFirestore.getInstance();

    @Override
    public void getAllMenuItems(ResultCallback<List<MenuItemEntity>> callback) {
        {
            firestore.collection("menuItems")
                    .get()
                    .addOnSuccessListener(snapshot -> {
                        List<MenuItemEntity> list = new ArrayList<>();
                        for (DocumentSnapshot doc : snapshot.getDocuments()) {
                            MenuItemEntity item = doc.toObject(MenuItemEntity.class);
                            if (item != null) {
                                list.add(item);
                            }
                        }
                        callback.onResult(Result.success(list));
                    })
                    .addOnFailureListener(e -> {
                        callback.onResult(Result.failure(e));
                    });
        }
    }
}
package com.example.burgermenuappjava.Domain.RepoInterface;


import com.example.burgermenuappjava.Domain.Entity.MenuItem;
import com.example.burgermenuappjava.Utility.Result;

import java.util.List;

public interface MenuRepository {
    void fetchMenu(ResultCallback<List<MenuItem>> callback);

    interface ResultCallback<T> {
        void onResult(Result<T> result);
    }
}
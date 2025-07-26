package com.example.burgermenuappjava.Data.DataSource;


import com.example.burgermenuappjava.Data.Model.MenuItemEntity;
import com.example.burgermenuappjava.Utility.Result;

import java.util.List;

public interface DataBaseClient {
    void getAllMenuItems(ResultCallback<List<MenuItemEntity>> callback);

    interface ResultCallback<T> {
        void onResult(Result<T> result);
    }
}

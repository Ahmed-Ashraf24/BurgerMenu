package com.example.burgermenuappjava.Data.Repository;


import com.example.burgermenuappjava.Data.DataSource.DataBaseClient;
import com.example.burgermenuappjava.Data.DataSource.DataBaseClient.ResultCallback;
import com.example.burgermenuappjava.Data.Mapper.MenuMapper;
import com.example.burgermenuappjava.Data.Model.MenuItemEntity;
import com.example.burgermenuappjava.Domain.Entity.MenuItem;
import com.example.burgermenuappjava.Domain.RepoInterface.MenuRepository;
import com.example.burgermenuappjava.Utility.Result;

import java.util.List;

public class MenuRepositoryImpl implements MenuRepository {

    private final DataBaseClient databaseClient;

    public MenuRepositoryImpl(DataBaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    @Override
    public void fetchMenu(final ResultCallback<List<MenuItem>> callback) {
        databaseClient.getAllMenuItems(new DataBaseClient.ResultCallback<List<MenuItemEntity>>() {
            @Override
            public void onResult(Result<List<MenuItemEntity>> result) {
                if (result.isSuccess()) {
                    List<MenuItem> menuItems = MenuMapper.toDomainList(result.getData());
                    callback.onResult(Result.success(menuItems));
                } else {
                    callback.onResult(Result.failure(result.getException()));
                }
            }
        });
    }
}

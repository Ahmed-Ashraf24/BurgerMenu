package com.example.burgermenuappjava.Presentation.ViewModel;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.burgermenuappjava.Data.DataSource.DataBaseClient;
import com.example.burgermenuappjava.Data.DataSource.RemoteDatabase;
import com.example.burgermenuappjava.Data.Mapper.MenuUIMapper;
import com.example.burgermenuappjava.Data.Repository.MenuRepositoryImpl;
import com.example.burgermenuappjava.Domain.Entity.MenuItem;
import com.example.burgermenuappjava.Domain.UseCase.GetMenuUseCase;
import com.example.burgermenuappjava.Utility.Result;
import com.example.burgermenuappjava.Utility.UiMenuItem;

import java.util.List;

public class MenuViewModel extends ViewModel {

    private final MutableLiveData<List<UiMenuItem>> menuItems = new MutableLiveData<>();
    private final MutableLiveData<String> error = new MutableLiveData<>();

    private final GetMenuUseCase useCase;

    public MenuViewModel() {
        RemoteDatabase dbClient = new RemoteDatabase();
        MenuRepositoryImpl repository = new MenuRepositoryImpl(dbClient);
        useCase = new GetMenuUseCase(repository);
        fetchMenu();
    }

    private void fetchMenu() {
        useCase.execute(new MenuRepositoryImpl.ResultCallback<List<MenuItem>>() {
            @Override
            public void onResult(Result<List<MenuItem>> result) {
                if (result.isSuccess()) {
                    List<UiMenuItem> uiList = MenuUIMapper.toUIList(result.getData());
                    menuItems.postValue(uiList);
                } else {
                    Throwable exception = result.getException();
                    if (exception != null) {
                        error.postValue(exception.getMessage());
                    } else {
                        error.postValue("Unknown error occurred");
                    }
                }
            }
        });
    }

    public LiveData<List<UiMenuItem>> getMenuItems() {
        return menuItems;
    }

    public LiveData<String> getError() {
        return error;
    }
}

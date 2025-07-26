package com.example.burgermenuappjava.Domain.UseCase;

import com.example.burgermenuappjava.Domain.Entity.MenuItem;
import com.example.burgermenuappjava.Domain.RepoInterface.MenuRepository;

import java.util.List;

public class GetMenuUseCase {

    private final MenuRepository repository;

    public GetMenuUseCase(MenuRepository repository) {
        this.repository = repository;
    }

    public void execute(MenuRepository.ResultCallback<List<MenuItem>> callback) {
        repository.fetchMenu(callback);
    }
}
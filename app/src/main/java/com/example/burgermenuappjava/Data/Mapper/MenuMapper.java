package com.example.burgermenuappjava.Data.Mapper;


import com.example.burgermenuappjava.Data.Model.MenuItemEntity;
import com.example.burgermenuappjava.Domain.Entity.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuMapper {

    public static MenuItem toDomain(MenuItemEntity entity) {
        return new MenuItem(
                entity.getName(),
                entity.getPrice(),
                entity.getCategory(),
                entity.isAvailable()
        );
    }

    public static List<MenuItem> toDomainList(List<MenuItemEntity> entities) {
        List<MenuItem> domainList = new ArrayList<>();
        for (MenuItemEntity entity : entities) {
            domainList.add(toDomain(entity));
        }
        return domainList;
    }
}
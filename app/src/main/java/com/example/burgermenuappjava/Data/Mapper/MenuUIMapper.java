package com.example.burgermenuappjava.Data.Mapper;

import com.example.burgermenuappjava.Domain.Entity.MenuItem;
import com.example.burgermenuappjava.R;
import com.example.burgermenuappjava.Utility.UiMenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuUIMapper {

    private static int getImageResourceForName(String name) {
        switch (name.toLowerCase()) {
            case "double whopper":
                return R.drawable.double_whopper;
            case "steakhouse xl":
                return R.drawable.steakhouse_xl;
            case "chicken steakhouse":
                return R.drawable.chicken_steakhouse;
            case "steakhouse":
                return R.drawable.steakhouse;
            case "quattro cheese grill":
                return R.drawable.quattro_cheese_grill;
            case "quattro cheese chicken":
                return R.drawable.quattro_cheese_chicken;
            default:
                return R.drawable.placeholder_burger;
        }
    }

    public static List<UiMenuItem> toUIList(List<MenuItem> domainList) {
        List<UiMenuItem> uiList = new ArrayList<>();
        for (int i = 0; i < domainList.size(); i++) {
            MenuItem item = domainList.get(i);
            uiList.add(new UiMenuItem(
                    i,
                    item.getName(),
                    item.getPrice(),
                    getImageResourceForName(item.getName()),
                    0
            ));
        }
        return uiList;
    }
}
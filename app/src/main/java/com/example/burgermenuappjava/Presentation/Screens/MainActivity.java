package com.example.burgermenuappjava.Presentation.Screens;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.burgermenuappjava.Presentation.ViewModel.MenuViewModel;
import com.example.burgermenuappjava.R;
import com.example.burgermenuappjava.Utility.MenuAdapter;
import com.example.burgermenuappjava.Utility.UiMenuItem;
import com.example.burgermenuappjava.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MenuAdapter menuAdapter;
    private final List<UiMenuItem> uiMenuItems = new ArrayList<>();
    private final MenuViewModel menuViewModel = new MenuViewModel();
    private double total = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupRecyclerView();
        setupClickListeners();
    }
    private void setupRecyclerView() {
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        binding.rvMenuItems.setLayoutManager(layoutManager);

        menuAdapter = new MenuAdapter(uiMenuItems, (menuItem, action) -> {
            if (action == MenuAdapter.Action.INCREASE) {
                menuItem.setQuantity(menuItem.getQuantity() + 1);
                updateTotalPrice();
            } else if (action == MenuAdapter.Action.DECREASE) {
                if (menuItem.getQuantity() > 0) {
                    menuItem.setQuantity(menuItem.getQuantity() - 1);
                    updateTotalPrice();
                }
            }
        });

        binding.rvMenuItems.setAdapter(menuAdapter);

        menuViewModel.getMenuItems().observe(this, new Observer<List<UiMenuItem>>() {
            @Override
            public void onChanged(List<UiMenuItem> uiItemList) {
                uiMenuItems.clear();
                uiMenuItems.addAll(uiItemList);
                menuAdapter.notifyDataSetChanged();
            }
        });
    }

    private void setupClickListeners() {
        // Category tabs
        findViewById(R.id.tab_best).setOnClickListener(v -> selectTab((TextView) v));
        findViewById(R.id.tab_new).setOnClickListener(v -> selectTab((TextView) v));
        findViewById(R.id.tab_offers).setOnClickListener(v -> selectTab((TextView) v));
        findViewById(R.id.tab_cheese).setOnClickListener(v -> selectTab((TextView) v));

        // Search button
        findViewById(R.id.iv_search).setOnClickListener(v -> {
            // Handle search action
        });

        // Cart total click
        binding.bottomLayout.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "الحساب الكلي : " + total, Toast.LENGTH_LONG).show();
        });
    }

    private void selectTab(TextView selectedTab) {
        TextView[] tabs = new TextView[]{
                findViewById(R.id.tab_best),
                findViewById(R.id.tab_new),
                findViewById(R.id.tab_offers),
                findViewById(R.id.tab_cheese)
        };

        for (TextView tab : tabs) {
            if (tab == selectedTab) {
                tab.setBackgroundResource(R.drawable.selected_tab_bg);
                tab.setTextColor(getResources().getColor(R.color.selected_tab_text, getTheme()));
            } else {
                tab.setBackgroundResource(R.drawable.unselected_tab_bg);
                tab.setTextColor(getResources().getColor(R.color.unselected_tab_text, getTheme()));
            }
        }
    }

    private void updateTotalPrice() {
        total = 0.0;
        for (UiMenuItem item : uiMenuItems) {
            total += item.getPrice() * item.getQuantity();
        }

        binding.tvTotalPrice.setText(String.format("%.2f SAR", total));
        menuAdapter.notifyDataSetChanged();
    }
}
package com.example.burgermenuappjava.Utility;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.burgermenuappjava.R;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuViewHolder> {

    public interface OnQuantityChangedListener {
        void onQuantityChanged(UiMenuItem item, Action action);
    }

    public enum Action {
        INCREASE, DECREASE
    }

    private final List<UiMenuItem> uiMenuItems;
    private final OnQuantityChangedListener onQuantityChanged;

    public MenuAdapter(List<UiMenuItem> uiMenuItems, OnQuantityChangedListener listener) {
        this.uiMenuItems = uiMenuItems;
        this.onQuantityChanged = listener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.bind(uiMenuItems.get(position));
    }

    @Override
    public int getItemCount() {
        return uiMenuItems.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivFoodImage;
        private final TextView tvFoodName;
        private final TextView tvPrice;
        private final TextView tvQuantity;
        private final ImageView ivMinus;
        private final ImageView ivPlus;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFoodImage = itemView.findViewById(R.id.iv_food_image);
            tvFoodName = itemView.findViewById(R.id.tv_food_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvQuantity = itemView.findViewById(R.id.tv_quantity);
            ivMinus = itemView.findViewById(R.id.iv_minus);
            ivPlus = itemView.findViewById(R.id.iv_plus);
        }

        public void bind(UiMenuItem item) {
            ivFoodImage.setImageResource(item.getImageRes());
            tvFoodName.setText(item.getName());
            tvPrice.setText(String.format("%.2f S...", item.getPrice()));
            tvQuantity.setText(String.valueOf(item.getQuantity()));

            ivPlus.setOnClickListener(v -> onQuantityChanged.onQuantityChanged(item, Action.INCREASE));
            ivMinus.setOnClickListener(v -> onQuantityChanged.onQuantityChanged(item, Action.DECREASE));

            ivMinus.setAlpha(item.getQuantity() > 0 ? 1.0f : 0.5f);
            ivMinus.setClickable(item.getQuantity() > 0);
        }
    }
}

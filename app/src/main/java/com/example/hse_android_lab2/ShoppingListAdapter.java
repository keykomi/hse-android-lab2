package com.example.hse_android_lab2;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder> {
    private static ArrayList<String> mDataset;

    public static class ShoppingListViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public Button deleteButton;

        public ShoppingListViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.list_item_textview);
            deleteButton = v.findViewById(R.id.buttonDelete);
        }
    }

    public ShoppingListAdapter(ArrayList<String> myDataset) {
        mDataset = myDataset;
    }

    @Override
    public ShoppingListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.shopping_list_item, parent, false);
        return new ShoppingListViewHolder(v);
    }



    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public void onBindViewHolder(ShoppingListViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        String currentItem = mDataset.get(position);
        holder.textView.setText(currentItem);

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDataset.remove(position);
                notifyItemRemoved(position);
            }
        });
    }

}

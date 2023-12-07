package com.example.hse_android_lab2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> shoppingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shoppingList = new ArrayList<>();

        recyclerView = findViewById(R.id.shopping_list);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ShoppingListAdapter(shoppingList);
        recyclerView.setAdapter(mAdapter);

        final EditText newItemEditText = findViewById(R.id.new_item_edittext);
        Button addButton = findViewById(R.id.add_button);
        Button addButton2 = findViewById(R.id.add_button2);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = newItemEditText.getText().toString();
                if (!newItem.isEmpty()) {
                    shoppingList.add(newItem);
                    mAdapter.notifyDataSetChanged();
                    newItemEditText.setText("");
                }
            }
        });
        addButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shoppingList.clear();
                mAdapter.notifyDataSetChanged();
            }
        });
    }


}

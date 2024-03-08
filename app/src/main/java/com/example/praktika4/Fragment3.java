package com.example.praktika4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Fragment3 extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_3, container, false);
        RecyclerViewAdapter adapter;
        adapter = new RecyclerViewAdapter(requireContext(), generateItemList());
        RecyclerView itemsList = view.findViewById(R.id.item_rec);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        itemsList.setLayoutManager(layoutManager);
        itemsList.setAdapter(adapter);
        adapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Item item) {
                Toast.makeText(getContext(), "List item clicked", Toast.LENGTH_SHORT).show();
                Log.d("MyApp", "List item clicked");
            }
        });



        return view;
    }
    private List<Item> generateItemList() {
        List<Item> items = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            String elementName = "Элемент " + i;
            items.add(new Item(elementName, R.drawable.avatar2));
        }
        return items;
    }
}
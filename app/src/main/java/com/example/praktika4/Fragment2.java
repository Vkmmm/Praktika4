package com.example.praktika4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;


public class Fragment2 extends Fragment {
    private static final String TAG = "MyApp";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ListView itemsList;
        MyAdapterListView adapter;
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        itemsList = view.findViewById(R.id.itemsList);
        adapter = new MyAdapterListView(requireContext(), R.layout.list_item, generateItemList());
        itemsList.setAdapter(adapter);
        itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getContext(), "List item clicked", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "List item clicked");
            }
        });
        return view;
    }
    private List<Item> generateItemList() {
        List<Item> items = new ArrayList<>();
        for (int i = 1; i <= 200; i++) {
            String elementName = "Элемент " + i;
            items.add(new Item(elementName, R.drawable.avatar1));
        }
        return items;
    }
}
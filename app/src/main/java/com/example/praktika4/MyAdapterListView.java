package com.example.praktika4;

import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class MyAdapterListView extends ArrayAdapter<Item> {
    private LayoutInflater inflater;
    private int layout;
    private List<Item> items;

    public MyAdapterListView(Context context, int resource,
                             List<Item> items) {
        super(context, resource, items);
        this.items = items;
        this.layout = resource;
        this.inflater = LayoutInflater.from(context);
    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {
        View view = inflater.inflate(this.layout, parent, false);
        TextView textView = view.findViewById(R.id.textView);
        ImageView imageView = view.findViewById(R.id.imageView);
        Item item = items.get(position);
        textView.setText(item.getText());
        imageView.setImageResource(item.getImageResource());
        return view;
    }
}


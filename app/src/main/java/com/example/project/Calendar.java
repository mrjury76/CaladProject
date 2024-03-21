package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Calendar extends Fragment {

    Button add, delete;
    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calendar, container, false);
        ArrayList<Item_Modal> arrayList =new ArrayList<>();
        arrayList.add(new Item_Modal(R.drawable.logo,"Broccoli","100g"));
        arrayList.add(new Item_Modal(R.drawable.logo,"Potato","200g"));
        arrayList.add(new Item_Modal(R.drawable.logo,"Apple","2pc"));
        arrayList.add(new Item_Modal(R.drawable.logo,"Lime","30g"));

        add = view.findViewById(R.id.bt_add);
        delete = view.findViewById(R.id.bt_delete);
        recyclerView = view.findViewById(R.id.rv_items);

        Intent intentAdd = new Intent (getActivity(), AddActivity.class);
        Intent intentDelete = new Intent(getActivity(), DeleteActivity.class);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentAdd);
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentDelete);
            }
        });

        Item_Adapter adapter=new Item_Adapter(getActivity(), arrayList);

        recyclerView.setAdapter(adapter);


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);


        //Linear Layout Horizontal
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,true);
//        recyclerView.setLayoutManager(linearLayoutManager);

        //Grid Layout
//        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
//        recyclerView.setLayoutManager(gridLayoutManager);

        //Staggered Layout
//         StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL );
//        recyclerView.setLayoutManager(staggeredGridLayoutManager);


        return view;
    }
}

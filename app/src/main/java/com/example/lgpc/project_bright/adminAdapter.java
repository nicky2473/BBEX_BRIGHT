package com.example.lgpc.project_bright;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by LGPC on 2018-10-21.
 */

public class adminAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvMoveFloor;

        MyViewHolder(View view) {
            super(view);
            tvMoveFloor = view.findViewById(R.id.move_to_floor);

            tvMoveFloor.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view == tvMoveFloor) {
                ((AdminActivity)AdminActivity.mAdminContext).menuSelect(tvMoveFloor.getText().toString());
            }
        }
    }

    private ArrayList<MenuInfo> menuInfoArrayList;
    adminAdapter(ArrayList<MenuInfo> menuInfoArrayList) {
        this.menuInfoArrayList = menuInfoArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.move_floor, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.tvMoveFloor.setText(menuInfoArrayList.get(position).moveFloor);
    }

    @Override
    public int getItemCount() {
        return menuInfoArrayList.size();
    }
}

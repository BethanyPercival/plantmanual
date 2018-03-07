package com.bethanypercival.rxjavatestapp.plantList;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bethanypercival.rxjavatestapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by beth_ on 07/03/2018.
 */

public class PlantListRecyclerAdapter extends RecyclerView.Adapter<PlantListRecyclerAdapter.PlantListViewHolder> {
    @Override
    public PlantListRecyclerAdapter.PlantListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(PlantListRecyclerAdapter.PlantListViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class PlantListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageViewPlant)
        ImageView imageViewPlant;

        @BindView(R.id.textViewName)
        TextView name;

        @BindView(R.id.textViewLatinName)
        TextView latinName;

        public PlantListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

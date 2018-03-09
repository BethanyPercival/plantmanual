package com.bethanypercival.rxjavatestapp.plantList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bethanypercival.rxjavatestapp.R;
import com.bethanypercival.rxjavatestapp.model.PlantOverview;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by beth_ on 07/03/2018.
 */

public class PlantListRecyclerAdapter extends RecyclerView.Adapter<PlantListRecyclerAdapter.PlantListViewHolder> {

    private List<PlantOverview> plantOverviewList;

    @Override
    public PlantListRecyclerAdapter.PlantListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_plant_overview, parent, false);
        return new PlantListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(PlantListRecyclerAdapter.PlantListViewHolder holder, int position) {
        PlantOverview plantOverview = plantOverviewList.get(position);
        holder.setName(plantOverview.getName());
        holder.setBotanicalName(plantOverview.getBotanicalName());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public PlantListRecyclerAdapter(List<PlantOverview> plantOverviewList) {
        this.plantOverviewList = plantOverviewList;
    }

    public class PlantListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageViewPlant)
        ImageView imageViewPlant;

        @BindView(R.id.textViewName)
        TextView name;

        @BindView(R.id.textViewLatinName)
        TextView botanicalName;

        public void setImageViewPlant(ImageView imageViewPlant) {
            this.imageViewPlant = imageViewPlant;
        }

        public void setName(String name) {
            this.name.setText(name);
        }

        public void setBotanicalName(String botanicalName) {
            this.botanicalName.setText(botanicalName);
        }

        public PlantListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

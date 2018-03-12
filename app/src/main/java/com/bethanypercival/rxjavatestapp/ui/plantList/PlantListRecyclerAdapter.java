package com.bethanypercival.rxjavatestapp.ui.plantList;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bethanypercival.rxjavatestapp.R;
import com.bethanypercival.rxjavatestapp.model.PlantOverview;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by beth_ on 07/03/2018.
 */

public class PlantListRecyclerAdapter extends RecyclerView.Adapter<PlantListRecyclerAdapter.PlantListViewHolder> {

    private List<PlantOverview> plantOverviewList;
    private IPlantListPresenter presenter;

    public PlantListRecyclerAdapter(List<PlantOverview> plantOverviewList, IPlantListPresenter presenter) {
        this.plantOverviewList = plantOverviewList;
        this.presenter = presenter;
    }

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
        holder.setImageViewPlant(plantOverview.getImageUrl());
    }

    @Override
    public int getItemCount() {
        if(plantOverviewList != null) {
            return plantOverviewList.size();
        }
        return 0;
    }

    public class PlantListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.imageViewPlant)
        ImageView imageViewPlant;

        @BindView(R.id.textViewName)
        TextView name;

        @BindView(R.id.textViewLatinName)
        TextView botanicalName;

        public PlantListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    presenter.onListItemClicked(getName());
                }
            });
        }

        public void setImageViewPlant(String imageURL) {
            Picasso.get().load(imageURL).into(imageViewPlant);
        }

        public void setName(String name) {
            this.name.setText(name);
        }

        public String getName() {
            return name.getText().toString();
        }

        public void setBotanicalName(String botanicalName) {
            this.botanicalName.setText(botanicalName);
        }
    }
}

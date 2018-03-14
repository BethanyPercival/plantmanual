package com.bethanypercival.plantmanual.ui.plantList;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bethanypercival.plantmanual.R;
import com.bethanypercival.plantmanual.model.PlantOverview;
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
    private Context context;

    public PlantListRecyclerAdapter(List<PlantOverview> plantOverviewList, IPlantListPresenter presenter, Context context) {
        this.plantOverviewList = plantOverviewList;
        this.presenter = presenter;
        this.context = context;
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
        if (plantOverviewList != null) {
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
        @BindView(R.id.imageViewFavourite)
        ImageView imageViewFavourite;

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

        @OnClick(R.id.imageViewFavourite)
        public void onClickFavourite() {
            animateImageView(imageViewFavourite);
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

        private void animateImageView(final ImageView v) {
            final int inactive = context.getResources().getColor(R.color.greyInactive);
            final int active = context.getResources().getColor(R.color.redFavourite);

            final ValueAnimator colorAnim = ObjectAnimator.ofFloat(0f, 1f);
            colorAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    float mul = (Float) animation.getAnimatedValue();
                    int alphaOrange = adjustAlpha(active, mul);
                    v.setColorFilter(alphaOrange, PorterDuff.Mode.SRC_ATOP);
                    if (mul == 0.0) {
                        v.setColorFilter(null);
                    }
                }
            });

            colorAnim.setDuration(1500);
            colorAnim.setRepeatCount(2);
            colorAnim.start();
        }

        private int adjustAlpha(int color, float factor) {
            int alpha = Math.round(Color.alpha(color) * factor);
            int red = Color.red(color);
            int green = Color.green(color);
            int blue = Color.blue(color);
            return Color.argb(alpha, red, green, blue);
        }
    }
}

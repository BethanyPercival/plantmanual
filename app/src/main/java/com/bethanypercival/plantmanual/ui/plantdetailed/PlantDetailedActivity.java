package com.bethanypercival.plantmanual.ui.plantdetailed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bethanypercival.plantmanual.R;
import com.bethanypercival.plantmanual.model.PlantDetailed;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bethanypercival.plantmanual.ui.plantList.PlantListActivity.EXTRA_NAME;

/**
 * Created by bethanypercival on 12/03/2018.
 */

public class PlantDetailedActivity extends AppCompatActivity implements IPlantDetailedView {

    private IPlantDetailedPresenter presenter;

    @BindView(R.id.textViewName)
    TextView textViewName;
    @BindView(R.id.textViewBotanicalName)
    TextView textViewBotanicalName;
    @BindView(R.id.textViewAlsoKnownAs)
    TextView textViewOtherName;
    @BindView(R.id.imageViewPlant)
    ImageView imageViewPlant;
    @BindView(R.id.textViewDescription)
    TextView textViewDescription;
    @BindView(R.id.textViewUses)
    TextView textViewUses;
    @BindView(R.id.textViewPropagation)
    TextView textViewPropagation;
    @BindView(R.id.textViewSoil)
    TextView textViewSoil;
    @BindView(R.id.textViewClimate)
    TextView textViewClimate;
    @BindView(R.id.textViewHealth)
    TextView textViewHealth;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.textViewReadMore)
    TextView textViewReadMore;
    @BindView(R.id.constraintLayoutDetails)
    ConstraintLayout constraintLayoutDetails;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_detailed);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        initialisePresenter();
        presenter.onViewReady(getIntent().getStringExtra(EXTRA_NAME));
    }

    @Override
    public void populateFields(final PlantDetailed details) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textViewName.setText(details.getName());
                textViewBotanicalName.setText(details.getBotanicalName());
                textViewOtherName.setText(details.getOtherName());
                Picasso.get().load(details.getImageUrl()).into(imageViewPlant);
                textViewDescription.setText(details.getDescription());
                textViewUses.setText(details.getUses());
                textViewPropagation.setText(details.getPropagation());
                textViewSoil.setText(details.getSoil());
                textViewClimate.setText(details.getClimate());
                textViewHealth.setText(details.getHealth());
            }
        });
    }

    @Override
    public void showMoreDetails() {
        constraintLayoutDetails.setVisibility(View.VISIBLE);
        textViewReadMore.setText(getString(R.string.item_read_less));
    }

    @Override
    public void hideMoreDetails() {
        constraintLayoutDetails.setVisibility(View.GONE);
        textViewReadMore.setText(getString(R.string.item_read_more));
    }

    @OnClick(R.id.constraintLayoutReadMore)
    public void readMoreClicked() {
        presenter.readMoreClicked(textViewReadMore.getText().toString(), this);
    }

    private void initialisePresenter() {
        presenter = new PlantDetailedPresenter(this, new PlantDetailedData());
    }
}

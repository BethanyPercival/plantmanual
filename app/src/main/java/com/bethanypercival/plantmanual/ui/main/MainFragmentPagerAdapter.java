package com.bethanypercival.plantmanual.ui.main;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bethanypercival.plantmanual.R;
import com.bethanypercival.plantmanual.ui.main.plantList.PlantListFragment;
import com.bethanypercival.plantmanual.ui.main.plantrandom.PlantRandomFragment;

/**
 * Created by bethanypercival on 13/03/2018.
 */

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public MainFragmentPagerAdapter(Context context, FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PlantListFragment();

            case 1:
                return new PlantRandomFragment();

            default:
                return new PlantListFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.item_all_plants);

            case 1:
                return context.getString(R.string.item_random_plant);

            default:
                return null;
        }
    }
}

package com.app.matrix_natali.ui.main;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.app.matrix_natali.R;
import com.app.matrix_natali.data.model.DataObjectCategory;

public class MainPagerFragment extends Fragment implements ViewPager2.PageTransformer {

    private final DataObjectCategory[] mData;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public MainPagerFragment(DataObjectCategory[] viewModel){
        this.mData = viewModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_item_list, container, false);
    }


    @SuppressLint("NewApi")
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
    //   setFragment();
        startAllCategoriesFragment();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void setFragment(int index){
        switch (index){
            case 0: startAllCategoriesFragment();
            case 1: startRecommendedFragment();
            case 2: startMyFragment();
            case 3: startFavoritesFragment();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void startAllCategoriesFragment(){
        replaceFragment(new DataListCatFragment(mData));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void startRecommendedFragment(){
        replaceFragment( new DataListCatFragment(mData));
    }

    private void startMyFragment(){
        startSimpleFragment("הפינוקים שלי");
    }

    private void startFavoritesFragment(){
        startSimpleFragment("מועדפים");
    }

    private void startSimpleFragment(String tabName){
        replaceFragment( new SimpleFragment(tabName) );
    }


    private void replaceFragment(Fragment fragment){
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.container, fragment).commitNow();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void transformPage(@NonNull View page, float position) {
        setFragment((int) position);
    }
}

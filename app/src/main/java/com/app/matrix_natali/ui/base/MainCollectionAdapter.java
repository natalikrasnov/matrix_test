package com.app.matrix_natali.ui.base;

import android.os.Build;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.app.matrix_natali.R;
import com.app.matrix_natali.ui.main.DataListCatFragment;
import com.app.matrix_natali.ui.main.MainViewModel;
import com.app.matrix_natali.ui.main.SimpleFragment;

public class MainCollectionAdapter extends FragmentStateAdapter implements ViewPager2.PageTransformer{

        private MainViewModel mViewModel;

        public MainCollectionAdapter(@NonNull Fragment fragment, MainViewModel viewModel) {
            super(fragment);
            mViewModel = viewModel;
        }

        @RequiresApi(api = Build.VERSION_CODES.N)
        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return getFragment(position);
        }

        @Override
        public int getItemCount() {
            return mViewModel.tabsTitles.length;
        }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private Fragment getFragment(int index){
            Fragment curr = null;
       switch (index){
            case 0: {
                curr =  startAllCategoriesFragment();
                break;
            }
            case 1: {
                curr =   startRecommendedFragment();
                break;
            }
            case 2: {
                curr =  startMyFragment();
                break;
            }
            case 3: curr =  startFavoritesFragment();
        }
        return curr;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private Fragment startAllCategoriesFragment(){
        return DataListCatFragment.newInstance(mViewModel.getDataObjectByCategory());
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private Fragment startRecommendedFragment(){
        return DataListCatFragment.newInstance(mViewModel.getDataObjectByCategory());
    }

    private Fragment startMyFragment(){
        return new SimpleFragment(mViewModel.tabsTitles[2]) ;
    }

    private Fragment startFavoritesFragment(){
        return new SimpleFragment(mViewModel.tabsTitles[3]) ;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void transformPage(@NonNull View page, float position) {
      //  replaceFragment(getFragment((int) position));
    }

}

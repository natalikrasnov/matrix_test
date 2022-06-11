package com.app.matrix_natali.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.app.matrix_natali.R;
import com.app.matrix_natali.data.api.Api_ServiceImpl;
import com.app.matrix_natali.data.api.Api_helper;
import com.app.matrix_natali.ui.base.MainCollectionAdapter;
import com.app.matrix_natali.ui.base.ViewModelFactory;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainFragment extends Fragment {

    public MainViewModel mViewModel;
    private OnFragmentInteractionListener mListener;
    private View mView;
    private TabLayout tabLayout;
    private MainCollectionAdapter collectionAdapter;
    private ViewPager2 viewPager;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.main_fragment, container, false);
        initViewModel();
        collectionAdapter = new MainCollectionAdapter(this, mViewModel);
        viewPager = mView.findViewById(R.id.pager);
        viewPager.setAdapter(collectionAdapter);
        viewPager.setPageTransformer(collectionAdapter);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tabLayout = mView.findViewById(R.id.tab);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText( mViewModel.tabsTitles[position])
        ).attach();
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void messageFromParentFragment(Uri uri);
    }

    private void initViewModel(){
        mViewModel = new ViewModelProvider(this, new ViewModelFactory(new Api_helper(new Api_ServiceImpl()))).get(MainViewModel.class);
        mViewModel.initDataObject(getContext());
    }


}
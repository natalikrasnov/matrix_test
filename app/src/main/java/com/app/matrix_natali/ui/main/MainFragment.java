package com.app.matrix_natali.ui.main;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.app.matrix_natali.R;
import com.app.matrix_natali.data.api.Api_ServiceImpl;
import com.app.matrix_natali.data.api.Api_helper;
import com.app.matrix_natali.data.repository.MainRepository;
import com.app.matrix_natali.ui.base.ViewModelFactory;

public class MainFragment extends Fragment {

    public MainViewModel mViewModel;
    private OnFragmentInteractionListener mListener;
    private View mView;
    private TableLayout tableLayout;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.main_fragment, container, false);
        tableLayout = mView.findViewById(R.id.tab);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: Use the ViewModel
        initViewModel();
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        if(mViewModel == null) initViewModel();
        Fragment childFragment = new DataListCatFragment(mViewModel.getDataObjectByCategory());
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.mainList, childFragment).commit();
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
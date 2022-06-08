package com.app.matrix_natali.ui.base;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.app.matrix_natali.data.api.Api_helper;
import com.app.matrix_natali.data.repository.MainRepository;
import com.app.matrix_natali.ui.main.MainViewModel;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private Api_helper api_helper;

    public ViewModelFactory(Api_helper api_helper){
        this.api_helper = api_helper;
    }


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> aClass) {
        if(aClass.isAssignableFrom(MainViewModel.class)) return (T) new MainViewModel(new MainRepository(api_helper));
        throw new IllegalArgumentException("unknown class name");
    }
}

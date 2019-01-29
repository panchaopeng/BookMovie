package com.pcp.life.mvvm.vm.item_vm.movie;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.pcp.life.mvvm.bean.movie.MovieItem;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.ItemViewModel;

public class RecycleDirectorItemVM extends ItemViewModel<BaseViewModel> {

    public ObservableField<MovieItem> movieItem = new ObservableField<>();

    public RecycleDirectorItemVM(@NonNull BaseViewModel viewModel, MovieItem entity) {
        super(viewModel);
        this.movieItem.set(entity);

    }

}

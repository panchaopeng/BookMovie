package com.pcp.life.mvvm.vm.activity_vm;

import android.app.Application;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.pcp.life.BR;
import com.pcp.life.R;
import com.pcp.life.mvvm.bean.movie.MovieDetail;
import com.pcp.life.mvvm.bean.movie.MovieItem;
import com.pcp.life.mvvm.bean_temp.movie.DetailCasts;
import com.pcp.life.mvvm.bean_temp.movie.DetailDirectors;
import com.pcp.life.mvvm.vm.item_vm.movie.RecycleDirectorItemVM;
import com.pcp.life.utils.BookDetailUtil;

import java.util.ArrayList;

import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.base.ItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

public class MovieDetailViewModel extends BaseViewModel {

    public MovieDetailViewModel(@NonNull Application application) {
        super(application);
    }

    public static final String baseUrl = "https://api.douban.com/v2/movie/subject/";
    //接收传过来的电影id
    public ObservableField<String> movie_id = new ObservableField<>();
    //查询电影的地址
    public ObservableField<String> searchMovieUrl = new ObservableField<>(baseUrl);
    //根据电影id请求详细的信息
    public ObservableField<MovieDetail> movieDetail = new ObservableField<>();

    public ObservableField<String> static_director = new ObservableField<>("");
    public ObservableField<String> static_summary = new ObservableField<>("");
    public ObservableField<String> title = new ObservableField<>("");
    public ObservableField<String> directors = new ObservableField<>("");
    public ObservableField<String> genres = new ObservableField<>("");
    public ObservableField<String> countries = new ObservableField<>("");
    public ObservableField<String> year = new ObservableField<>("");
    public ObservableField<String> aka = new ObservableField<>("");
    public ObservableField<String> summary = new ObservableField<>("");

    //装载数据
    public ArrayList<MovieItem> datas = new ArrayList<>();
    //给RecyclerView添加ObservableList
    public ObservableList<ItemViewModel> observableList = new ObservableArrayList<>();
    //给RecyclerView添加ItemBinding
    public ItemBinding<ItemViewModel> itemBinding = ItemBinding.of(BR.movieDetailVM, R.layout.recycle_casts_item);
    //给RecyclerView添加Adpter，请使用自定义的Adapter继承BindingRecyclerViewAdapter，重写onBindBinding方法
    public final BindingRecyclerViewAdapter<ItemViewModel> adapter = new BindingRecyclerViewAdapter<>();



    public void setDirectors(){

        if (datas.size() > 0){
            datas.clear();
        }

        //添加导演
        if (movieDetail.get().getDirectors() != null && movieDetail.get().getDirectors().size() > 0) {
            for (DetailDirectors detailDirectors : movieDetail.get().getDirectors()) {
                if (detailDirectors.getAvatars() != null && detailDirectors.getAvatars().getSmall() != null) {
                    datas.add(new MovieItem(detailDirectors.getAvatars().getSmall(), "(导演)" + detailDirectors.getName()));
                }
            }
        }


        //添加演员
        if (movieDetail.get().getCasts() != null && movieDetail.get().getCasts().size() > 0) {
            for (DetailCasts detailCasts : movieDetail.get().getCasts()) {
                if (detailCasts.getAvatars() != null && detailCasts.getAvatars().getSmall() != null) {
                    datas.add(new MovieItem(detailCasts.getAvatars().getSmall(), detailCasts.getName()));
                }
            }
        }

        for (MovieItem entity : datas) {
            RecycleDirectorItemVM itemViewModel = new RecycleDirectorItemVM(MovieDetailViewModel.this, entity);
            //双向绑定动态添加Item
            observableList.add(itemViewModel);
        }

        //标题
        title.set("标题: " + movieDetail.get().getTitle());

        //导演
        StringBuffer stringBuffer = new StringBuffer("");
        for (DetailDirectors detailDirectors : movieDetail.get().getDirectors()) {
            if (detailDirectors.getName().length() >0){
                stringBuffer.append(detailDirectors.getName() + " ");
            }
        }
        directors.set("导演: " + stringBuffer.toString());

        //类别
        genres.set("类别: " + BookDetailUtil.formatListToString(movieDetail.get().getGenres()));

        //国家/地区
        countries.set("国家/地区: " +  BookDetailUtil.formatListToString(movieDetail.get().getCountries()));

        //年份
        year.set("年份: " + movieDetail.get().getYear());

        //又名
        aka.set("又名: " + BookDetailUtil.formatListToString(movieDetail.get().getAka()));

        //电影简介
        summary.set(BookDetailUtil.setContent(movieDetail.get().getSummary()));

        //设置静态文字提示
        static_director.set("导演及主演");
        static_summary.set("内容简介");


    }

    //后退
    public BindingCommand finish = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            finish();
        }
    });


}

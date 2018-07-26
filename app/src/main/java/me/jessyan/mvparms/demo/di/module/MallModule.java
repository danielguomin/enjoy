package me.jessyan.mvparms.demo.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;
import me.jessyan.mvparms.demo.mvp.contract.MallContract;
import me.jessyan.mvparms.demo.mvp.model.MallModel;


@Module
public class MallModule {
    private MallContract.View view;

    /**
     * 构建MallModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public MallModule(MallContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    MallContract.View provideMallView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    MallContract.Model provideMallModel(MallModel model) {
        return model;
    }
}
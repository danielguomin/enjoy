package me.jessyan.mvparms.demo.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;
import me.jessyan.mvparms.demo.mvp.contract.SerachResultContract;
import me.jessyan.mvparms.demo.mvp.model.SerachResultModel;


@Module
public class SerachResultModule {
    private SerachResultContract.View view;

    /**
     * 构建SerachResultModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     *
     * @param view
     */
    public SerachResultModule(SerachResultContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    SerachResultContract.View provideSerachResultView() {
        return this.view;
    }

    @ActivityScope
    @Provides
    SerachResultContract.Model provideSerachResultModel(SerachResultModel model) {
        return model;
    }
}
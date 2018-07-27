package me.jessyan.mvparms.demo.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;
import me.jessyan.mvparms.demo.di.module.SerachResultModule;
import me.jessyan.mvparms.demo.mvp.ui.activity.SerachResultActivity;

@ActivityScope
@Component(modules = SerachResultModule.class, dependencies = AppComponent.class)
public interface SerachResultComponent {
    void inject(SerachResultActivity activity);
}
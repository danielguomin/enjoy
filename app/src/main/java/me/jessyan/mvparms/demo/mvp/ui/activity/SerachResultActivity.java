package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerSerachResultComponent;
import me.jessyan.mvparms.demo.di.module.SerachResultModule;
import me.jessyan.mvparms.demo.mvp.contract.SerachResultContract;
import me.jessyan.mvparms.demo.mvp.presenter.SerachResultPresenter;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class SerachResultActivity extends BaseActivity<SerachResultPresenter> implements SerachResultContract.View {


    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerSerachResultComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .serachResultModule(new SerachResultModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_serach_result; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }


}

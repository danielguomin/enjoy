package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;
import com.tbruyelle.rxpermissions2.RxPermissions;

import javax.inject.Inject;

import butterknife.BindView;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerLoginComponent;
import me.jessyan.mvparms.demo.di.module.LoginModule;
import me.jessyan.mvparms.demo.mvp.contract.LoginContract;
import me.jessyan.mvparms.demo.mvp.presenter.LoginPresenter;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.View, View.OnClickListener {

    @BindView(R.id.forget)
    View forgetV;
    @BindView(R.id.register)
    View registerV;
    @BindView(R.id.protocol)
    TextView protocoTV;
    @BindView(R.id.tab)
    TabLayout tabLayout;
    @BindView(R.id.username)
    EditText userNameET;
    @BindView(R.id.password)
    EditText passwordET;
    @BindView(R.id.validate)
    EditText validateET;
    @BindView(R.id.byPhone)
    View byPhoneV;
    @BindView(R.id.byUserName)
    View byUserNameV;
    @BindView(R.id.get_validate)
    View getValidateV;
    @BindView(R.id.login)
    View loginV;
    @BindView(R.id.close)
    View closeV;
    @Inject
    RxPermissions mRxPermissions;


    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerLoginComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .loginModule(new LoginModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_login; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        protocoTV.setText(Html.fromHtml("<font color='#9A9A9A'>同意</font><font color='#5FBFE3'>《创享会员实用协议》</font>"));
        forgetV.setOnClickListener(this);
        registerV.setOnClickListener(this);
        protocoTV.setOnClickListener(this);
        loginV.setOnClickListener(this);
        closeV.setOnClickListener(this);
        getValidateV.setOnClickListener(this);
        tabLayout.addTab(tabLayout.newTab().setText("账户登录"));
        tabLayout.addTab(tabLayout.newTab().setText("手机登录"));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                changeTabToPhone(tab.getPosition() == 1);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mPresenter.requestPermissions();
    }

    private void changeTabToPhone(boolean byPhone) {
        if (byPhone) {
            byPhoneV.setVisibility(View.VISIBLE);
            byUserNameV.setVisibility(View.GONE);
        } else {
            byPhoneV.setVisibility(View.GONE);
            byUserNameV.setVisibility(View.VISIBLE);
        }
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forget:
                ArmsUtils.startActivity(ForgetActivity.class);
                break;
            case R.id.register:
                ArmsUtils.startActivity(RegisterActivity.class);
                break;
            case R.id.protocol:
                ArmsUtils.startActivity(MainActivity.class);
                break;
            case R.id.login:
                login();
                break;
            case R.id.get_validate:
                mPresenter.getVerifyForUser(userNameET.getText().toString());
                break;
            case R.id.close:
                killMyself();
                break;
        }
    }

    private void login() {
        if (tabLayout.getSelectedTabPosition() == 0) {
            // 用户名登录
            mPresenter.loginByUser(userNameET.getText().toString(), passwordET.getText().toString());
        } else {
            // 短信验证码登录
            mPresenter.loginByPhone(userNameET.getText().toString(), validateET.getText().toString());
        }
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void goMainPage() {
        ArmsUtils.startActivity(MainActivity.class);
    }

    @Override
    public RxPermissions getRxPermissions() {
        return mRxPermissions;
    }
}

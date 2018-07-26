package me.jessyan.mvparms.demo.mvp.model.api.service;

import io.reactivex.Observable;
import me.jessyan.mvparms.demo.mvp.model.entity.BaseResponse;
import me.jessyan.mvparms.demo.mvp.model.entity.ForgetRequest;
import me.jessyan.mvparms.demo.mvp.model.entity.LoginByPhoneRequest;
import me.jessyan.mvparms.demo.mvp.model.entity.LoginByUserRequest;
import me.jessyan.mvparms.demo.mvp.model.entity.ModifyRequest;
import me.jessyan.mvparms.demo.mvp.model.entity.RegisterRequest;
import me.jessyan.mvparms.demo.mvp.model.entity.RegisterResponse;
import me.jessyan.mvparms.demo.mvp.model.entity.VeritfyRequest;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by guomin on 2018/1/29.
 */

public interface LoginAndRegisterService {

    @POST("gateway")
    Observable<RegisterResponse> loginByPhone(@Body LoginByPhoneRequest loginByPhoneRequest);

    @POST("gateway")
    Observable<RegisterResponse> loginByUser(@Body LoginByUserRequest loginByUserRequest);

    @POST("gateway")
    Observable<RegisterResponse> register(@Body RegisterRequest registerRequest);

    @POST("gateway")
    Observable<BaseResponse> getVerify(@Body VeritfyRequest veritfyRequest);

    @POST("gateway")
    Observable<BaseResponse> getVerifyForUser(@Body VeritfyRequest veritfyRequest);

    @POST("gateway")
    Observable<BaseResponse> getVerifyForFind(@Body VeritfyRequest veritfyRequest);

    @POST("gateway")
    Observable<RegisterResponse> find(@Body ForgetRequest forgetRequest);

    @POST("gateway")
    Observable<BaseResponse> modify(@Body ModifyRequest modifyRequest);

}

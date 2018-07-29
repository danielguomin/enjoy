package me.jessyan.mvparms.demo.mvp.model.api.service;

import io.reactivex.Observable;
import me.jessyan.mvparms.demo.mvp.model.entity.request.HomeRequest;
import me.jessyan.mvparms.demo.mvp.model.entity.request.HotRequest;
import me.jessyan.mvparms.demo.mvp.model.entity.request.SimpleRequest;
import me.jessyan.mvparms.demo.mvp.model.entity.response.CategoryResponse;
import me.jessyan.mvparms.demo.mvp.model.entity.response.CityResponse;
import me.jessyan.mvparms.demo.mvp.model.entity.response.HomeResponse;
import me.jessyan.mvparms.demo.mvp.model.entity.response.HotResponse;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by guomin on 2018/1/29.
 */

public interface MainService {

    @POST("gateway")
    Observable<CityResponse> getCities(@Body SimpleRequest request);


    @POST("gateway")
    Observable<HotResponse> getHot(@Body HotRequest request);

    @POST("gateway")
    Observable<CategoryResponse> getCategory(@Body SimpleRequest request);

    @POST("gateway")
    Observable<HomeResponse> getHomeInfo(@Body HomeRequest request);
}

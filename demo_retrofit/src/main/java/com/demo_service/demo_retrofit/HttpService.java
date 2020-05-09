package com.demo_service.demo_retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author: mj
 * @date: 2020/4/10$
 * @desc:
 */
public interface HttpService {
    @GET("/helloGet.html")
    Call<ResponseBody> getString();


}

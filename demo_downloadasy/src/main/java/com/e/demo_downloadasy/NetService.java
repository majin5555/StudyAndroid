package com.e.demo_downloadasy;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author: majin
 * @date: 2020/4/8$
 * @desc:
 */
public interface NetService {
    @FormUrlEncoded
    @POST("login")
    Call<ResponseBody> login(@Field("username") String user, @Field("password") String pw);
}

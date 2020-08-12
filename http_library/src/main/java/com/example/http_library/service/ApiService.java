package com.example.http_library.service;

import com.google.gson.JsonElement;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

public interface ApiService {

    @GET
    Observable<JsonElement> get(@Url String baseUrl, @QueryMap Map<String,Object> map,
                                @HeaderMap Map<String,Object> headers);

    @POST
    @FormUrlEncoded
    Observable<JsonElement> post(@Url String url, @FieldMap Map<String,Object> map,
                                 @HeaderMap Map<String,Object> headers
                                 );

    @POST
    Observable<JsonElement> jsonPost(@Url String baseUrl, @Body RequestBody requestBody,@HeaderMap Map<String,Object> headers);


    @POST
    @Multipart
    Observable<JsonElement> postUploade(@Url String baseUrl, @PartMap Map<String,Object> map, List<MultipartBody.Part> multiparts);


    @GET
    @Streaming
    Observable<JsonElement> dwon(@Url String baseUrl,@QueryMap Map<String,Object> map,@HeaderMap Map<String,Object> headers);

    @DELETE
    Observable<JsonElement> delete(@Url String baseUrl,@QueryMap Map<String,Object> map,@HeaderMap Map<String,Object> headers);


    @PUT
    Observable<JsonElement> put(@Url String baseUrl,@FieldMap Map<String,Object> map,@HeaderMap Map<String,Object> headers);

}

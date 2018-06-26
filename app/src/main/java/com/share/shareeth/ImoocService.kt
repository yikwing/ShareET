package com.share.shareeth

import io.reactivex.Observable
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Demo class
 *
 * @author yikwing
 * @date 2018/6/26
 */
interface ImoocService {
    @FormUrlEncoded
    @POST("/api/v1/getImoocInfo")
    fun getImoocInfo(@FieldMap map: Map<String, String>): Observable<List<ImoocBean>>
}
package com.irfan.crudapi

import android.util.Log
import retrofit2.Call
import retrofit2.Response

class Presenter(val crudView: InputActivity) {
    //fungsi get data
    fun getData() {
        NetworkConfig.getService().getData()
            .enqueue(object : retrofit2.Callback<ResultStaff> {
                override fun onFailure(call: Call<ResultStaff>, t: Throwable) {
                    crudView.onFailedGet(t.localizedMessage)
                    Log.d("Error", "Error Data")
                }

                override fun onResponse(call: Call<ResultStaff>, response: Response<ResultStaff>) {
                    if (response.isSuccessful) {
                        val status = response.body()?.status
                        if (status == 200) {
                            val  data = response.body()?.staff
                            crudView.onSuccessGet(data)
                        }else {
                            crudView.onFailedGet("Error $status")
                        }
                    }
                }
            })
    }

    //untuk hapus data
    fun hapusData(id: String?) {
        NetworkConfig.getService()
            .deleteStaff(id)
            .enqueue(object : retrofit2.Callback<ResulrStatus> {
                override fun onFailure(call: Call<ResulrStatus>, t: Throwable) {
                    crudView.onErrorDelete(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResulrStatus>,
                    response: Response<ResulrStatus>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.onSuccessDelete(response.body()?.pesan ?: "")
                    }else {
                        crudView.onErrorDelete(response.body()?.pesan ?: "")
                    }
                }
            })
    }
}
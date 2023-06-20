package com.irfan.crudapi

import retrofit2.Call
import retrofit2.Response

class Presenter2 (val crudView : UpdateAddActivity) {
    //add data
    fun addDete(name:String, hp: String, alamat: String, namdos: String) {
        NetworkConfig.getService()
            .addStaff(name, hp, alamat, namdos)
            .enqueue(object  : retrofit2.Callback<ResulrStatus> {
                override fun onFailure(call: Call<ResulrStatus>, t: Throwable) {
                    crudView.onErrorAdd(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResulrStatus>,
                    response: Response<ResulrStatus>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.onSuccessAdd(response.body()?.pesan ?:  "")
                    }else {
                        crudView.onErrorAdd(response.body()?.pesan ?: "")
                    }
                }
            })
    }

    //update data
    fun updateData(id: String, name: String, hp: String, alamat: String, namdos: String) {
        NetworkConfig.getService()
            .updateStaff(id, name, hp, alamat, namdos)
            .enqueue(object : retrofit2.Callback<ResulrStatus> {
                override fun onFailure(call: Call<ResulrStatus>, t: Throwable) {
                    crudView.onErrorUpdate(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResulrStatus>,
                    response: Response<ResulrStatus>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200) {
                        crudView.onSuccessUpdate(response.body()?.pesan ?: "")
                    }else{
                        crudView.onErrorUpdate(response.body()?.pesan ?: "")
                    }
                }
            })
    }
}
package com.irfan.crudapi

interface CrudView {
    //get Data
    fun onSuccessGet(data : List<DataItem>?)
    fun onFailedGet(msg: String)

    //untuk add
    fun onSuccessAdd(msg: String)
    fun onErrorAdd(msg: String)

    //untuk update
    fun onSuccessUpdate(msg: String)
    fun onErrorUpdate(msg: String)

    //untuk delete
    fun onSuccessDelete(msg: String)
    fun onErrorDelete(msg: String)
}
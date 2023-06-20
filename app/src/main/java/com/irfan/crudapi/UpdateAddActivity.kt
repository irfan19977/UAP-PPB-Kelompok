package com.irfan.crudapi

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_update_add.*

@Suppress ("SENSELESESS_COMPARISON")
class UpdateAddActivity : AppCompatActivity(), CrudView {
    private  lateinit var  presenter: Presenter2
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_add)

        presenter = Presenter2(this)
        val itemDataItem = intent.getSerializableExtra("dataItem")

        if (itemDataItem == null) {
            btnAction.text = "Tambah"
            btnAction.setOnClickListener() {
                presenter.addDete(
                    etMatkul.text.toString(),
                    etSks.text.toString(),
                    etKet.text.toString(),
                etNamdos.text.toString())
            }
        }else if (itemDataItem != null) {
            btnAction.text = "Update"
            val item = itemDataItem as DataItem?
            etMatkul.setText(item?.staffName.toString())
            etSks.setText(item?.staffPhone.toString())
            etKet.setText(item?.staffAlamat.toString())
            etNamdos.setText(item?.staffNamdos.toString())
            btnAction.setOnClickListener() {
                presenter.updateData(
                    item?.staffId ?: "",
                    etMatkul.text.toString(),
                    etSks.text.toString(),
                    etKet.text.toString(),
                etNamdos.text.toString())
                finish()
            }
        }
    }

    override fun onSuccessAdd(msg: String) {
        startActivity(Intent(this, InputActivity::class.java))
        finish()
    }

    override fun onErrorAdd(msg: String) {
    }

    override fun onSuccessUpdate(msg: String) {
        startActivity(Intent(this, InputActivity::class.java))
        finish()
    }

    override fun onErrorUpdate(msg: String) {
    }

    override fun onSuccessGet(data: List<DataItem>?) {
    }

    override fun onFailedGet(msg: String) {
    }

    override fun onSuccessDelete(msg: String) {
    }

    override fun onErrorDelete(msg: String) {
    }
}
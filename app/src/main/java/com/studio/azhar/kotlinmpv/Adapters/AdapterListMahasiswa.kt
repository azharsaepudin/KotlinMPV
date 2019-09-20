package com.studio.azhar.kotlinmpv.Adapters

import android.content.Context
import com.studio.azhar.kotlinmpv.Model.ModelMahasiswa
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.studio.azhar.kotlinmpv.R
import kotlinx.android.synthetic.main.item_data.view.*

class AdapterListMahasiswa (private val context: Context, private val list: List<ModelMahasiswa>,
                            private val listener: (ModelMahasiswa) -> Unit): RecyclerView.Adapter<AdapterListMahasiswa.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)=
        AdapterListMahasiswa.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_data, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position], listener, context)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindItem(modelMahasiswa: ModelMahasiswa, listener: (ModelMahasiswa) -> Unit, context: Context) {

            itemView.tv_nama.text = modelMahasiswa.nama
            itemView.tv_Email.text = modelMahasiswa.email

            itemView.setOnClickListener {
                listener(modelMahasiswa)
            }
        }
    }


}
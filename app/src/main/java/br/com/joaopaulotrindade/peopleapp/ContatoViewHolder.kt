package br.com.joaopaulotrindade.peopleapp

import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.View
import android.widget.TextView

/**
 * Created by joao.paulo.trindade on 22/08/2017.
 */
class ContatoViewHolder(itemView: View?, clickListenr: View.OnClickListener?) : ViewHolder(itemView) {

    public var tvNome: TextView
    public var tvEmail: TextView
    public var tvTelefone: TextView

    init {
        itemView!!.setOnClickListener(clickListenr)
        tvNome = itemView!!.findViewById(R.id.tvNome)
        tvEmail = itemView!!.findViewById(R.id.tvEmail)
        tvTelefone = itemView!!.findViewById(R.id.tvTelefone)
    }

}
package br.com.joaopaulotrindade.peopleapp

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.joaopaulotrindade.peopleapp.entity.Contato

/**
 * Created by joao.paulo.trindade on 22/08/2017.
 */
class ContatoAdapter(val context: Context, val recyclerView: RecyclerView, val contatos: ArrayList<Contato> = ArrayList())
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(), View.OnClickListener {

    fun addContato(newContato: Contato) {
        contatos.add(newContato)
        notifyDataSetChanged();
    }


    override fun getItemCount(): Int {
        return contatos.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        if (holder is ContatoViewHolder) {
            holder.tvNome.setText(contatos[position].nome)
            holder.tvTelefone.setText(contatos[position].telefone)
            holder.tvEmail.setText(contatos[position].email)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        return ContatoViewHolder(LayoutInflater.from(context).inflate(R.layout.viewholder_contato, parent, false), this)
    }

    override fun onClick(view: View?) {
        val position = recyclerView.getChildAdapterPosition(view)
        contatos.removeAt(position)
        notifyItemRemoved(position)
    }


}




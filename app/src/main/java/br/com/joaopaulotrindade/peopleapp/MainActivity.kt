package br.com.joaopaulotrindade.peopleapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.util.Log
import android.view.View
import br.com.joaopaulotrindade.peopleapp.contato.AddNovoContato
import br.com.joaopaulotrindade.peopleapp.entity.Contato
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter = ContatoAdapter(this, recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter;
    }

    override fun onStart() {
        super.onStart()
        Log.d("DEBUG", "onStart")
    }

    fun addNovoContato(view: View) {
        startActivityForResult(Intent(this.baseContext, AddNovoContato::class.java), AddNovoContato.REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            AddNovoContato.REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    val novoContato: Contato? = data?.getParcelableExtra<Contato>(AddNovoContato.NOVO_CONTATO_KEY)
                    Log.d("DEBUG", novoContato?.toString())
                    (adapter as ContatoAdapter).addContato(novoContato!!)
                    return
                }

                if (resultCode == Activity.RESULT_CANCELED) return
            }

        }
    }
}

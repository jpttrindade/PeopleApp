package br.com.joaopaulotrindade.peopleapp.contato

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import br.com.joaopaulotrindade.peopleapp.R
import br.com.joaopaulotrindade.peopleapp.entity.Contato
import kotlinx.android.synthetic.main.activity_addnovocontato.*

/**
 * Created by joao.paulo.trindade on 22/08/2017.
 */
class AddNovoContato: AppCompatActivity() {
    companion object {
        val REQUEST_CODE = 1
        val NOVO_CONTATO_KEY = "novo_Contato_Key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnovocontato)
    }

    fun adicionar(view: View) {
        if(validarCampos()) {
            val intent = Intent()
            intent.putExtra(AddNovoContato.NOVO_CONTATO_KEY,
                    Contato(tilNome.editText?.text?.toString(),
                            tilEmail.editText?.text?.toString(),
                            tilTelefone.editText?.text?.toString()));
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    private fun validarCampos(): Boolean {
        if (!TextUtils.isEmpty(tilNome.editText?.text?.toString()) &&
                !TextUtils.isEmpty(tilEmail.editText?.text?.toString()) &&
                !TextUtils.isEmpty(tilTelefone.editText?.text?.toString())) {
            return true
        }
        return false
    }
}
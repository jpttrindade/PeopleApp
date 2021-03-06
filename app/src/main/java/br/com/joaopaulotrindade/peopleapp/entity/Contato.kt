package br.com.joaopaulotrindade.peopleapp.entity

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by joao.paulo.trindade on 22/08/2017.
 */
class Contato(val nome: String?, val email: String?, val telefone: String?) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)
        parcel.writeString(email)
        parcel.writeString(telefone)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Contato> {
        override fun createFromParcel(parcel: Parcel): Contato {
            return Contato(parcel)
        }

        override fun newArray(size: Int): Array<Contato?> {
            return arrayOfNulls(size)
        }
    }
}
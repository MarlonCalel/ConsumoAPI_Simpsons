package com.example.simpsonfrases.viewmodels

import androidx.coordinatorlayout.widget.CoordinatorLayout.DispatchChangeEvent
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpsonfrases.core.RetrofitClient
import com.example.simpsonfrases.models.PersonajesSimpsons
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel: ViewModel() {

    private val _listaPersonajes = MutableLiveData<List<PersonajesSimpsons>>()
    val listaPersonajes: LiveData<List<PersonajesSimpsons>> get() = _listaPersonajes

    fun obtenerPersonajes() {
        viewModelScope.launch(Dispatchers.IO){
            val response= RetrofitClient.simpsonapiservice.obtenerPersonajes()
            withContext(Dispatchers.Main){
                _listaPersonajes.value= response.body()
            }
        }
    }

    fun obtenerPersonaje(personaje: String){
        viewModelScope.launch(Dispatchers.IO){
            val response= RetrofitClient.simpsonapiservice.obtenerPersonajes(personaje)
            withContext(Dispatchers.Main){
                _listaPersonajes.value= response.body()
            }
        }
    }
}
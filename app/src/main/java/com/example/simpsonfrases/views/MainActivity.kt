package com.example.simpsonfrases.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.simpsonfrases.R
import com.example.simpsonfrases.databinding.ActivityMainBinding
import com.example.simpsonfrases.viewmodels.MainViewModel
import com.example.simpsonfrases.views.adapters.PersonajeAdapter

private lateinit var binding: ActivityMainBinding
private lateinit var viewModel: MainViewModel
private lateinit var adapter: PersonajeAdapter


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        setupRecyclerView()
        viewModel.obtenerPersonajes()

        viewModel.listaPersonajes.observe(this){
            adapter.listaPersonajes = it
            adapter.notifyDataSetChanged()
        }

        binding.tituloBuscar.setEndIconOnClickListener{
            if( binding.tietBuscar.text.toString() == ""){
                viewModel.obtenerPersonajes()
            }else {
                viewModel.obtenerPersonaje(binding.tietBuscar.text.toString().trim())
            }
        }
    }

    fun setupRecyclerView(){
        binding.rvPersonajes.layoutManager = GridLayoutManager(this, 2)
        adapter = PersonajeAdapter(this, arrayListOf())
        binding.rvPersonajes.adapter = adapter
    }
}
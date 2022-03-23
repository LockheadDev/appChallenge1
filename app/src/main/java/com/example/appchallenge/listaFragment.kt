package com.example.appchallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appchallenge.adapter.TareasAdapter
import com.example.appchallenge.data.Tarea
import com.example.appchallenge.data.TareaDataProvider
import com.example.appchallenge.databinding.FragmentListaBinding

class listaFragment : Fragment() {
    private lateinit var binding: FragmentListaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler : RecyclerView = binding.recyclerview
        // datos al adapter
        val tareasAdapter = TareasAdapter(TareaDataProvider.getDat())
        // Listener para onclick
        tareasAdapter.setOnItemClickListener( object : TareasAdapter.ClickListener{
            override fun onItemClick(view: View, position: Int) {
                Toast.makeText(context, "Descripción: ${tareasAdapter.getData(position).Descripcion}\n TimeStamp: ${tareasAdapter.getData(position).timeStamp}", Toast.LENGTH_LONG).show()
            }
        })
        //layout, cómo quiero que se vea
        recycler.layoutManager = LinearLayoutManager(context)

        // recycler recibe el adapter
        recycler.adapter = tareasAdapter
    }


}

package com.example.appchallenge

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.appchallenge.data.Tarea
import com.example.appchallenge.data.TareaDataProvider
import com.example.appchallenge.databinding.FragmentCaptureBinding
import java.text.SimpleDateFormat
import java.util.*

class CaptureFragment : Fragment() {
    lateinit var binding: FragmentCaptureBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCaptureBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.LABELUSUARIO.text = "${arguments?.getString("usuario")}"
        binding.add.setOnClickListener {

            val nom = binding.STRINGTITULO.text.toString()
            val desc = binding.STRINGDESCRIPCION.text.toString()
            val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val priori = binding.STRINGPRIORIDAD.text.toString().toInt()
            val tarea = Tarea(nom,desc,timeStamp,priori)
            if(tarea.Nombre==null || tarea.Descripcion == null || tarea.Prioridad == null)
            {
                Toast.makeText(context,"Llena todos los campos", Toast.LENGTH_SHORT).show()
            }else {
                //Guardamos dato en arreglo
                TareaDataProvider.addDat(tarea)
                //Esto de aqui abajo no es totalmente necesario ya que guardamos la tarea en TareaDataProvider arriba
                val action = CaptureFragmentDirections.actionCaptureFragmentToListaFragment(tarea)
                findNavController().navigate(action)
            }
        }

    }
    private fun eraseTB()
    {
        binding.STRINGDESCRIPCION.setText("")
        binding.STRINGTITULO.setText("")
        binding.STRINGPRIORIDAD.setText("")
    }

}
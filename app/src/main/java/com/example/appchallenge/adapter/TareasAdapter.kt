package com.example.appchallenge.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appchallenge.R
import com.example.appchallenge.data.Tarea

class TareasAdapter (private val lista : List<Tarea>):RecyclerView.Adapter<TareasAdapter.TareaViewHolder>(){
    private var clickListener: ClickListener? = null

    fun setOnItemClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }
    interface ClickListener{
        fun onItemClick(view: View, position: Int)
    }

    //Construye el renglón, pero no le da datos  a los elementos gráficos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TareaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.renglon_tarea, parent, false)
        return TareaViewHolder(view)
    }

    override fun onBindViewHolder(holder: TareaViewHolder, position: Int) {
        val quote = lista[position]
        holder.bind(quote)
    }

    override fun getItemCount()= lista.size


    fun getData( position: Int ): Tarea{
        return lista[position]
    }


    // --TAREA VIEW HOLDER CLASS --
    //Esta clase hereda de RecyclerView.ViewHolder(view) (se le inserta el view de input a la parent class)
    inner class TareaViewHolder(view: View):
        RecyclerView.ViewHolder(view), View.OnClickListener{

        val title : TextView = view.findViewById(R.id.LABEL_TITULO)
        val timestamp : TextView = view.findViewById(R.id.LABEL_TIMESTAMP)
        val prioridad : TextView = view.findViewById(R.id.LABEL_PRIORIDAD)

        //Funcion que se encarga de actualizar datos
        fun bind (tarea: Tarea) {
            title.text = tarea.Nombre
            timestamp.text = tarea.timeStamp
            prioridad.text = tarea.Prioridad.toString()
        }
        init {
            view.setOnClickListener(this)
        }
        override fun onClick(view: View?) {
            if(view != null) {
                clickListener?.onItemClick(view, bindingAdapterPosition)
            }
        }
    }
}
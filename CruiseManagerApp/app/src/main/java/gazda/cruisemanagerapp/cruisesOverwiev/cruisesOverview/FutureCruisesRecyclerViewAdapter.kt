package gazda.cruisemanagerapp.cruisesOverwiev.cruisesOverview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import database.entities.CruiseInfo
import gazda.cruisemanagerapp.R
import kotlinx.android.synthetic.main.cruises_overwiev_single_cruise.view.*

class FutureCruisesRecyclerViewAdapter(private val cruisesList:ArrayList<CruiseInfo>,
                                       private val myClickListener:ClickListener)
    : RecyclerView.Adapter<FutureCruisesRecyclerViewAdapter.CruiseViewHolder>() {

    class CruiseViewHolder(itemView: View, myClickListener:ClickListener)
        : RecyclerView.ViewHolder(itemView) {

        val cruiseName:TextView = itemView.findViewById(R.id.cruise_name)
        val cruiseDate:TextView = itemView.findViewById(R.id.cruise_date)
        val cruiseCaptain:TextView = itemView.findViewById(R.id.cruise_captain)
        val cruiseUnit:TextView = itemView.findViewById(R.id.cruise_unit)
        init {
           itemView.inner_card_layout.setOnClickListener {
                val position: Int = adapterPosition
                   myClickListener.onClicked(position)
                    Snackbar.make(
                        it, "Click detected on item $position",
                        Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CruiseViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cruises_overwiev_single_cruise, parent, false)

        return CruiseViewHolder(view, myClickListener)

    }

    override fun getItemCount(): Int {
        return cruisesList.size
    }

    fun addCruise(newCruise:CruiseInfo){
        cruisesList.add(newCruise)
    }

    override fun onBindViewHolder(holder: CruiseViewHolder, position: Int) {
        holder.cruiseName.text = cruisesList[position].cruiseName
        holder.cruiseDate.text = cruisesList[position].cruiseDate
        holder.cruiseCaptain.text = cruisesList[position].cruiseCaptain
        holder.cruiseUnit.text = cruisesList[position].cruiseUnit
    }
}
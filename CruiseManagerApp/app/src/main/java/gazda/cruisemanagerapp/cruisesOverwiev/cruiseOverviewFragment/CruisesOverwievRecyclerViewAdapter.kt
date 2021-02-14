package gazda.cruisemanagerapp.cruisesOverwiev.cruiseOverviewFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import database.entities.CruiseInfo
import gazda.cruisemanagerapp.R

class CruisesOverwievRecyclerViewAdapter(private val cruisesList:ArrayList<CruiseInfo>): RecyclerView.Adapter<CruisesOverwievRecyclerViewAdapter.CruiseViewHolder>() {

    class CruiseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cruiseName:TextView = itemView.findViewById(R.id.cruise_name)
        val cruiseDate:TextView = itemView.findViewById(R.id.cruise_date)
        val cruiseCaptain:TextView = itemView.findViewById(R.id.cruise_captain)
        val cruiseUnit:TextView = itemView.findViewById(R.id.cruise_unit)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CruiseViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cruises_overwiev_single_cruise, parent, false)

        return CruiseViewHolder(view)

    }

    override fun getItemCount(): Int {
        return cruisesList.size
    }

    override fun onBindViewHolder(holder: CruiseViewHolder, position: Int) {
        holder.cruiseName.text = cruisesList[position].cruiseName
        holder.cruiseDate.text = cruisesList[position].cruiseDate
        holder.cruiseCaptain.text = cruisesList[position].cruiseCaptain
        holder.cruiseUnit.text = cruisesList[position].cruiseUnit
    }
}
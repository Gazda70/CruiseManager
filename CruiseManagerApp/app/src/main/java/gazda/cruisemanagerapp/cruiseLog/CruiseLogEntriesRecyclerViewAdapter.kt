package gazda.cruisemanagerapp.cruiseLog

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import database.entities.Cruise
import database.entities.CruiseLogEntry
import gazda.cruisemanagerapp.R
import gazda.cruisemanagerapp.cruiseLog.ClickListener
import kotlinx.android.synthetic.main.cruise_log_fragment.view.*
import kotlinx.android.synthetic.main.cruises_overwiev_single_cruise.view.*

class CruiseLogEntriesRecyclerViewAdapter(private val cruiseLogEntriesList:ArrayList<CruiseLogEntry>,
                                          private val myClickListener: ClickListener
)
    : RecyclerView.Adapter<CruiseLogEntriesRecyclerViewAdapter.CruiseLogEntryViewHolder>() {

    class CruiseLogEntryViewHolder(itemView: View, myClickListener: ClickListener)
        : RecyclerView.ViewHolder(itemView) {

        val logEntryCreator: TextView = itemView.findViewById(R.id.log_entry_creator_name)
        val logEntryTimestamp: TextView = itemView.findViewById(R.id.log_entry_timestamp)
        init {
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                myClickListener.onClicked(position)
                Snackbar.make(
                    it, "Click detected on item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CruiseLogEntryViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cruise_log_single_log_entry, parent, false)

        return CruiseLogEntryViewHolder(view, myClickListener)

    }

    override fun getItemCount(): Int {
        return cruiseLogEntriesList.size
    }

    fun addCruise(newCruiseLogEntry: CruiseLogEntry){
        cruiseLogEntriesList.add(newCruiseLogEntry)
    }

    override fun onBindViewHolder(holder: CruiseLogEntryViewHolder, position: Int) {
        holder.logEntryCreator.text = cruiseLogEntriesList[position].logEntryCreator
        holder.logEntryTimestamp.text = cruiseLogEntriesList[position].logEntryTimestamp
    }
}
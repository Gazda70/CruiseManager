package gazda.cruisemanagerapp.cruiseLog

import androidx.lifecycle.ViewModel
import database.entities.Cruise
import database.entities.CruiseLogEntry

class CruiseLogViewModel : ViewModel() {
    var logEntries:ArrayList<CruiseLogEntry> = ArrayList<CruiseLogEntry>()

    fun getMyLogEntries():ArrayList<CruiseLogEntry>{
        if(logEntries.isEmpty()){
            logEntries = dummyCruises
        }
        return this.logEntries
    }

    private var dummyCruises:ArrayList<CruiseLogEntry> = arrayListOf(
        CruiseLogEntry(
            "Piotr",
            "30.12.2020"

        ),
        CruiseLogEntry(
            "Paweł",
            "30.12.2020"

        ),
        CruiseLogEntry(
            "Monika",
            "30.12.2020"

        )
    )
}
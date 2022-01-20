package gazda.cruisemanagerapp.cruisesOverwiev.cruisesOverview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import database.entities.Cruise
import database.entities.SailorsWatch

class CruisesOverviewViewModel() : ViewModel() {

    var cruises:ArrayList<Cruise> = ArrayList<Cruise>()

    fun getMyCruises():ArrayList<Cruise>{
            if(cruises.isEmpty()){
                cruises = dummyCruises
            }
            return this.cruises
        }

    private var dummyCruises:ArrayList<Cruise> = arrayListOf(
        Cruise(
            "Rejs1",
            "30.12.2020",
            "Piotr Gazda",
            "\"Marzenie\"",
                null,
                null,
                null,
                null,
                null
        ),
        Cruise(
            "Rejs2",
            "30.12.2020",
            "Bartosz Cichowski",
            "\"Pan Nocy\"",
                null,
                null,
                null,
                null,
                null
        ),
        Cruise(
            "Rejs3",
            "30.12.2020",
            "Asia",
            "\"Morska Dama\"",
                null,
                null,
                null,
                null,
                null
        )
    )
    val addCruise: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

  /*   fun getFutureCruisesFromDatabase():Flowable<CruiseInfo>{
        return dataSource.getAll()
    }

    fun getPreviousCruisesFromDatabase():Flowable<CruiseInfo>{
        return dataSource.getAll()
    }*/

    fun getCurrentCruiseFromDatabase():Cruise{
        return Cruise()
    }

    fun getCurrentSailorsWatchFromDatabase():SailorsWatch{
        return SailorsWatch()
    }

}
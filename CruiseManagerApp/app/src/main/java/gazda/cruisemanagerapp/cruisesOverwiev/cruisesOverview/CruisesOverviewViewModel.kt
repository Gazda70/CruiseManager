package gazda.cruisemanagerapp.cruisesOverwiev.cruisesOverview

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import database.entities.CruiseInfo
import io.reactivex.rxjava3.core.Flowable

class CruisesOverviewViewModel() : ViewModel() {

    var cruises:ArrayList<CruiseInfo> = ArrayList<CruiseInfo>()

    fun getMyCruises():ArrayList<CruiseInfo>{
            if(cruises.isEmpty()){
                cruises = dummyCruises
            }
            return this.cruises
        }

    private var dummyCruises:ArrayList<CruiseInfo> = arrayListOf(
        CruiseInfo(
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
        CruiseInfo(
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
        CruiseInfo(
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

    fun getCurrentCruiseFromDatabase():CruiseInfo?{
        return CruiseInfo()
    }

}
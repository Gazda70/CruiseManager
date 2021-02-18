package gazda.cruisemanagerapp.cruisesOverwiev.cruiseOverviewFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import database.CruiseDatabase
import database.DAO.CruiseInfoDao
import database.entities.CruiseInfo
import io.reactivex.rxjava3.core.Flowable

class CruisesOverviewViewModel() : ViewModel() {
    // TODO: Implement the ViewModel
    private lateinit var dataSource: CruiseInfoDao

    var cruises:ArrayList<CruiseInfo> = ArrayList<CruiseInfo>()

    fun setDataSource(newDataSource:CruiseInfoDao){
        dataSource = newDataSource
    }

    fun getMyCruises():ArrayList<CruiseInfo>{
            if(cruises.isEmpty()){
                cruises = dummyCruises
            }
            return this.cruises
        }

    private var dummyCruises:ArrayList<CruiseInfo> = arrayListOf(
        CruiseInfo(
            0,
            "Rejs1",
            "30.12.2020",
            "Piotr Gazda",
            "\"Marzenie\""
        ),
        CruiseInfo(
            0,
            "Rejs2",
            "30.12.2020",
            "Bartosz Cichowski",
            "\"Pan Nocy\""
        ),
        CruiseInfo(
            0,
            "Rejs3",
            "30.12.2020",
            "Asia",
            "\"Morska Dama\""
        )
    )
    val addCruise: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

     fun getFutureCruisesFromDatabase():Flowable<CruiseInfo>{
        return dataSource.getAll()
    }

    fun getPreviousCruisesFromDatabase():Flowable<CruiseInfo>{
        return dataSource.getAll()
    }

    fun getCurrentCruiseFromDatabase():CruiseInfo?{
        return CruiseInfo()
    }

}
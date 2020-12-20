package gazda.cruisemanagerapp.cruisesOverwiev.cruiseOverviewFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CruisesOverviewViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    val addCruise: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

}
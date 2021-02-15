package gazda.cruisemanagerapp.cruisesOverwiev.cruiseOverviewFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import database.DAO.CruiseInfoDao

/**
 * Factory for ViewModels
 */
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val dataSource: CruiseInfoDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CruisesOverviewViewModel::class.java)) {
            return CruisesOverviewViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
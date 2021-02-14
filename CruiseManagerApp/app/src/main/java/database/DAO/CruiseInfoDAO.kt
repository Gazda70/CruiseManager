package database.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import database.entities.CruiseInfo

@Dao
interface CruiseInfoDao {
    @Query("SELECT * FROM CruiseInfo")
    fun getAll(): List<CruiseInfo>

    @Query("SELECT * FROM CruiseInfo WHERE cruiseId IN (:cruiseIds)")
    fun loadAllByIds(cruiseIds: IntArray): List<CruiseInfo>

    fun findByAnyName(cruise_Name: String?, cruise_Date: String?,
                      cruise_Captain: String?, cruise_Unit:String?){

    }
    @Query("SELECT * FROM CruiseInfo WHERE cruiseName LIKE :cruise_Name")
    fun findByCruiseName(cruise_Name: String): CruiseInfo

    @Query("SELECT * FROM CruiseInfo WHERE cruiseDate LIKE :cruise_Date")
    fun findByCruiseDate(cruise_Date: String): CruiseInfo

    @Query("SELECT * FROM CruiseInfo WHERE cruiseCaptain LIKE :cruise_Captain")
    fun findByCruiseCaptain(cruise_Captain: String): CruiseInfo

    @Query("SELECT * FROM CruiseInfo WHERE cruiseUnit LIKE :cruise_Unit")
    fun findByCruiseUnit(cruise_Unit: String): CruiseInfo

    @Insert
    fun insertAll(vararg cruises: CruiseInfo)

    @Delete
    fun delete(cruise: CruiseInfo)
}
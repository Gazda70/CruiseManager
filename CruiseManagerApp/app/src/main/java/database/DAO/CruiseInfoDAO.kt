package database.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import database.entities.CruiseInfo
import io.reactivex.rxjava3.core.Completable

import io.reactivex.rxjava3.core.Flowable

@Dao
interface CruiseInfoDao {
    @Query("SELECT * FROM CruiseInfo")
    fun getAll(): Flowable<CruiseInfo>

    @Query("SELECT * FROM CruiseInfo WHERE cruiseId IN (:cruiseIds)")
    fun loadAllByIds(cruiseIds: IntArray): Flowable<CruiseInfo>

    fun findByAnyName(cruise_Name: String?, cruise_Date: String?,
                      cruise_Captain: String?, cruise_Unit:String?){

    }
    @Query("SELECT * FROM CruiseInfo WHERE cruiseName LIKE :cruise_Name")
    fun findByCruiseName(cruise_Name: String): Flowable<CruiseInfo>

    @Query("SELECT * FROM CruiseInfo WHERE cruiseDate LIKE :cruise_Date")
    fun findByCruiseDate(cruise_Date: String): Flowable<CruiseInfo>

    @Query("SELECT * FROM CruiseInfo WHERE cruiseCaptain LIKE :cruise_Captain")
    fun findByCruiseCaptain(cruise_Captain: String): Flowable<CruiseInfo>

    @Query("SELECT * FROM CruiseInfo WHERE cruiseUnit LIKE :cruise_Unit")
    fun findByCruiseUnit(cruise_Unit: String): Flowable<CruiseInfo>

    @Insert
    fun insertAll(vararg cruises: CruiseInfo): Completable

    @Delete
    fun delete(cruise: CruiseInfo): Completable
}
package database.entities

import androidx.room.*
import database.entities.CruiseInfo.Companion.FULL_NAME


@Entity(
    indices = [Index(value = [FULL_NAME], unique = true)])
data class CruiseInfo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cruiseId")
    var id: Long = 0,
    var cruiseName:String,
    var cruiseDate:String,
    var cruiseCaptain:String,
    var cruiseUnit:String
){
    constructor() : this(0, "", "","","")

    companion object {
        const val FULL_NAME = "cruiseName"
    }
}
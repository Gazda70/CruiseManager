package database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CruiseInfo(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val cruiseName:String,
    val cruiseDate:String,
    val cruiseCaptain:String,
    val cruiseUnit:String
)
package database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import database.customDataTypes.RainFallState
import database.customDataTypes.WindDirection

@Entity
data class WeatherInfo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "weatherInfoId")
    var id: Long = 0,
    var windDirection: WindDirection,
    var windVelocity:Double,
    var windBofortStrength:Int,
    //add enumeration
    var seaState:Int,
    //add enumeration
    var cloudinessState:Int,
    var rainState: RainFallState,
    //add enumeration
    var visibility:Int,
    var atmosphericPressure:Double,
    var temperatureCelsius:Double
    )
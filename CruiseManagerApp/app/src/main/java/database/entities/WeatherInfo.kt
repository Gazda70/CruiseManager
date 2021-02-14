package database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WeatherInfo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "weatherInfoId")
    var id: Long = 0
)
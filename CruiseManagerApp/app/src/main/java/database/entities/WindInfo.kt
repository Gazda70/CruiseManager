package database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WindInfo (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "windInfoId")
    var id: Long = 0
)
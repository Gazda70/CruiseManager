package database.entities

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import database.customDataTypes.SailState

data class DriveInfo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "driveId")
    val id: Int = 0,
    var motorRotations:Double,
    var foresail:SailState,
    var mainsail:SailState
)
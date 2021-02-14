package database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LogBook(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "logBookId")
    var id: Long = 0
) {


}
package database.entities

import androidx.room.*
import androidx.room.ForeignKey.CASCADE

@Entity(foreignKeys = [
    ForeignKey(entity = CourseInfo::class,
        parentColumns = ["id"],
        childColumns = ["actualCourseInfoId"],
        onDelete = CASCADE),
    ForeignKey(entity = DriveInfo::class,
        parentColumns = ["id"],
        childColumns = ["actualDriveInfoId"],
        onDelete = CASCADE),
    ForeignKey(entity = WeatherInfo::class,
        parentColumns = ["id"],
        childColumns = ["actualWeatherInfoId"],
        onDelete = CASCADE)])
data class LogBook(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "logBookId")
    var id: Long = 0,
    var actualCourseInfoId:Long,
    var actualDriveInfoId:Long,
    var actualWeatherId:Long
)
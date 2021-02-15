package database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CourseInfo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "courseId")
    val id: Long = 0,
    var compassCourse:Double = 0.0,
    var declination:Double = 0.0,
    var deviation:Double = 0.0,
    var windLeewayPW:Double = 0.0,
    var waterCurrentLeewayPP:Double = 0.0,
    var wayOverBottomAngleKD:Double = 0.0,
    var velocityLogarithmic:Double = 0.0,
    var velocityMain:Double = 0.0
)
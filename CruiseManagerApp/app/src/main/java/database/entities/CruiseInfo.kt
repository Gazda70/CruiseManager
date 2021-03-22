package database.entities

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId

open class CruiseInfo : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var cruiseTitle: String? = null
    var cruiseName: String? = null
    var cruiseDate: String? = null
    var cruiseCaptain: String? = null
    var cruiseUnit: String? = null
    var cruiseParticipants: RealmList<AppUser>? = null
    var driveInfo: DriveInfo? = null
    var courseInfo: CourseInfo? = null
    var weatherInfo: WeatherInfo? = null

    constructor(
            cruiseTitle: String?,
            cruiseName: String?,
            cruiseDate: String?,
            cruiseCaptain: String?,
            cruiseUnit: String?,
            cruiseParticipants: RealmList<AppUser>?,
            driveInfo: DriveInfo?,
            courseInfo: CourseInfo?,
            weatherInfo: WeatherInfo?
    ){
        this.cruiseTitle = cruiseTitle
        this.cruiseName = cruiseName
        this.cruiseDate = cruiseDate
        this.cruiseCaptain = cruiseCaptain
        this.cruiseUnit = cruiseUnit
        this.cruiseParticipants = cruiseParticipants
        this.driveInfo = driveInfo
        this.courseInfo = courseInfo
        this.weatherInfo = weatherInfo
    }

    constructor() {} // RealmObject subclasses must provide an empty constructor
}
package database.entities

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId
import kotlin.time.Duration
import kotlin.time.ExperimentalTime

open class Cruise : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var cruiseTitle: String? = null
    var cruiseName: String? = null
    var cruiseDate: String? = null
    var cruiseCaptain: String? = null
    var cruiseUnit: String? = null
    var cruiseParticipants: RealmList<AppUser>? = null
    var drive: Drive? = null
    var course: Course? = null
    var weather: Weather? = null
    /*@ExperimentalTime
    var cruiseDuration:Duration? = null*/

    constructor(
        cruiseTitle: String?,
        cruiseName: String?,
        cruiseDate: String?,
        cruiseCaptain: String?,
        cruiseUnit: String?,
        cruiseParticipants: RealmList<AppUser>?,
        drive: Drive?,
        course: Course?,
        weather: Weather?
    ){
        this.cruiseTitle = cruiseTitle
        this.cruiseName = cruiseName
        this.cruiseDate = cruiseDate
        this.cruiseCaptain = cruiseCaptain
        this.cruiseUnit = cruiseUnit
        this.cruiseParticipants = cruiseParticipants
        this.drive = drive
        this.course = course
        this.weather = weather
    }

    constructor() {} // RealmObject subclasses must provide an empty constructor
}
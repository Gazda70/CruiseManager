package database.entities


import database.customDataTypes.RainFallState
import database.customDataTypes.WindDirection
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId

open class WeatherInfo: RealmObject{
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var windDirection: Int = 0
    var windVelocity: Double = 0.0
    var atmosphericPressure: Double = 0.0
    var temperatureCelsius: Double = 0.0
    var windBofortStrength: Int = 0
    //add enumeration
    var seaState: Int = 0
    //add enumeration
    var cloudinessState: Int = 0
    var rainState: Int = 0
    //add enumeration
    var visibility: Int = 0

    constructor(
            windDirection: Int,
            windVelocity: Double,
            atmosphericPressure: Double,
            temperatureCelsius: Double,
            windBofortStrength: Int,
            seaState: Int,
            cloudinessState: Int,
            rainState: Int,
            visibility: Int
    ){
        this.windDirection = windDirection
        this.windVelocity = windVelocity
        this.atmosphericPressure = atmosphericPressure
        this.temperatureCelsius = temperatureCelsius
        this.windBofortStrength = windBofortStrength
        this.seaState = seaState
        this.cloudinessState = cloudinessState
        this.rainState = rainState
        this.visibility = visibility
    }

    constructor() {} // RealmObject subclasses must provide an empty constructor
}
package database.entities

import io.realm.RealmObject
import org.bson.types.ObjectId
import io.realm.annotations.PrimaryKey

open class CourseInfo : RealmObject {
    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var compassCourse: Double = 0.0
    var declination: Double = 0.0
    var deviation: Double = 0.0
    var windLeewayPW: Double = 0.0
    var waterCurrentLeewayPP: Double = 0.0
    var wayOverBottomAngleKD: Double = 0.0
    var velocityLogarithmic: Double = 0.0
    var velocityMain: Double = 0.0

    constructor(
            compassCourse:Double,
            declination:Double,
            deviation: Double,
            windLeewayPW: Double,
            waterCurrentLeewayPP: Double,
            wayOverBottomAngleKD: Double,
            velocityLogarithmic: Double,
            velocityMain: Double
    ){

        this.compassCourse = compassCourse
        this.declination = declination
        this.deviation = deviation
        this.windLeewayPW = windLeewayPW
        this.waterCurrentLeewayPP = waterCurrentLeewayPP
        this.wayOverBottomAngleKD = wayOverBottomAngleKD
        this.velocityLogarithmic = velocityLogarithmic
        this.velocityMain = velocityMain
    }

    constructor(){}
}
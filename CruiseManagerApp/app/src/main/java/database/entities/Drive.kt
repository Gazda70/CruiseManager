package database.entities


import database.customDataTypes.SailState
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId

open class Drive : RealmObject{
        @PrimaryKey
        var _id: ObjectId = ObjectId()
        var motorRotations: Double = 0.0
        var foresail: Int = 0
        var mainsail: Int = 0

        constructor(
                motorRotations: Double,
                foresail: Int,
                mainsail: Int
        ){
                this.motorRotations = motorRotations
                this.foresail = foresail
                this.mainsail = mainsail
        }

        constructor() {} // RealmObject subclasses must provide an empty constructor
}
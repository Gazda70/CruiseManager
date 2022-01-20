package database.entities

import database.customDataTypes.SailorsWatchType
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId

open class SailorsWatch : RealmObject() {

    @PrimaryKey
    var _id: ObjectId = ObjectId()
    var type: Int = 0
    var nextWatchType: Int = 0
    var durationMinutes:Int = 0
}
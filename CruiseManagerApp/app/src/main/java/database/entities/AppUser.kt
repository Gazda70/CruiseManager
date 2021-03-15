package database.entities

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId


open class AppUser(
    @PrimaryKey var _id: ObjectId = ObjectId(),
    var name: String = "",
    var surname: String = ""
): RealmObject() {}
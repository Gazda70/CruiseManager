package database.entities

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

// providing default values for each constructor parameter
// fulfills the need for an empty constructor
open class AppUser: RealmObject{
    @PrimaryKey
    var _id:Long = 0L
    var name: String? = null
    var surname: String? = null

    constructor(
            _id:Long,
            name: String?,
            surname: String?
    ) {
        this._id = _id
        this.name = name
        this.surname = surname
    }

    constructor() {} // RealmObject subclasses must provide an empty constructor
}// To add an object to your Realm Schema, extend RealmObject
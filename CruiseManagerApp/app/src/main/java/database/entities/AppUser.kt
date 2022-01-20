package database.entities

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId


open class AppUser: RealmObject {
    @PrimaryKey var _id: ObjectId = ObjectId()
    var name: String? = null
    var surname: String? = null
    var actualCruise:Cruise? = null
    var futureCruises:RealmList<Cruise>? = RealmList()
    var pastCruises:RealmList<Cruise>? = RealmList()

    constructor(
        name: String,
        surname: String,
        actualCruise:Cruise?,
        futureCruises:RealmList<Cruise>?,
        pastCruises:RealmList<Cruise>?
    ) {
        this.name = name
        this.surname = surname
        this.actualCruise = actualCruise
        this.futureCruises = futureCruises
        this.pastCruises = pastCruises
    }
    constructor() {} // RealmObject subclasses must provide an empty constructor
}


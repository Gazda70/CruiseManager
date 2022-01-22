package database.entities

import io.realm.annotations.PrimaryKey
import org.bson.types.ObjectId

class CruiseLogEntry {
    //@PrimaryKey
    //var _id: ObjectId = ObjectId()
    var logEntryCreator: String = ""
    var logEntryTimestamp: String = ""

    constructor(
        logEntryCreator: String,
        logEntryTimestamp: String
    ){
        this.logEntryCreator = logEntryCreator
        this.logEntryTimestamp = logEntryTimestamp
    }

    constructor() {} // RealmObject subclasses must provide an empty constructor
}
package database.connection

import android.content.Context
import android.util.Log
import database.entities.AppUser
import gazda.cruisemanagerapp.MainActivity
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where
import io.realm.mongodb.App
import io.realm.mongodb.AppConfiguration
import io.realm.mongodb.Credentials
import io.realm.mongodb.User
import io.realm.mongodb.sync.SyncConfiguration

class AccountManager(private var context: Context) {


    fun manageLoginCredentials(name:String, surname:String):Boolean{
        val suchUser : RealmResults<AppUser> = RealmContainer.myRealm.where<AppUser>()
                .equalTo("name", name)
                .equalTo("surname", surname)
                .findAllAsync()
        if(suchUser.isEmpty())
        {
            return false
        }
        return true
    }

}
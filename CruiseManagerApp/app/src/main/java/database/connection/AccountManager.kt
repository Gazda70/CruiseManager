package database.connection

import android.content.Context
import io.realm.RealmResults
import io.realm.kotlin.where

class AccountManager(private var context: Context) {


    fun manageLoginCredentials(name:String, surname:String):Boolean{
        val suchUser : RealmResults<database.entities.AppUser> = RealmContainer.myRealm.where<database.entities.AppUser>()
                /*.equalTo("name", name)
                .equalTo("surname", surname)*/
                .findAll()
        if(suchUser.isEmpty())
        {
            return false
        }
        return true
    }

}
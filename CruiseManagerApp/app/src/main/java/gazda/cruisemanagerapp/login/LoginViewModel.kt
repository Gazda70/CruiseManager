package gazda.cruisemanagerapp.login

import android.content.Context
import androidx.lifecycle.ViewModel
import database.connection.AccountManager

class LoginViewModel() : ViewModel() {
    private lateinit var accountManager:AccountManager

    fun setAccountManager(myContext:Context){
        accountManager= AccountManager(myContext)
    }

    fun manageLoginCredentials(name:String, surname:String):Boolean{
        return this.accountManager.manageLoginCredentials(name, surname)
    }
}
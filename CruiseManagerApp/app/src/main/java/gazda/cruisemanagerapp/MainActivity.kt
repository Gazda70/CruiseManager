package gazda.cruisemanagerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import database.CruiseDatabase

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}
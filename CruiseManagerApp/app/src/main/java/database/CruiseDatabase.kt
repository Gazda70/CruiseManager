package database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import database.DAO.CruiseInfoDao
import database.auxilliary.Converters
import database.entities.CruiseInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [CruiseInfo::class], version = 1)
@TypeConverters(Converters::class)
abstract class CruiseDatabase : RoomDatabase() {
    abstract fun cruiseInfoDao(): CruiseInfoDao

    companion object {
        @Volatile private var INSTANCE: CruiseDatabase? = null

        fun getInstance(context: Context): CruiseDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                CruiseDatabase::class.java, "Sample.db")
                .build()
    }
}
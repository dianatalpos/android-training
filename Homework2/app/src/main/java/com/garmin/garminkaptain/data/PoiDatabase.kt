package com.garmin.garminkaptain.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [PointOfInterest::class, Review::class], version = 1)
abstract class PoiDatabase : RoomDatabase() {
    abstract fun getPoiDao(): PoiDao

    companion object {

        @Volatile
        private var INSTANCE: PoiDatabase? = null

        fun getInstance(context: Context): PoiDatabase {

            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PoiDatabase::class.java,
                        "poi_database"
                    )
                        .addCallback(roomListener)
                        .fallbackToDestructiveMigration()
                        .build()


                    INSTANCE = instance

                }
                return instance

            }
        }

        val roomListener = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                GlobalScope.launch {
                    INSTANCE?.let {
                        it.getPoiDao().insertAllPoi(poiList)
                        it.getPoiDao().insertAllReviews(reviews)
                    }
                }
            }
        }
    }
}
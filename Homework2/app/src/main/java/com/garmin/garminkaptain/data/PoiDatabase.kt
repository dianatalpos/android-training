package com.garmin.garminkaptain.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [PointOfInterest::class, Review::class, ReviewSummary::class, MapLocation::class], version = 2)
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
                        .addMigrations(MIGRATION_1_2)
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

val MIGRATION_1_2 = object: Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE `ReviewSummary` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `poiId` INTEGER NOT NULL, `averageRating` REAL NOT NULL," +
                    "`numberOfReviews` INTEGER NOT NULL)"
        )
        database.execSQL(
            "CREATE TABLE `MapLocation` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `poiId` INTEGER NOT NULL, `latitude` REAL NOT NULL," +
                    "`longitude` REAL NOT NULL)"
        )
        database.execSQL("""
               INSERT INTO ReviewSummary (poiId, averageRating, numberOfReviews)
                SELECT id, averageRating, numberOfReviews  FROM poi_table
                """.trimIndent())
        database.execSQL(
            """INSERT INTO MapLocation (poiId, latitude, longitude) 
                    SELECT id, latitude, longitude 
                    FROM poi_table""".trimIndent()
        )

        database.execSQL("""
            CREATE TABLE poi_backup (numberOfReviews INTEGER, poiType TEXT, latitude REAL, averageRating REAL, name TEXT, id INTEGER, longitude REAL)
        """.trimIndent())
        database.execSQL("""
            INSERT INTO poi_backup 
             SELECT numberOfReviews, poiType, latitude, averageRating, name, id, longitude 
             FROM poi_table
        """.trimIndent())
        database.execSQL("""
            drop table poi_table
        """.trimIndent())
        database.execSQL("""
            CREATE TABLE poi_table (poiType TEXT NOT NULL, name TEXT NOT NULL, id INTEGER PRIMARY KEY NOT NULL)
        """.trimIndent())
        database.execSQL("""
            INSERT INTO poi_table 
             SELECT poiType, name, id
             FROM poi_backup
        """.trimIndent())
        database.execSQL("""
            drop table poi_backup
        """.trimIndent())
    }
}
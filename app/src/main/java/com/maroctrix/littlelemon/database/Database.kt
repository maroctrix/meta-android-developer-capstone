package com.maroctrix.littlelemon.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Entity
data class MenuItemRoom(
    @PrimaryKey val id: Int = 0,
    val title: String = "",
    val description: String = "",
    val price: Double = 0.0,
    val image: String = "",
    val category: String = ""
)

@Dao
interface MenuItemDao {
    @Query("SELECT * FROM MenuItemRoom")
    fun getAll(): LiveData<List<MenuItemRoom>>

    @Insert
    fun insertAll(vararg menuItems: MenuItemRoom)

    @Query("SELECT * FROM MenuItemRoom WHERE id=:id ")
    fun getItem(id: String): LiveData<MenuItemRoom>

    @Query("SELECT (SELECT COUNT(*) FROM MenuItemRoom) == 0")
    fun isEmpty(): Boolean
}

@Database(entities = [MenuItemRoom::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun menuItemDao(): MenuItemDao
}
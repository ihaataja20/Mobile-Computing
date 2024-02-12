package com.example.mobilecomputing

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsertUser(user: User)

    @Delete
    fun deleteUser(user: User)

    @Query("SELECT * FROM user LIMIT 1")
    fun getUserFlow(): Flow<User>
}
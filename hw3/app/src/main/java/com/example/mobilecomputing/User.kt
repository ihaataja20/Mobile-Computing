package com.example.mobilecomputing

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(
    @PrimaryKey val uid: Int,
    val username: String
    //profile picture
)

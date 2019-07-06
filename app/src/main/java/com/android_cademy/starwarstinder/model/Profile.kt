package com.android_cademy.starwarstinder.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Profile(
        @PrimaryKey
        val name: String,
        @ColumnInfo(name = "url")
        var url: String,
        @ColumnInfo(name = "age")
        var age: Int,
        @ColumnInfo(name = "location")
        var location: String
)


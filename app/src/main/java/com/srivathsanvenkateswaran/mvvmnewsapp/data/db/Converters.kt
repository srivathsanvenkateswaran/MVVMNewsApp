package com.srivathsanvenkateswaran.mvvmnewsapp.data.db

import androidx.room.TypeConverter
import com.srivathsanvenkateswaran.mvvmnewsapp.data.remote.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name, name)
    }
}
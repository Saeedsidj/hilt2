package com.example.hilt1.DI

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import saman.zamani.persiandate.PersianDateFormat
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object persianDate {

    @Provides
    fun getDate(): PersianDateFormat {
        return PersianDateFormat("Y-m-d")
    }


}
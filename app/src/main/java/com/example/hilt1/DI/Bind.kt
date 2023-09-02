package com.example.hilt1.DI

import com.example.hilt1.EnglishGreeter
import com.example.hilt1.GermanyGreeter
import com.example.hilt1.Greet
import com.example.hilt1.PersianGreeter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named


@Module
@InstallIn(SingletonComponent::class)
abstract class Bind {

    @Binds
    @Named("Persian")
    abstract fun persiangreeting(persianGreeter: PersianGreeter):Greet

    @Binds
    @Named("English")
    abstract fun englishGreeting(englishGreeter: EnglishGreeter):Greet

    @Binds
    @Named("Germany")
    abstract fun germanyGreeting(germanyGreeter: GermanyGreeter):Greet
}
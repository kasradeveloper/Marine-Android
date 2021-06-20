package com.kasra.atency.data.model.user

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(@PrimaryKey(autoGenerate = true) @NonNull val id:Int)

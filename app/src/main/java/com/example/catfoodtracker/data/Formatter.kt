package com.example.catfoodtracker.data

import java.text.SimpleDateFormat
import java.util.*

object FoodTimeFormatter {
    fun timeToSimpleHours(time: Long): String {
        return SimpleDateFormat("hh:mm aa").format(time)
    }

}
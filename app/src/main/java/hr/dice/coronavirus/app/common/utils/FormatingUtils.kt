package hr.dice.coronavirus.app.common.utils

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun formatNumber(number: Int): String {
    return when {
        number < 9999 -> "$number"
        number < 999999 -> "${("%.1f".format(number / 1000.0))}K"
        else -> "${("%.1f".format(number / 1000000.0))}M"
    }
}

@RequiresApi(Build.VERSION_CODES.O)
fun formatDate(date: String): String {
    val formatter = DateTimeFormatter.ISO_ZONED_DATE_TIME
    val localedDate = LocalDate.parse(date, formatter)
    return "${localedDate.dayOfMonth}.${localedDate.monthValue}.${localedDate.year}"
}

package com.bookmarket

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.util.TimeZone

@SpringBootApplication
class Starter

fun main(vararg args: String) {
    runApplication<Starter>(*args)
    TimeZone.setDefault(TimeZone.getTimeZone("UTC"))
}

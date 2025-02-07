package com.cleanFood

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CleanFoodApplication

fun main(args: Array<String>) {
	runApplication<CleanFoodApplication>(*args)
}

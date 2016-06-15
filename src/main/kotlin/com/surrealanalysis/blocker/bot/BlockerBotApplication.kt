package com.surrealanalysis.blocker.bot

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class BlockerBotApplication

fun main(args: Array<String>) {
    SpringApplication.run(BlockerBotApplication::class.java, *args)
}

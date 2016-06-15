package com.surrealanalysis.blocker.bot

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Blocker(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,
        var description: String = "",
        var owner: String = "",
        var resolved: Boolean = false
)
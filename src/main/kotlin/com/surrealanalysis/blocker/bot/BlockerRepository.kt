package com.surrealanalysis.blocker.bot

import org.springframework.data.repository.CrudRepository

interface BlockerRepository : CrudRepository<Blocker, Long> {
    fun findAllByOwner(owner: String): List<Blocker>

    fun countByResolved(resolved: Boolean): Number

    fun findAllByResolved(resolved: Boolean): List<Blocker>
}
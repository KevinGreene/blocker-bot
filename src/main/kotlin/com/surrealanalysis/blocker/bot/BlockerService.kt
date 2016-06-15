package com.surrealanalysis.blocker.bot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BlockerService
@Autowired constructor(
        val blockerRepository: BlockerRepository
) {
    fun blockersRemaining(): Number {
        return blockerRepository.countByResolved(false)
    }

    fun blockerRemainingText(): String {
        return "${this.blockersRemaining()} blockers remain."
    }

    fun openBlockers(): List<Blocker> {
        return blockerRepository.findAllByResolved(false)
    }
}
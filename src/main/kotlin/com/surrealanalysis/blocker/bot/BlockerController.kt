package com.surrealanalysis.blocker.bot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class BlockerController
@Autowired constructor(
        val blockerRepository: BlockerRepository,
        val blockerService: BlockerService
) {
    @RequestMapping("/")
    fun processSlackMessage(slackMessage: SlackMessage): String {
        if (slackMessage.text == "list") {
            val messages = blockerService.openBlockers().map { it -> this.createBlockerMessage(it) }
            return messages.joinToString("\n")
        } else {
            val (command, text) = slackMessage.text.split(Regex("\\s+"), 2)
            val result: String = when (command) {
                "create" -> {
                    var blocker: Blocker =
                            Blocker(
                                    description = text,
                                    owner = slackMessage.user_name
                            )
                    blocker = blockerRepository.save(blocker)
                    "${blocker.owner} created blocker ${blocker.id}: ${blocker.description}. ${blockerService.blockerRemainingText()}"
                }
                "resolve" -> {
                    val blockerId: Long = text.toLong()
                    val blocker: Blocker = blockerRepository.findOne(blockerId)
                    blocker.resolved = true
                    blockerRepository.save(blocker)
                    return "Resolved blocker with ID ${blockerId}. ${blockerService.blockerRemainingText()}"
                }
                else -> "Sorry, we don't know that command"
            }
            return result;
        }
    }

    fun createBlockerMessage(blocker: Blocker): String {
        return "${blocker.id}) ${blocker.owner} created ${blocker.description}"
    }

}
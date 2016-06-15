package com.surrealanalysis.blocker.bot

import spock.lang.Specification

class BlockerControllerTest extends Specification {
    BlockerController controller
    BlockerRepository repository = Mock(BlockerRepository)

    def setup() {
        controller = new BlockerController(repository)
    }

    def "ProcessSlackMessage"() {

        when:
        def response = controller.processSlackMessage(new SlackMessage())

        then:
        response == "IT WORKS!"

    }
}

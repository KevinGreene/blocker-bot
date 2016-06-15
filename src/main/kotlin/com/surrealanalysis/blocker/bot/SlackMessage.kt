package com.surrealanalysis.blocker.bot

class SlackMessage(
        var token: String = "",
        var team_id: String = "",
        var team_domain: String = "",
        var channel_id: String = "",
        var user_id: String = "",
        var user_name: String = "",
        var command: String = "",
        var text: String = "",
        var response_url: String = ""
)

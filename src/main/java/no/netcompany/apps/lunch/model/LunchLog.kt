package no.netcompany.apps.lunch.model

data class LunchLog(val person: Person?,
                    val events: List<LunchEvent> = emptyList())
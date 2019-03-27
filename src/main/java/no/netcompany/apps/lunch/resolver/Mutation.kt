package no.netcompany.apps.lunch.resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import no.netcompany.apps.lunch.model.LunchEvent
import org.springframework.stereotype.Component

@Component
class Mutation: GraphQLMutationResolver {
    fun registerEvent(event: LunchEvent?): LunchEvent? {
        return null
    }
}
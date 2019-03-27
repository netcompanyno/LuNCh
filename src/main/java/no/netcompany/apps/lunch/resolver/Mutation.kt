package no.netcompany.apps.lunch.resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import no.netcompany.apps.lunch.model.LunchEvent
import no.netcompany.apps.lunch.service.RegistrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class Mutation(@Autowired private val registrationService: RegistrationService): GraphQLMutationResolver {
    fun registerEvent(uid: String): LunchEvent? {
        return registrationService.createEvent(uid)
    }
}
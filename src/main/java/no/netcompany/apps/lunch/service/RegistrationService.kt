package no.netcompany.apps.lunch.service

import com.google.api.core.ApiFuture
import com.google.api.core.SettableApiFuture
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import no.netcompany.apps.lunch.model.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.io.IOException

@Component
class RegistrationService(@Autowired private val firebaseDatabase: FirebaseDatabase) {

    fun getPersons(): ApiFuture<List<Person>> {
        val personsFuture = SettableApiFuture.create<List<Person>>()

        val ref = firebaseDatabase.getReference("persons")
        ref.addListenerForSingleValueEvent(object: ValueEventListener {
            override fun onCancelled(error: DatabaseError?) {
                personsFuture.setException(IOException(error?.message))
            }

            override fun onDataChange(snapshot: DataSnapshot?) {
                val persons = snapshot?.children?.map { it.getValue(Person::class.java) } ?: emptyList()
                personsFuture.set(persons)
            }
        })

        return personsFuture
    }
}
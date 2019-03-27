package no.netcompany.apps.lunch.configuration

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.database.FirebaseDatabase
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.io.IOException

@Configuration
class FirebaseConfiguration {

    @Value("\${DATABASE_URL}")
    private lateinit var databaseUrl: String

    @Bean
    @Throws(IOException::class)
    fun firebaseDatabase(): FirebaseDatabase {
        val classLoader = Thread.currentThread().contextClassLoader
        val serviceAccount = classLoader.getResourceAsStream("service-account.json")
        val options = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl(databaseUrl)
                .build()

        FirebaseApp.initializeApp(options)
        return FirebaseDatabase.getInstance()
    }
}

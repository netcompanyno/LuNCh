package no.netcompany.apps.lunch.model

data class Person(val shortName: String? = null,
                  val fullName: String? = null,
                  val serialNumber: String? = null,
                  val imageUrl: String? = null,
                  val isActive: Boolean = true)
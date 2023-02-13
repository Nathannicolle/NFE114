package fr.caensup.offresemploi.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
open class Entreprise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    open var id: Int? = null

    @Column(length = 80, nullable = false, unique = true)
    open lateinit var rs: String

    @Column(length = 255)
    open var adresse : String?=null

    @Column(length = 5)
    open var cp : String?=null

    @Column(length = 80)
    open var ville : String?=null

    @Column(length = 10)
    open var tel : String?=null


}
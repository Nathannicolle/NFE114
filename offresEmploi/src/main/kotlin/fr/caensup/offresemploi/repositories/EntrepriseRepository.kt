package fr.caensup.offresemploi.repositories

import fr.caensup.offresemploi.entities.Entreprise
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface EntrepriseRepository:CrudRepository<Entreprise, Int> {

}
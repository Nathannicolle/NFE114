package fr.caensup.offresemploi.controllers

import fr.caensup.offresemploi.entities.Entreprise
import fr.caensup.offresemploi.repositories.EntrepriseRepository
import jakarta.websocket.server.PathParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.ModelMap
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.servlet.view.RedirectView

@Controller
@RequestMapping("/entreprise")
class EntrepriseController {
    @Autowired
    lateinit var entrepriseRepository: EntrepriseRepository

    // Deux possibilité d'url /entreprise ou /entreprise/index
    @RequestMapping(path = ["", "index"])
    fun indexAction(model: ModelMap): String {
        var entreprises = entrepriseRepository.findAll()
        model["entreprise"] = entreprises
        return "/entreprise/index"
    }

    @GetMapping("/new")
    fun newAction(model : ModelMap) : String {
        model["entreprise"] = Entreprise();
        return "/entreprise/form";
    }

    @PostMapping("/new")
    fun newSubmitAction(@ModelAttribute entreprise: Entreprise) : RedirectView {
        entrepriseRepository.save(entreprise)
        return RedirectView("/entreprise");
    }

    @GetMapping("/edit/{id}")
    fun editEntreprise(@PathVariable id : Int, model : ModelMap) : String
    {
        var entrepriseByID = entrepriseRepository.findById(id);
        // model.addAttribute("entrepriseByID", entrepriseByID);
        model["specificEntreprise"] = entrepriseByID;
        return "/entreprise/edit";
    }

    @PostMapping("/update/{id}")
    fun updateEntreprise(@PathVariable id : Int, entrepriseSubmitted: Entreprise) : RedirectView? {
        if (entrepriseRepository.existsById(id)) {
            entrepriseRepository.save(entrepriseSubmitted);
        }
        return RedirectView("/entreprise");
    }

    @GetMapping("/delete/{id}")
    fun deleteEntreprise(@PathVariable id : Int) : RedirectView
    {
        entrepriseRepository.deleteById(id);
        return RedirectView("/entreprise");
    }
}
package src.main.kotlin.fr.caensup.contacts.contacts.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HelloController {
    @RequestMapping("/")
    fun indexAction() : String {
        return "index";
    }

    @RequestMapping("/hello")
    @ResponseBody
    function helloAction() : String {
        return "Hello world !!!";
    }

    @GetMapping("msg/{content}")
    fun msgAction(@PathVariable("content") c : String) :String {
        return "<h2>Message : </h2> <p>${c}</p>";
    }
}
package com.example.warikan.api

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/")
class Top {
    @GetMapping
    fun redirectToSwaggerUi() = "redirect:/swagger-ui.html"
}
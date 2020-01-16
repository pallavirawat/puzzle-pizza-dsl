package com.thoughtworks.workshop.kotlin.pizza

class FarmHouse : Pizza {
    override val name: String = "Farm House"
    override val dough: String = "Regular"
    override val toppings: List<String> = listOf("Onion", "Tomato", "Mushroom")
    override val price: Double = 200.0
}


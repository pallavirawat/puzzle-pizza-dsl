package com.thoughtworks.workshop.kotlin.cmd.pizza

import com.thoughtworks.workshop.kotlin.pizza.Dough
import com.thoughtworks.workshop.kotlin.pizza.FarmHouse
import com.thoughtworks.workshop.kotlin.pizza.Pizza
import com.thoughtworks.workshop.kotlin.pizza.Topping
import com.thoughtworks.workshop.kotlin.pizza.description

object CheeseBurst{
    var finalPizza: Pizza = FarmHouse()
    infix fun farmHouse(pizza: Pizza): Pizza {
        finalPizza = Dough(pizza, "Cheese burst", 20.00)
        return finalPizza
    }
}

var pizzaOnWhichToppingsWouldBePut: Pizza = FarmHouse()

fun pizza(block: (Pizza) -> Unit) : Pizza{
    val pizza = FarmHouse()
    block(pizza)
    return pizzaOnWhichToppingsWouldBePut
}


infix fun Pizza.with(topping: String) {
    pizzaOnWhichToppingsWouldBePut = Topping(this, topping)
}

fun main() {
    /*
    val pizza: Pizza = CheeseBurst FarmHouse pizza {
        topped with "Golden corn"
    }

    println(pizza.description())
    */

    val pizza = CheeseBurst farmHouse pizza {
        pizzaOnWhichToppingsWouldBePut with "Golden Corn"
        pizzaOnWhichToppingsWouldBePut with "Chicken"
    }

    println(pizza.description())

}


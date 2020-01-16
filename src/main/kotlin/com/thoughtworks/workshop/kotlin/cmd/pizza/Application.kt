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

object Just{
    var finalPizza: Pizza = FarmHouse()
    infix fun farmHouse(pizza: Pizza): Pizza {
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
    val pizza: Pizza = FarmHouse()

    //Part 1
    val bakedPizza = CheeseBurst farmHouse pizza {
        pizzaOnWhichToppingsWouldBePut with "Golden Corn"
        pizzaOnWhichToppingsWouldBePut with "Chicken"
    }
    println(bakedPizza.description())

    //Part 2
    val simplyBakedPizza = CheeseBurst farmHouse pizza
    println(simplyBakedPizza.description())

    //Part 3
    val plainPizza = Just farmHouse pizza
    println(plainPizza.description())

}


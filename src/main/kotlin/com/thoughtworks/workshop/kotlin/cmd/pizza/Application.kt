package com.thoughtworks.workshop.kotlin.cmd.pizza

import com.thoughtworks.workshop.kotlin.pizza.Dough
import com.thoughtworks.workshop.kotlin.pizza.FarmHouse
import com.thoughtworks.workshop.kotlin.pizza.Pizza
import com.thoughtworks.workshop.kotlin.pizza.Topping
import com.thoughtworks.workshop.kotlin.pizza.description

object CheeseBurst{
    infix fun farmHouse(toppedPizza: Pizza): Pizza {
        return Dough(toppedPizza, "Cheese burst", 20.00)
    }
}

object Just{
    var finalPizza: Pizza = FarmHouse()
    infix fun farmHouse(pizza: Pizza): Pizza {
        return finalPizza
    }
}

class PizzaBuilder{
    var base: Pizza = FarmHouse()
}


fun pizza(block: PizzaBuilder.() -> Pizza) : Pizza{
    val pizza = PizzaBuilder()
    val topping = block(pizza)
    pizza.base = topping
    return pizza.base
}

infix fun PizzaBuilder.with(topping: String): Pizza {
    base = Topping(base, topping)
    return base
}

fun main() {
    /*
    val pizza: Pizza = CheeseBurst FarmHouse pizza {
        topped with "Golden corn"
    }

    println(pizza.description())
    */
    val pizza: Pizza = FarmHouse()
    val topped = PizzaBuilder()

    //Part 1
    val bakedPizza = CheeseBurst farmHouse pizza {
        topped with "Golden Corn"
        topped with "Chicken"
    }
    println(bakedPizza.description())

    //Part 2
    val simplyBakedPizza = CheeseBurst farmHouse pizza
    println(simplyBakedPizza.description())

    //Part 3
    val plainPizza = Just farmHouse pizza
    println(plainPizza.description())

}


package com.thoughtworks.workshop.kotlin.cmd.pizza

import com.thoughtworks.workshop.kotlin.pizza.Dough
import com.thoughtworks.workshop.kotlin.pizza.FarmHouse
import com.thoughtworks.workshop.kotlin.pizza.Pizza
import com.thoughtworks.workshop.kotlin.pizza.description

var finalPizza: Pizza = FarmHouse()

object CheeseBursts{
    var fpizza: Pizza = FarmHouse()
    infix fun farmHouse(pizza: Pizza): Pizza {
        fpizza = Dough(pizza, "Cheese burst", 20.00)
        return fpizza
    }
}

fun pizza(block: (Pizza) -> Unit) : Pizza{
    val pizza = FarmHouse()
    block(pizza)
    return pizza
}

fun main() {
    /*
    val pizza: Pizza = CheeseBurst FarmHouse pizza {
        topped with "Golden corn"
    }

    println(pizza.description())
    */

    val topped: Pizza = FarmHouse()

    val pizza = CheeseBursts farmHouse pizza {
    }

    println(pizza.description())

}

//infix fun Pizza.withh(topping: String){
//    finalPizza = Topping(finalPizza, topping)
//}
//fun pizza(block: Pizza.() -> Unit): Pizza {
//    block(finalPizza)
//    return finalPizza
//}

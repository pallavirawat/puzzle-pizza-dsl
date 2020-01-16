package com.thoughtworks.workshop.kotlin.cmd.pizza

import com.thoughtworks.workshop.kotlin.pizza.FarmHouse
import com.thoughtworks.workshop.kotlin.pizza.Pizza
import com.thoughtworks.workshop.kotlin.pizza.Topping
import com.thoughtworks.workshop.kotlin.pizza.description

object CheeseBursts{
    var pizza = FarmHouse()
    infix fun farmHouse(pizza: Pizza): Pizza{
        return pizza
    }
}

var finalPizza: Pizza = FarmHouse()

fun main() {
    /*
    val pizza: Pizza = CheeseBurst FarmHouse pizza {
        topped with "Golden corn"
    }

    println(pizza.description())
    */

    val topped: Pizza = FarmHouse()
//    val pizza: Pizza = pizza {
//        topped withh "Golden corn"
//        topped withh "Pineapple"
//    }
//    println(pizza.description())

    CheeseBursts farmHouse pizza {
        topped withh "Golden Corn"

    }
}

infix fun Pizza.withh(topping: String){
    finalPizza = Topping(finalPizza, topping)
}
fun pizza(block: Pizza.() -> Unit): Pizza {
    block(finalPizza)
    return finalPizza
}

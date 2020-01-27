package com.thoughtworks.workshop.kotlin.cmd.pizza

import com.thoughtworks.workshop.kotlin.pizza.Dough
import com.thoughtworks.workshop.kotlin.pizza.FarmHouse
import com.thoughtworks.workshop.kotlin.pizza.Pizza
import com.thoughtworks.workshop.kotlin.pizza.Topping
import com.thoughtworks.workshop.kotlin.pizza.description

object CheeseBurst{
    infix fun farmHouse(toppedPizza: Pizza): Pizza {
        return Dough.cheeseBurst(toppedPizza)
    }
}

object Just{
    infix fun farmHouse(pizza: Pizza): Pizza {
        return FarmHouse()
    }
}

class PizzaBuilder{
    private var base: Pizza = FarmHouse()

    infix fun Topped.with(topping: String) {
        base = Topping(base, topping)
    }

    fun build(): Pizza {
        return base
    }


}

//function type with receiver.
//This means that we need to pass an instance of type PizzaBuilder (a receiver) to the function,
//and we can call members of that instance inside the function.
fun pizza(block: PizzaBuilder.() -> Unit) : Pizza = PizzaBuilder().apply(block).build()

object Topped

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
        Topped with "Golden Corn"
        Topped with "Chicken"
    }

    println(bakedPizza.description())

    //Part 2
    val simplyBakedPizza = CheeseBurst farmHouse pizza
    println(simplyBakedPizza.description())

    //Part 3
    val plainPizza = Just farmHouse pizza
    println(plainPizza.description())

}


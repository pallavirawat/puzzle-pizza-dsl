# Get me a pizza (using DSL)

## How to make a pizza without DSL

- Interface `Pizza`
The `Pizza` interface defines basic properties of a pizza.
```kotlin
    interface Pizza {
        //...
    }
    
    //Provides description of a pizza
    fun Pizza.description() : String {
        //...
    }
```

- A simple Farm House pizza can be created using `class FarmHouse`.
```kotlin
    class FarmHouse : Pizza {
       //...
    }
 
    val pizza = FarmHouse()

    println(pizza.description()) //Prints ..
    //A Farm House pizza with Regular base, topped with Onion, Tomato, Mushroom and priced at 200.0
```

- A simple pizza can be customized using decorators.
  1. To use different base for any pizza, wrap the pizza object in a `Dough` decorator.
     ```kotlin
        //Simple Farm House pizza
        val pizza: Pizza = FarmHouse()
     
        //Cheese Burst Farm House pizza - costs additional 75
        val cheeseBurstPizza: Pizza = Dough(pizza = pizza, dough = "Cheese Burst", cost = 75.0)
     
        println(cheeseBurstPizza.description()) //Prints ...
        //A Farm House pizza with Cheese Burst base, topped with Onion, Tomato, Mushroom and priced at 275.0
     ```  
  2. To add a topping, wrap the pizza object in a `Topping` decorator. With each topping price increases by 20.
     ```kotlin
        //Simple Farm House pizza
        val pizza: Pizza = FarmHouse()
             
        //Farm House pizza with Golden corn - costs additional 20
        val farmHouseWithCorn: Pizza = Topping(pizza = pizza, type = "Golden Corn")
             
        println(farmHouseWithCorn.description()) //Prints ...
        //A Farm House pizza with Regular base, topped with Onion, Tomato, Mushroom, Golden Corn and priced at 220.0
     ```
  Example: *Cheese burst* *Farm House* pizza topped with *Golden corn*
  ```kotlin
  val pizza = Dough( dough = "Cheese Burst", cost = 75.0,
          pizza = Topping( type = "Golden corn", pizza = FarmHouse()
      )
  )
  ```

## Puzzle: 
### Implement a Kotlin DSL to make a pizza with choice of dough and toppings

With the help of DSL, one should be able to make a pizza as shown in code below.
```kotlin
    val pizza: Pizza = CheeseBurst Farmhouse pizza {
        topped with "Golden corn"
    }

    println(pizza.description()) //Prints ...
    //A Farmhouse pizza with Cheese Burst base, topped with Onion, Tomato, Mushroom, Golden corn and priced at 295.0
```
Note:
* You cannot change any code in package `com.thoughtworks.workshop.kotlin.pizza`. 
* Implement your Dsl in Dsl.kt file. 
* Uncomment sample dsl usage in `main` function.


### Bonus points
1. Allow user to make pizza without additional toppings
    ```kotlin
       val pizza: Pizza = CheeseBurst Farmhouse pizza
    ```

2. Allow user to make pizza with regular dough
    ```kotlin
       val pizza: Pizza = Just Farmhouse pizza
    ```
3. Make DSL extendable to support different dough types such as Thin crust and basic pizzas like Pepperoni.


```text

+-----------------------------------------------------------------------+
|                                                                       |
|  +------------------------------------------------+                   |
|  |  +------------------------------+              |                   |
|  |  |    +-----------+             |              |                   |
|  |  |    |           |             |              |                   |
|  |  |    | Farmhouse | Topping 1   | Topping 2    | Dough             |
|  |  |    | Pizza     |             |              | ex. Cheeseburst   |
|  |  |    |           |             |              |                   |
|  |  |    |           |             |              |                   |
|  |  |    +-----------+             |              |                   |
|  |  |                              |              |                   |
|  |  +------------------------------+              |                   |
|  +------------------------------------------------+                   |
|                                                                       |
+-----------------------------------------------------------------------+

```

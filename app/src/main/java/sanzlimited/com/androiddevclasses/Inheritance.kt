package sanzlimited.com.androiddevclasses

interface Shape {
    fun computeArea() : Double
}

class Circle(private val radius: Double) : Shape {
    override fun computeArea(): Double {
        return Math.PI * radius * radius
    }
}

/**
 * Kotlin classes aren't subclassable by default
 * Use 'open' keyword to allow subclassing
 * Properties and functions are redefined with the override keyword
 */
open class Animal(val name: String) {
    protected val paws: Int = 4 //protected is the same as private, but will also be visible to any subclasses
    open fun makeSound() {
        println("$name makes a sound")
    }
}
class Dog(name: String) : Animal(name) {
    override fun makeSound() {
        println("$name barks")
    }
}
class Cat(name: String) : Animal(name) {
    override fun makeSound() {
        println("$name meows and has $paws paws")
    }
}

/**
 * Abstract classes are marked as abstract
 * They can't be instantiated, and must be subclassed
 * Similar to an interface with the added ability to store state
 * Properties and functions marked with abstract must be overridden
 * Can include non-abstract properties and functions
 */
abstract class Food {
    abstract val kcal: Int
    abstract val name: String
    fun consume() = println("I'm eating $name")
}
class Pizza(): Food() {
    override val kcal = 600
    override val name = "Pizza"
}


/**
 * If you want to add functions to an existing class that you can't modify directly, then you can do the following
 * Not: you can't access private instance variables and you're not actually modifying the existing class
 */
fun Int.isOdd(): Boolean { return this % 2 == 1}

fun main() {
    val c = Circle(3.0)
    println(c.computeArea())

    val dog = Dog("Buddy")
    val cat = Cat("Whiskers")
    dog.makeSound()
    cat.makeSound()

    val p = Pizza()
    p.consume()

    println(3.isOdd())
}

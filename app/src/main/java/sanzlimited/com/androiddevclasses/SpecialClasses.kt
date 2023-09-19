package sanzlimited.com.androiddevclasses

import android.graphics.Color
import androidx.core.graphics.red

/**
 * Data class is a special type of class that's used to only store a set of data - marked with data keyword
 * Generates getters for each property and setters for variables.
 * Generates toString(), equals(), hashCode() and copy() methods, and destructing operators.
 * It makes code more concise
 */

data class Player(val name: String, val score: Int)



fun main() {
    val firstPlayer = Player("Steve", 10)
    println(firstPlayer)
    println(firstPlayer.name)
    println(firstPlayer.score)

    /**
     * Pair and Triple are predefined data classes that store 2 or 3 pieces of data respectively
     * Access variables with .first, .second and .third
     * Usually named data classes are a better option
     */
    val bookAuthor = Pair("Harry Potter", "J.K. Rowling")
    println(bookAuthor)
    val bookAuthorYear = Triple("Harry Potter", "J.K. Rowling", 1997)
    println(bookAuthorYear)
    println(bookAuthorYear.third)

    // If you want another way to do Pair which is more readable then you can do the following:
    val book1 = "Harry Potter" to "J.K. Rowling"
    println(book1)

    //can be used in a Map or HashMap
    val map = mapOf(1 to "x", 2 to "y", 3 to "zz")
    println(map)

    //Testing the Enum class
    println("" + Colour.RED.r + " " + Colour.RED.g + " " + Colour.RED.b)

    //Testing object
    println(Calculator.add(2, 16))
}



/**
 * Enum Classes are like what is in Java, with slight different syntax
 */
enum class Colour(val r: Int, val g: Int, val b:Int){
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255)
}

/**
 * If you want only one instance of a class to ever exist, then use the object keyword instead of class keyword.
 * Also known as a singleton.
 * The Singleton instance is created lazily, meaning it's initialized only when it's first accessed. This provides efficiency and thread safety, as the Kotlin compiler takes care of the necessary synchronization.
 * You can access the Singleton instance directly without the need for a getInstance() method, making it concise and easy to use.
 */
object Calculator {
    fun add(n1: Int, n2: Int) : Int {
        return n1 + n2
    }
}

/**
 * Companion objects are a type of object that is tied to a class rather than an instance of the class.
 * Allows you to define static members (properties and functions) that are associated with the class itself rather than with instances of the class.
 * It is typically used to define utility functions, constants or factory methods related to the class.
 * It's a way to organise and encapsulate class-level functionality, constants, and factory methods, making code more readable and maintainable
 */
class MyClass(private val data: Int) {
    companion object {
        //static properties and functions
        val someProperty = "Hello world!"

        fun someFunction() {
            println("This is a static function")
        }

        fun createWithDefaultData() = MyClass(26) //default factory method - useful for design patters such as Factory Method or Builder patterns.
    }
}
class MathUtils {
    companion object {
        const val PI = 3.14159265359 //static constant
    }
}
class StringUtil {
    companion object {
        fun isNullOrEmpty(value: String?) = value.isNullOrEmpty()
    }
}
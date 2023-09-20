package sanzlimited.com.androiddevclasses

import java.util.Arrays


fun main() {
    //SLIDE 9
    val numbers = intArrayOf(1,2,3)
    val numbers2 = intArrayOf(4,5,6)
    val combined = numbers2 + numbers
    println(combined.contentToString())
    //=> [4, 5, 6, 1, 2, 3]


    //SLIDE 10
    val guests = 30
    if (guests == 0){
        println("No guests")
    } else if (guests < 20) {
        println("Small group of people")
    } else {
        println("Large group of people!")
    }
    // => Large group of people!



    val pets = arrayOf("dog", "cat", "canary")
    for (element in pets) {
        print("$element ")
    }
    // => dog cat canary


    var bicycles = 0
    while (bicycles < 50) {
        bicycles++
    }
    println("$bicycles bicycles in the bicycle rack\n")
    // => 50 bicycles in the bicycle rack

    do{
        bicycles --
    } while (bicycles > 50)
    println("$bicycles bicycles in the bicycle rack\n")
    // => 49 bicycles in the bicycle rack



    val numberOfStudents = 50
    if (numberOfStudents in 1..100) {
        println(numberOfStudents)
    }
    // => 50

    val results = 60
    when (results){
        0 -> println("No results")
        in 1..39 -> println("Got results!")
        else -> println("That's a lot of results!")
    }
    // => That's a lot of results!

    //SLIDE 11
    var numberOfBooks: Int? = null
    val s: String
    //val len = s!!.length
    numberOfBooks = numberOfBooks?.dec() ?: 0


    //SLIDE 12
    fun printHello(name: String?): Unit {
        println("Hi there!")
    }


    fun tempToday(day: String, temp: Int) {
        println("Today is $day and it's $temp degrees.")
    }

    fun reformat(str: String, divideByCamelHumps: Boolean, wordSeperator: Char,
                 normaliseCase: Boolean = true){
    }

    fun double(x: Int): Int {
        return x * 2
    }
    fun doubleV2(x:Int): Int = x * 2


    var dirtLevel = 20
    val waterFilter = {level: Int -> level / 2}
    println(waterFilter(dirtLevel))
    // => 10


    fun encodeMsg(msg: String, encode: (String) -> String): String {
        return encode(msg)
    }
    fun enc2(input: String): String = input.reversed()
    encodeMsg("abc", ::enc2)



    //SLIDE 13
    val ints = listOf(1, 2, 3)
    ints.filter { it > 0 }


    val numberSet = setOf(1, 2, 3)
    println(numberSet.map { it * 3 })
    // => [3, 6, 9]


    val numberSets = listOf(setOf(1, 2, 3), setOf(4, 5), setOf(1, 2))
    println(numberSets.flatten())
    // => [1, 2, 3, 4, 5, 1, 2]


    val instruments = listOf("trumpet", "cello", "violin")
    val eager = instruments.filter { it[0] == 'v' }
    println("eager: $eager")
    // => eager: [violin]


    val instrumentsV2 = listOf("viola", "cello", "violin")
    val filtered = instruments.asSequence().filter { it[0] == 'v' }
    println("filtered: $filtered")
    // => filtered: kotlin.sequences.FilteringSequence@5419f379

    val filteredV2 = instruments.asSequence().filter { it[0] === 'v' }
    val newList = filteredV2.toList()
    println("new list: $newList")
    // => new list: [viola, violin]
}
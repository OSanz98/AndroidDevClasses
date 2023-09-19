package sanzlimited.com.androiddevclasses

class House(colour: String, noOfWindows: Int = 2, houseStreet: String, housePostcode: String) {
    var colour: String
    private val numberOfWindows: Int
    val isForSale: Boolean = false
    private val houseStreet: String
    private val housePostcode: String
    val houseAddress: String
        get() {
            return "$houseStreet $housePostcode"
        }

    /**
     * Multiple init blocks are allowed
     * init blocks become the body of the primary constructor
     * */
    init {
        this.colour = colour
        this.numberOfWindows = noOfWindows
        this.houseStreet = houseStreet
        this.housePostcode = housePostcode
    }

    fun updateColour(newColour: String) {
        this.colour = newColour
    }
}

fun main(){
    val house = House("blue", housePostcode = "E1 JKL", houseStreet = "Monument")

    // set colour differently
    println(house.colour)
    house.colour = "red"
    println(house.colour)
    house.updateColour("green")
    println(house.colour)

    //print override getter
    println("street address is: ${house.houseAddress}")
}

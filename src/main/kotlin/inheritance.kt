import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)

    println(squareCabin)
    println(roundHut)
    println(roundTower)
}

abstract class Dwelling(private var residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    fun getRoom() {
        if (hasRoom()) {
            residents++
            println("You got a room!")
        } else {
            println("Sorry, at capacity and no rooms left.")
        }
    }

    abstract fun floorArea(): Double
    override fun toString(): String {
        return """
            
            ${this.javaClass.name}
            =========
            Capacity: $capacity
            Material: $buildingMaterial
            Has room? ${hasRoom()}
            floorArea: %.2f
        """.trimIndent().format(floorArea())
    }
}

class SquareCabin(
    residents: Int,
    private val length: Double
) : Dwelling(residents) {

    override val buildingMaterial = "Wood"
    override val capacity = 6

    override fun floorArea(): Double {
        return length * length
    }
}

open class RoundHut(
    residents: Int,
    private val radius: Double
) : Dwelling(residents) {

    override val buildingMaterial = "Straw"
    override val capacity = 4

    override fun floorArea(): Double {
        return PI * radius * radius
    }

    private fun calculateMaxCarpetLength(): Double {
        return sqrt(2.0) * radius
    }

    override fun toString(): String {
        return super.toString() + "\nCarpet size: %.2f".format(calculateMaxCarpetLength())
    }
}

class RoundTower(
    residents: Int,
    radius: Double,
    private val floors: Int = 2
) : RoundHut(residents, radius) {
    override val buildingMaterial = "Stone"
    override val capacity = 4 * floors

    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}
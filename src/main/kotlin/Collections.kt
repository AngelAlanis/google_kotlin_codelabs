fun main() {
    val triple: (Int) -> Int = { it * 3 }
    println(triple(5))

    val peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")
    println(peopleNames.sorted())

    // Sort names by length
    println(peopleNames.sortedWith { str1: String, str2: String ->
        str1.length - str2.length
    })
}

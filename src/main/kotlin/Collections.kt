fun main() {
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    println(peopleAges)

    // Two ways of adding values to the map
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51

    // Replacing the value of the key 'Fred'
    peopleAges["Fred"] = 31

    println(peopleAges)

    // Make a forEach operation
    peopleAges.forEach { print("${it.key} is ${it.value}, ") }

    println()

    // Apply a map transformation for each item and convert it to a string
    println(peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", "))

    // Filter operation
    // Filter keys (names) to show only those with less than 4 characters
    val filteredNames = peopleAges.filter { it.key.length < 4 }
    print(filteredNames)

}

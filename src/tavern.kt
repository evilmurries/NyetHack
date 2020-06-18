fun main(args: Array<String>) {
    var beverage = readLine()
        beverage?.let {
        beverage = it.capitalize()
    } ?: println("I cant do that without crashing - beverage was null!")

    val beverageServed: String = beverage ?: "Buttered Ale"

    //beverage = null
    println(beverageServed)
}
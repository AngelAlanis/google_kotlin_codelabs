fun main() {
    val states = arrayOf("Starting", "Doing task 1", "Doing task 2", "Ending")

    repeat(3) {
        Thread {
            println("${Thread.currentThread()} has started.")
            for (i in states) {
                println("${Thread.currentThread()} - $i")
                Thread.sleep(50)
            }
        }.start()
    }
}

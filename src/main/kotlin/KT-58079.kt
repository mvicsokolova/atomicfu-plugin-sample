import kotlinx.atomicfu.atomic
import kotlinx.atomicfu.loop

private val decision = atomic(42)

private fun trySuspend(): Int {
    decision.loop {
        return it
    }
}

fun main() {
    val res = trySuspend()
    println(res)
}

import kotlinx.atomicfu.*
import kotlin.concurrent.*

class Stack<T> {
    private val top  = atomic<Node<T>?>(null)
    private val _size = atomic(0)

    fun push(value: T): Unit = top.loop { cur ->
        val newTop = Node(cur, value)
        if (top.compareAndSet(cur, newTop)) { // try to add
            _size.incrementAndGet() // <-- INCREMENT SIZE
            return
        }
    }

    fun pop(): T? = top.loop { cur ->
        if (cur == null) return null // is stack empty?
        if (top.compareAndSet(cur, cur.next)) { // try to retrieve
            _size.decrementAndGet() // <-- DECREMENT SIZE
            return cur.value
        }
    }

    val size: Int get() = _size.value
}
class Node<T>(val next: Node<T>?, val value: T)

fun main() {
    val stack = Stack<Int>()
    stack.pop()
    stack.push(4)
    stack.push(5)
    println(stack.pop())
    val a = atomic(100)
    println(a.value)
}

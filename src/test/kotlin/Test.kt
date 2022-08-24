import kotlinx.atomicfu.*

class Test {
    val a = atomic(0)

    fun foo() {
        a.inlineFoo(5)
    }
}

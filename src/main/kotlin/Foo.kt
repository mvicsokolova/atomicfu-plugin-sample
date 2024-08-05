import kotlinx.atomicfu.*

class Foo {
    private val a = atomic(0)

    fun foo() {
        a.inlineFoo(56)
        check(a.value == 5)
        println("AAA")
    }
}
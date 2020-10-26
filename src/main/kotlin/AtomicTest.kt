import kotlinx.atomicfu.*

inline fun AtomicInt.inlineFoo(v: Int) {
    value = v
}
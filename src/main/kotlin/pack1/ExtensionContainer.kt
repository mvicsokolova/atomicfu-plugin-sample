package pack1

import kotlinx.atomicfu.*

internal inline fun AtomicInt.inlineFoo(newValue: Int) {
    value = newValue
}

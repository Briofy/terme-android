package net.lynqfy.offical.timeline.model

enum class OrderStatus(i: Int) {
    COMPLETED(0),
    ACTIVE(1),
    INACTIVE(2);

    companion object {
        fun create(v : Int) = when(v){
            0 -> COMPLETED
            1 -> ACTIVE
            else ->INACTIVE
        }
    }
}
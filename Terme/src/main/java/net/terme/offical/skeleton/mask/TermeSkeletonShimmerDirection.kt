package net.terme.offical.skeleton.mask

enum class TermeSkeletonShimmerDirection(private val stableId: Int) {
    LEFT_TO_RIGHT(0),
    RIGHT_TO_LEFT(1);

    companion object {

        fun valueOf(stableId: Int): TermeSkeletonShimmerDirection? {
            return values().firstOrNull { it.stableId == stableId }
        }
    }
}
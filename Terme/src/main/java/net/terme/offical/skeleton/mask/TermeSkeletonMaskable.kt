package net.terme.offical.skeleton.mask

internal interface TermeSkeletonMaskable {
    fun invalidate() = Unit
    fun start() = Unit
    fun stop() = Unit
}
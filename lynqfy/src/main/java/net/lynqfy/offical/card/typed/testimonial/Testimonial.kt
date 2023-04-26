package net.lynqfy.offical.card.typed.testimonial

import net.lynqfy.offical.card.LyCardAction
import net.lynqfy.offical.model.LyContent

interface Testimonial : LyCardAction {
    fun setContent(content: LyContent)
}
package net.terme.offical.card.typed.testimonial

import net.terme.offical.card.TermeCardAction
import net.terme.offical.model.TermeContent

interface Testimonial : TermeCardAction {
    fun setContent(content: TermeContent)
}
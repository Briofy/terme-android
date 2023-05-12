package net.terme.offical.navbar.type

import net.terme.offical.navbar.ButtonCallback
import net.terme.offical.navbar.MenuCallback

interface LyNavBarAction {
    var onButtonAction: ButtonCallback?
    var onMenuAction: MenuCallback?
    var type: LyNavBarType
}
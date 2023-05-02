package net.lynqfy.offical.navbar.type

import net.lynqfy.offical.navbar.ButtonCallback
import net.lynqfy.offical.navbar.MenuCallback

interface LyNavBarAction {
    var onButtonAction: ButtonCallback?
    var onMenuAction: MenuCallback?
    var type: LyNavBarType
}
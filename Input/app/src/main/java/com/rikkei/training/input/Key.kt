package com.rikkei.training.input

import android.widget.TextView

class Key(
    var view: TextView?,
    var name: String?,
    var keyCode: Int,
    var key_up: Key?,
    var key_down: Key?,
    var key_left: Key?,
    var key_right: Key?
)
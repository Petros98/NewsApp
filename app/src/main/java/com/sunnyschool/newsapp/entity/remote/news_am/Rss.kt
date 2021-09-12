package com.sunnyschool.newsapp.entity.remote.news_am

import java.util.*

class Rss {
    var link = ArrayList<Any>()

    var style: Style? = null
    var channel: Channel? = null
    private var _version: String? = null
    fun get_version(): String? {
        return _version
    }

    fun set_version(_version: String?) {
        this._version = _version
    }
}
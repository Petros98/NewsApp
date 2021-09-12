package com.sunnyschool.newsapp.entity.remote.news_am

import java.util.*

class Channel {
    var title: String? = null
    var link: String? = null
    var description: String? = null
    var image: Image? = null
    var managingEditor: String? = null
    var webMaster: String? = null
    var item = ArrayList<Any>()
}
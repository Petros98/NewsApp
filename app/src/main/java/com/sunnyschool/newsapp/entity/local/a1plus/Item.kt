package com.sunnyschool.newsapp.entity.local.a1plus

import com.sunnyschool.newsapp.entity.local.a1plus.Enclosure

class Item (
    var enclosure: Enclosure? = null,
    var link: String? = null,
    var description: String? = null,
    var guid: String? = null,
    var title: String? = null,
    var pubDate: String? = null
){
    override fun toString(): String {
        return "ClassPojo [enclosure = $enclosure, link = $link, description = $description, guid = $guid, title = $title, pubDate = $pubDate]"
    }
}
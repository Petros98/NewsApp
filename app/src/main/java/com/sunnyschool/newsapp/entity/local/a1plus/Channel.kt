package com.sunnyschool.newsapp.entity.local.a1plus

class Channel(
    var image: Image? = null,
    var item: Array<Item>,
    var link: String? = null,
    var description: String? = null,
    var language: String? = null,
    var title: String? = null,
    var pubDate: String? = null
){
    override fun toString(): String {
        return "ClassPojo [image = $image, item = $item, link = $link, description = $description, language = $language, title = $title, pubDate = $pubDate]"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Channel

        if (!item.contentEquals(other.item)) return false

        return true
    }

    override fun hashCode(): Int {
        return item.contentHashCode()
    }
}


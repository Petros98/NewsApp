package com.sunnyschool.newsapp.entity.local.a1plus

class Image (
    var link: String? = null,
    var title: String? = null,
    var url: String? = null
){
    override fun toString(): String {
        return "ClassPojo [link = $link, title = $title, url = $url]"
    }
}
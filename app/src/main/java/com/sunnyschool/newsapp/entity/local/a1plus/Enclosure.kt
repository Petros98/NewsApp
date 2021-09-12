package com.sunnyschool.newsapp.entity.local.a1plus

class Enclosure(
    var length: String? = null,
    var type: String? = null,
    var url: String? = null
){
    override fun toString(): String {
        return "ClassPojo [length = $length, type = $type, url = $url]"
    }
}
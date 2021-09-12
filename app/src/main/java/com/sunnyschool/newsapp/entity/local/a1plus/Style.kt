package com.sunnyschool.newsapp.entity.local.a1plus

class Style(
    var id: String? = null,
    var lang: String? = null,
    var type: String? = null
){
    override fun toString(): String {
        return "ClassPojo [id = $id, lang = $lang, type = $type]"
    }
}
package com.sunnyschool.newsapp.entity.local.a1plus

class Link(
    var rel: String? = null,
    var id: String? = null,
    var type: String? = null
){
    override fun toString(): String {
        return "ClassPojo [rel = $rel, id = $id, type = $type]"
    }
}
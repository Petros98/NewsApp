package com.sunnyschool.newsapp.entity.local.a1plus

class Atom(
    var rel: String? = null,
    var href: String? = null,
    var type: String? = null
){
    override fun toString(): String {
        return "ClassPojo [rel = $rel, href = $href, type = $type]"
    }
}
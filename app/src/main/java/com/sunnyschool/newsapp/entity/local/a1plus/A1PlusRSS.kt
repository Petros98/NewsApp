package com.sunnyschool.newsapp.entity.local.a1plus


data class A1PlusRSS(
    var rss: Rss? = null
){

    override fun toString(): String {
        return "ClassPojo [rss = $rss]"
    }
}


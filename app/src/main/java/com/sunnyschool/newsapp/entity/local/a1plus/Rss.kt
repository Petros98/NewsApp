package com.sunnyschool.newsapp.entity.local.a1plus

class Rss(
    var link: Array<Link>,
    var channel: Channel? = null,
    var style: Style? = null,
    var version: String? = null
){
    override fun toString(): String {
        return "ClassPojo [link = $link, channel = $channel, style = $style, version = $version]"
    }

}

package com.sunnyschool.newsapp.entity.remote.news_am

class Style {
    private var _lang: String? = null
    private var _type: String? = null
    private var _id: String? = null

    // Getter Methods
    fun get_lang(): String? {
        return _lang
    }

    fun get_type(): String? {
        return _type
    }

    fun get_id(): String? {
        return _id
    }

    // Setter Methods
    fun set_lang(_lang: String?) {
        this._lang = _lang
    }

    fun set_type(_type: String?) {
        this._type = _type
    }

    fun set_id(_id: String?) {
        this._id = _id
    }
}
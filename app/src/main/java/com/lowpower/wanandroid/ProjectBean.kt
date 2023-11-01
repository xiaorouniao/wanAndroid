package com.lowpower.wanandroid

data class ProjectBean(
    val data: List<Data>,
    val errorCode: Int,
    val errorMsg: String

) {
    override fun toString(): String {
        return "ProjectBean(`data`=$data, errorCode=$errorCode, errorMsg='$errorMsg')"
    }
}

data class Data(
    val articleList: List<Any>,
    val author: String,
    val children: List<Any>,
    val courseId: Int,
    val cover: String,
    val desc: String,
    val id: Int,
    val lisense: String,
    val lisenseLink: String,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val type: Int,
    val userControlSetTop: Boolean,
    val visible: Int
) {
    override fun toString(): String {
        return "Data(articleList=$articleList, author='$author', children=$children, courseId=$courseId, cover='$cover', desc='$desc', id=$id, lisense='$lisense', lisenseLink='$lisenseLink', name='$name', order=$order, parentChapterId=$parentChapterId, type=$type, userControlSetTop=$userControlSetTop, visible=$visible)"
    }
}
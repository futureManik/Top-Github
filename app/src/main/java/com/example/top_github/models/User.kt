package com.example.top_github.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class User:Serializable {

    @SerializedName("username")
    @Expose
    var username: String? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("url")
    @Expose
    var url: String? = null

    @SerializedName("avatar")
    @Expose
    var avatar: String? = null

    @SerializedName("repo")
    @Expose
    var repo: Repo? = null

}

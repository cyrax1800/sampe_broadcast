package com.michael.myproject

import Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{user}/repos")
    suspend fun getRepos(@Path("user") user: String): List<Repo>
}
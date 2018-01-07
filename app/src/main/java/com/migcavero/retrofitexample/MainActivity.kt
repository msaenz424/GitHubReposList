package com.migcavero.retrofitexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.listView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.jetbrains.anko.toast
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val builder = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())

        val retrofit: Retrofit = builder.build()

        val client: GitHubClient = retrofit.create(GitHubClient::class.java)
        val call: Call<List<GitHubRepo>> = client.reposForUser("msaenz424")

        call.enqueue(object : Callback<List<GitHubRepo>> {
            override fun onResponse(call: Call<List<GitHubRepo>>?, response: Response<List<GitHubRepo>>?) {
                if (response != null) {
                    val reposList: List<GitHubRepo> = response.body()!!
                    listView().adapter = GitHubRepoAdapter(this@MainActivity, reposList)
                }
            }

            override fun onFailure(call: Call<List<GitHubRepo>>?, t: Throwable?) {
                toast("An error has ocurred. Try again")
            }
        })

    }
}

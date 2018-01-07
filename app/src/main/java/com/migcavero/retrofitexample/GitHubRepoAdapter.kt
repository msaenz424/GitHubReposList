package com.migcavero.retrofitexample

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.view.LayoutInflater


class GitHubRepoAdapter constructor(context: Context, reposList: List<GitHubRepo>) : BaseAdapter(){

    private val mContext = context
    private val mReposList = reposList

    override fun getView(position: Int, view: View?, parent: ViewGroup?): View {
        var row = view

        if (row == null) {
            val inflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            row = inflater.inflate(R.layout.item_repo, parent, false)
        }

        val textView = row!!.findViewById(R.id.repo_name_text_view) as TextView

        val item = mReposList[position]
        val message = item.name
        textView.text = message

        return row
    }

    override fun getItem(p0: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemId(p0: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        return mReposList.size
    }


}
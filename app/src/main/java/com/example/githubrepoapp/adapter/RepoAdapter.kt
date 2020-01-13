package com.example.githubrepoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubrepoapp.R
import com.example.githubrepoapp.modelDAO.Repo
import kotlinx.android.synthetic.main.item_starred_repo.view.*

class RepoAdapter : RecyclerView.Adapter<RepoAdapter.RepoHolder>()  {

    val data = ArrayList<Repo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_starred_repo,parent,false)
        return RepoHolder(view)
    }

    override fun getItemCount(): Int {
        return data?.size?:0
    }

    override fun onBindViewHolder(holder: RepoHolder, position: Int) {
        holder.repoNameProject.text = data?.get(position)?.name
        holder.repoLanguage.text = data?.get(position)?.lang
        holder.repoStarCount.text = data[position]?.starCount.toString()

        data[position].desc?.let {
            holder.repoDesc.text = data[position].desc
        }?:run {
            holder.repoDesc.text = "No Description"
        }
    }

    fun addReposDummy(repoDummy:ArrayList<Repo>){
        data.addAll(repoDummy)
        notifyDataSetChanged()
    }

    class RepoHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        val repoNameProject = itemView.tvRepoName
        val repoDesc = itemView.tvDesc
        val repoLanguage = itemView.tvLanguage
        val repoStarCount = itemView.tvStarsCount


    }
}
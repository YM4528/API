package com.example.api.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.api.R
import com.example.api.model.ArticlesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*

class NewsAdapter :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder> (){


    private var articleItem : List<ArticlesItem> = ArrayList()

    class NewsViewHolder(itemView: View)
        : RecyclerView.ViewHolder (itemView) {

        fun bind (articleItem: ArticlesItem)
        {
            itemView.txtTitle.text = articleItem.title
            itemView.txtDescription.text = articleItem.description
            Picasso.get()
                .load(articleItem.urlToImage)
                .into(itemView.newsImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = articleItem.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articleItem[position])
    }

    fun updateArticle(articlesItem: List<ArticlesItem>)
    {
        this.articleItem = articleItem
        notifyDataSetChanged()
    }


}
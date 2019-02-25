package com.example.recipeapi.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipeapi.R
import com.example.recipeapi.RecepeAPI.Model.RecipeResponse

import com.example.recipeapi.RecepeAPI.Model.Response
import kotlinx.android.synthetic.main.recipe_item.view.*


class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    private val data = arrayListOf<Response>()

    fun setData (items: List<Response>){
        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val rootView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recipe_item, parent,false)
        return RecipeViewHolder(rootView)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder:RecipeViewHolder, position: Int) {
        viewHolder.bind(data[position])

    }



    class RecipeViewHolder (val view: View): RecyclerView.ViewHolder(view){
        fun bind (response: Response){
            view.tvTitle.text = response.title
            view.tvIngredients.text = response.ingredients

        }
    }}
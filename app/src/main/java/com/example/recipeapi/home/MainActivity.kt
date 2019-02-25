package com.example.recipeapi.home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.example.recipeapi.App
import com.example.recipeapi.R
import com.example.recipeapi.RecepeAPI.Model.RecipeResponse
import com.example.recipeapi.RecepeAPI.Model.Response
import com.example.recipeapi.di.DaggerAppComponent
import com.example.recipeapi.home.di.DaggerRecipeComponent
import com.example.recipeapi.home.di.RecipeModule
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), RecipeContract.View {



    private val recipeAdapter = RecipeAdapter()

    @Inject
    lateinit var recipePresenter: RecipeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        
        DaggerRecipeComponent.builder()
            .appComponent((application as App).getComponent())
            .recipeModule(RecipeModule(this))
            .build()
            .inject(this)

        rvRecipe.layoutManager = LinearLayoutManager(this)
        rvRecipe.adapter = recipeAdapter



        btnShowRecipe.setOnClickListener {
            recipePresenter.getRecipe(etIngredients.text.toString(),etDishName.text.toString())
        }


    }

        override fun showResults(results: List<Response>) {
            recipeAdapter.setData(results)
        }

        override fun showError(message: String) {
            Toast.makeText(this,message, Toast.LENGTH_LONG).show()

}
}

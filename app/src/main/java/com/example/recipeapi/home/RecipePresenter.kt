package com.example.recipeapi.home

import com.example.recipeapi.Network.RecipeService
import com.example.recipeapi.RecepeAPI.Model.RecipeResponse
import com.example.recipeapi.RecepeAPI.Model.Response
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RecipePresenter(
    private val recipeService: RecipeService,private val view: RecipeContract.View
) : RecipeContract.Presenter {

    private val compositeDisposable = CompositeDisposable()

    override fun getRecipe() {
        compositeDisposable.add(
            recipeService.getRecipe()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe({ view.showResults(it.results) },
                    { failure -> view.showError(failure?.message ?: "An unknown error happened") })
        )
    }
}



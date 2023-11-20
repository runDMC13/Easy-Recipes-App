package com.codingwithme.recipeapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.codingwithme.recipeapp.entities.CategoryItems
import com.codingwithme.recipeapp.entities.MealsItems

@Dao
interface RecipeDao {

    @Query("SELECT * FROM categoryitems ORDER BY id DESC")
    fun getAllCategory(): List<CategoryItems>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCategory(categoryItems: CategoryItems?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMeal(mealsItems: MealsItems?)

    @Query("DELETE FROM categoryitems")
    fun clearDb()

    @Query("SELECT * FROM MealItems WHERE categoryName = :categoryName ORDER BY id DESC")
    fun getSpecificMealList(categoryName: String): List<MealsItems>
}
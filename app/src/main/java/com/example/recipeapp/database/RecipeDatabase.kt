package com.codingwithme.recipeapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.codingwithme.recipeapp.dao.RecipeDao
import com.codingwithme.recipeapp.entities.Category
import com.codingwithme.recipeapp.entities.CategoryItems
import com.codingwithme.recipeapp.entities.Meal
import com.codingwithme.recipeapp.entities.MealsItems
import com.codingwithme.recipeapp.entities.converter.CategoryListConverter
import com.codingwithme.recipeapp.entities.converter.MealListConverter
import com.example.recipeapp.entities.Recipes

@Database(entities = [Recipes::class,CategoryItems::class,Category::class,Meal::class,MealsItems::class],version = 1,exportSchema = false)
@TypeConverters(CategoryListConverter::class, MealListConverter::class)
abstract class RecipeDatabase: RoomDatabase() {

    companion object{

        var recipesDatabase:RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if (recipesDatabase == null){
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).allowMainThreadQueries().build()
            }
            return recipesDatabase!!
        }
    }

    abstract fun recipeDao():RecipeDao
}
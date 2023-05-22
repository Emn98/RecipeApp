package com.example.recipeapp.network


import com.example.recipeapp.utils.Constants
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

/**
 * Build the Moshi object that Retrofit will be using, making sure to add the Kotlin adapter for
 * full Kotlin compatibility.
 */
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * Add a httpclient logger for debugging purpose
 * object.
 */
fun getLoggerIntercepter(): HttpLoggingInterceptor {
    val logging = HttpLoggingInterceptor()
    logging.level = HttpLoggingInterceptor.Level.BODY
    return logging
}

private val recipeListRetrofit = Retrofit.Builder()
    .client(
        OkHttpClient.Builder()
            .addInterceptor(getLoggerIntercepter())
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()
    )
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(Constants.THE_MEAL_DATABASE_BASE_URL)
    .build()

interface TheMealDBApiService{

    @GET("{api_key}/categories.php")
    suspend fun getMealCategories(
        @Path("api_key") apiKey: String = Constants.API_KEY
    ): MealCategoryResponse

    @GET("{api_key}/filter.php")
    suspend fun getRecipesByCategory(
        @Path("api_key") apiKey: String = Constants.API_KEY,
        @Query("c")  c: String
    ): RecipeResponse

    @GET("{api_key}/lookup.php")
    suspend fun getRecipeDetail(
        @Path("api_key") apiKey: String = Constants.API_KEY,
        @Query("i") i: Int
    ): RecipeDetailResponse


}
object theMealDBApi{
    val recipeListRetrofitService: TheMealDBApiService by lazy { recipeListRetrofit.create(TheMealDBApiService::class.java) }
}
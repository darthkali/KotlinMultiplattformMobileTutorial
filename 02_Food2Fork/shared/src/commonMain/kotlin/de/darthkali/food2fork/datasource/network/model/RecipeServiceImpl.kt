package de.darthkali.food2fork.datasource.network.model

import de.darthkali.food2fork.datasource.network.KtorClientFactory
import de.darthkali.food2fork.datasource.network.RecipeService
import de.darthkali.food2fork.datasource.network.toRecipe
import de.darthkali.food2fork.datasource.network.toRecipeList
import de.darthkali.food2fork.domain.model.Recipe
import de.darthkali.food2fork.domain.util.DatetimeUtil
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class RecipeServiceImpl(
    private val httpClient: HttpClient,
    private val baseUrl: String
) : RecipeService {


    override suspend fun search(page: Int, query: String): List<Recipe> {
        return httpClient.get<RecipeSearchResponse> {
            url("$baseUrl/search?page=$page&query=$query")
            header("Authorization", TOKEN)
        }.results.toRecipeList()
    }

    override suspend fun get(id: Int): Recipe {
        return httpClient.get<RecipeDTO> {
            url("$BASE_URL/get?id=$id")
            header("Authorization", TOKEN)
        }.toRecipe()
    }


    companion object {
        const val TOKEN = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
        const val BASE_URL = "https://food2fork.ca/api/recipe"
    }
}






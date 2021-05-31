package de.darthkali.food2fork.android.presentation.recipe_list

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import de.darthkali.food2fork.android.presentation.recipe_list.components.RecipeList
import de.darthkali.food2fork.android.presentation.recipe_list.components.SearchAppBar
import de.darthkali.food2fork.android.presentation.theme.AppTheme
import de.darthkali.food2fork.interactors.recipe_list.RecipeListEvents
import de.darthkali.food2fork.presentation.recipe_list.RecipeListState


@ExperimentalMaterialApi
@ExperimentalComposeUiApi
@Composable
fun RecipeListScreen(
    state: RecipeListState,
    onTriggerEvent: (RecipeListEvents) -> Unit,
    onSelectRecipe: (Int) -> Unit
) {
    AppTheme(displayProgressBar = state.isLoading) {

        Scaffold(
            topBar = {
                SearchAppBar(
                    query = state.query,
                    onQueryChange = {
                        onTriggerEvent(RecipeListEvents.OnUpdateQuery(it))
                    },
                    onExecuteSearch = {
                        onTriggerEvent(RecipeListEvents.NewSearch)
                    })
            },


            ) {
            RecipeList(
                loading = state.isLoading,
                recipes = state.recipes,
                page = state.page,
                onTriggerNextPage = {
                    onTriggerEvent(RecipeListEvents.NextPage)
                },
                onClickRecipeListItem = onSelectRecipe
            )
        }
    }


}
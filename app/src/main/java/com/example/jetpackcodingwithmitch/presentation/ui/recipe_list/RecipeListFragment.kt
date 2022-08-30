package com.example.jetpackcodingwithmitch.presentation.ui.recipe_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.jetpackcodingwithmitch.R
import com.example.jetpackcodingwithmitch.presentation.components.RecipeCard
import com.example.jetpackcodingwithmitch.util.TAG
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    private val viewModel: RecipeListViewModel by activityViewModels()

    @OptIn(ExperimentalComposeUiApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                val recipes = viewModel.recipes.value
                val query = rememberSaveable { mutableStateOf("") }
                val keyboardController = LocalSoftwareKeyboardController.current

                Column {
                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colors.primary,
                        elevation = 8.dp
                    ) {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            TextField(

                                value = query.value,
                                onValueChange = { query.value = it },
                                modifier = Modifier
                                    .fillMaxWidth(0.9f),
                                label = {
                                    Text(text = "Seach")
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text,
                                    imeAction = ImeAction.Search,
                                ),
                                leadingIcon = {
                                    Icon(Icons.Filled.Search, contentDescription = "")
                                },
                                keyboardActions = KeyboardActions(onSearch = {
                                    viewModel.newSearch(query.value)
                                    keyboardController?.hide()
                                }),
                                textStyle = TextStyle(
                                    color = MaterialTheme.colors.onSurface,
                                ),
                                colors = TextFieldDefaults.textFieldColors(
                                    backgroundColor = MaterialTheme.colors.surface,
                                    unfocusedIndicatorColor = Color.Transparent
                            )                            )

                        }

                    }
                    LazyColumn {
                        itemsIndexed(items = recipes) { index, item ->
                            RecipeCard(item, onClick = {

                            })
                        }
                    }
                }
            }
        }
    }


}
package com.example.jetpackcodingwithmitch.data.remote.mapper

import com.example.jetpackcodingwithmitch.data.remote.model.RecipeNetworkEntity
import com.example.jetpackcodingwithmitch.domain.model.Recipe
import com.example.jetpackcodingwithmitch.domain.util.EntityMapper

class RecipeNetworkMapper : EntityMapper<RecipeNetworkEntity, Recipe> {
    override fun mapFromEntity(entity: RecipeNetworkEntity): Recipe {
        return Recipe(
            id = entity.pk,
            title = entity.title,
            featuredImage = entity.featured_image,
            rating = entity.rating,
            publisher = entity.publisher,
            sourceUrl = entity.source_url,
            description = entity.description,
            cookingInstructions = entity.cooking_instructions,
            ingredients = entity.ingredients ?: listOf(),
            dateAdded = entity.date_added,
            dateUpdated = entity.date_updated

        )
    }

    override fun mapToEntity(domain: Recipe): RecipeNetworkEntity {
        return RecipeNetworkEntity(
            pk = domain.id,
            title = domain.title,
            featured_image = domain.featuredImage,
            rating = domain.rating,
            publisher = domain.publisher,
            source_url = domain.sourceUrl,
            description = domain.description,
            cooking_instructions = domain.cookingInstructions,
            ingredients = domain.ingredients,
            date_added = domain.dateAdded,
            date_updated = domain.dateUpdated
        )
    }

    fun toDomainList(initial: List<RecipeNetworkEntity>?): List<Recipe>?{
        return initial?.map { mapFromEntity(it) }
    }

    fun fromDomainList(initial: List<Recipe>): List<RecipeNetworkEntity>{
        return initial.map { mapToEntity(it) }
    }
}
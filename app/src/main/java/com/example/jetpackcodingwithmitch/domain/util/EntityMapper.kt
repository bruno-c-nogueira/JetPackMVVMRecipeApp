package com.example.jetpackcodingwithmitch.domain.util

interface EntityMapper<Entity, DomainModel> {

    fun mapFromEntity(entity: Entity): DomainModel

    fun mapToEntity(domain: DomainModel): Entity
}
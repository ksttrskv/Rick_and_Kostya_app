package com.example.domain.Models

fun com.example.domain.Models.Character.toDomainModel(): Character {
    return Character(
        id = this.id,
        name = this.name,
        status = this.status,
        species = this.species,
        location = Location(name = this.location.name, url = this.location.url),
        image = this.image,
        episode = this.episode
    )
}
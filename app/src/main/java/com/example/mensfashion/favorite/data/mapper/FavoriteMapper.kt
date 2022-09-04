package com.example.mensfashion.favorite.data.mapper

import com.example.mensfashion.favorite.data.remote.dto.FavoriteDto
import com.example.mensfashion.favorite.data.remote.dto.RatingDto
import com.example.mensfashion.favorite.domain.model.Favorite
import com.example.mensfashion.favorite.domain.model.Rating

internal fun RatingDto.toDomain(): Rating {
    return Rating(
        count = count,
        rate = rate
    )
}

internal fun Rating.toDto(): RatingDto {
    return RatingDto(
        count = count,
        rate = rate
    )
}

internal fun FavoriteDto.toDomain(): Favorite {
    return Favorite(
        image = image,
        price = price,
        title = title,
        id = id,
        category = category,
        description = description,
        rating = rating.toDomain(),
        liked = liked
    )
}

internal fun Favorite.toDto(): FavoriteDto {
    return FavoriteDto(
        image = image,
        price = price,
        title = title,
        id = id,
        category = category,
        description = description,
        rating = rating.toDto(),
        liked = liked
    )
}
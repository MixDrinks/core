package org.mixdrinks.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

@JvmInline
@Serializable
value class CocktailId(val id: Int)

@Serializable
data class CocktailDto(
    @SerialName("id") val id: CocktailId,
    @SerialName("slug") val slug: String,
    @SerialName("name") val name: String,
    @SerialName("receipt") val receipt: List<String>,
    @SerialName("goods") val goods: List<GoodRelationDto>,
    @SerialName("tools") val tools: List<ToolId>,
    @SerialName("tags") val tags: List<TagId>,
    @SerialName("tastes") val tastes: List<TasteId>,
    @SerialName("glassware") val glassware: GlasswareId,
)

@Serializable
data class GoodRelationDto(
    @SerialName("goodId") val goodId: GoodId,
    @SerialName("amount") val amount: Int,
    @SerialName("unit") val unit: String,
)

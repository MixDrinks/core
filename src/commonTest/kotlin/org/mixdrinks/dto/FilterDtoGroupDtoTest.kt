package org.mixdrinks.dto

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class FilterDtoGroupDtoTest {

    @Test
    fun `Verify that a filter group can be created from json`() {
        assertEquals(
            @Suppress("MaxLineLength")
            Json.decodeFromString("""{"id":0,"slug":"slug_group_test","name":"Test","filters":[{"id":0,"slug":"slug_test","name":"Test","cocktailIds":[0]}],"selectionType":"SINGLE"}"""),
            FilterGroupDto(
                id = FilterGroupId(0),
                name = "Test",
                filters = listOf(
                    FilterWithCocktailIdsDto(
                        id = FilterId(0),
                        name = "Test",
                        cocktailIds = listOf(CocktailId(0)).toSet(),
                        slug = "slug_test"
                    )
                ),
                selectionType = SelectionType.SINGLE,
                slug = "slug_group_test"
            )
        )
    }

    @Test
    @Suppress("MaxLineLength")
    fun `Verify that a filter group can be created`() {
        val filterDtoGroupWithCocktailIdsDto = FilterGroupDto(
            id = FilterGroupId(0),
            name = "Test",
            filters = listOf(
                FilterWithCocktailIdsDto(
                    id = FilterId(0),
                    name = "Test",
                    cocktailIds = listOf(CocktailId(0)).toSet(),
                    slug = "slug_filter_test"
                )
            ),
            selectionType = SelectionType.SINGLE,
            slug = "slug_group_test"
        )

        assertEquals(
            Json.encodeToString(filterDtoGroupWithCocktailIdsDto),
            """{"id":0,"slug":"slug_group_test","name":"Test","filters":[{"id":0,"slug":"slug_filter_test","name":"Test","cocktailIds":[0]}],"selectionType":"SINGLE"}"""
        )
    }
}

package org.mixdrinks.domain

import org.mixdrinks.dto.CocktailId
import org.mixdrinks.dto.FilterGroupId
import org.mixdrinks.dto.FilterId

data class FilterGroup(
    val id: FilterGroupId,
    val name: String,
    val filters: List<Filter>,
)

data class Filter(
    val id: FilterId,
    val cocktailIds: Set<CocktailId>,
)

class CocktailSelector(
    private val filterMetaInfo: List<FilterGroup>
) {

    fun getCocktailIds(searchParams: Map<FilterGroupId, List<FilterId>>): Set<CocktailId> {
        require(filterMetaInfo.isNotEmpty()) { "Filters must not be empty" }
        searchParams.forEach {
            require(it.value.isNotEmpty()) { "Filter group ${it.key} must not be empty" }
        }

        return searchParams
            .map { (filterGroupId, filterIds) ->
                val filterGroup = filterMetaInfo.find { it.id == filterGroupId } ?: return@map emptyList<CocktailId>()
                val selectedFilters = filterGroup.filters.filter { filterIds.contains(it.id) }
                when (selectedFilters.size) {
                    0 -> error("Filter group $filterGroupId empty or not contains filter ids $filterIds")
                    1 -> {
                        selectedFilters.first().cocktailIds
                    }

                    else -> selectedFilters
                        .map { it.cocktailIds }
                        .reduce { acc, cocktailIds ->
                            acc.intersect(cocktailIds)
                        }
                }
            }
            .reduce { acc, cocktailIds ->
                acc.intersect(cocktailIds.toSet())
            }
            .toSet()
    }
}

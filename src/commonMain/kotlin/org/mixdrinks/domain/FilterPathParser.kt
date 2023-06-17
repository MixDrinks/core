package org.mixdrinks.domain

class FilterPathParser {

    fun parse(path: String): Map<FilterGroups, List<String>> {
        return path.split("/").map {
            val (groupQuery, filter) = it.split("=").map { it.trim() }

            val filterGroup = FilterGroups.values().find { filterGroups -> filterGroups.queryName.value == groupQuery }
                ?: throw IllegalArgumentException("Invalid filter group: $groupQuery")

            return@map filterGroup to filter.split(",").map { it.trim() }.filter { it.isNotBlank() }.toList()
        }.toMap()
    }
}

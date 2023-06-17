package org.mixdrinks.domain

import org.mixdrinks.dto.FilterGroupId
import org.mixdrinks.dto.FilterQueryName
import org.mixdrinks.dto.SelectionType

@Suppress("MagicNumber")
enum class FilterGroups(
    val id: FilterGroupId,
    val translation: String,
    val selectionType: SelectionType,
    val queryName: FilterQueryName,
    val sortOrder: Int,
) {
    TAGS(
        id = FilterGroupId(0),
        translation = "Інше",
        selectionType = SelectionType.MULTIPLE,
        queryName = FilterQueryName("tags"),
        sortOrder = 5,
    ),
    GOODS(
        id = FilterGroupId(1),
        translation = "Інгрідієнти",
        selectionType = SelectionType.MULTIPLE,
        queryName = FilterQueryName("goods"),
        sortOrder = 4,
    ),
    TOOLS(
        id = FilterGroupId(2),
        translation = "Приладдя",
        selectionType = SelectionType.MULTIPLE,
        queryName = FilterQueryName("tools"),
        sortOrder = 6,
    ),
    TASTE(
        id = FilterGroupId(3),
        translation = "Смак",
        selectionType = SelectionType.MULTIPLE,
        queryName = FilterQueryName("taste"),
        sortOrder = 2,
    ),
    ALCOHOL_VOLUME(
        id = FilterGroupId(4),
        translation = "Алкоголь",
        selectionType = SelectionType.SINGLE,
        queryName = FilterQueryName("alcohol-volume"),
        sortOrder = 1,
    ),
    GLASSWARE(
        id = FilterGroupId(5),
        translation = "Стакан",
        selectionType = SelectionType.SINGLE,
        queryName = FilterQueryName("glassware"),
        sortOrder = 3,
    )
}

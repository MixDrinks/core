package org.mixdrinks.domain

import kotlin.test.Test
import kotlin.test.assertEquals

class FilterPathParserTest {

    @Test
    fun `verify filter path parse glassware`() {
        val filterPathParser = FilterPathParser()
        val result = filterPathParser.parse("${FilterGroups.GLASSWARE.queryName.value}=test-glassware-2")

        assertEquals(
            mapOf(
                FilterGroups.GLASSWARE to listOf("test-glassware-2")
            ),
            result
        )
    }

    @Test
    fun `verify filter path parse alcohol volume`() {
        val filterPathParser = FilterPathParser()
        val result = filterPathParser.parse("${FilterGroups.ALCOHOL_VOLUME.queryName.value}=mitsni")

        assertEquals(
            mapOf(
                FilterGroups.ALCOHOL_VOLUME to listOf("mitsni")
            ),
            result
        )
    }

    @Test
    fun `verify filter group with many filter`() {
        val filterPathParser = FilterPathParser()
        val result = filterPathParser.parse("tools=test-tool-1,test-tool-3")

        assertEquals(
            mapOf(
                FilterGroups.TOOLS to listOf("test-tool-1", "test-tool-3"),
            ),
            result
        )
    }

    @Test
    fun `verify filter group with many filter with white spaces`() {
        val filterPathParser = FilterPathParser()
        val result = filterPathParser.parse("  tools= test-tool-1  ,test-tool-3  ")

        assertEquals(
            mapOf(
                FilterGroups.TOOLS to listOf("test-tool-1", "test-tool-3"),
            ),
            result
        )
    }

    @Test
    fun `Verify filter many groups with many filters`() {
        val filterPathParser = FilterPathParser()

        val result = filterPathParser.parse("tools=test-tool-1,test-tool-3/glassware=test-glassware-1,test-glassware-2")
        assertEquals(
            mapOf(
                FilterGroups.TOOLS to listOf("test-tool-1", "test-tool-3"),
                FilterGroups.GLASSWARE to listOf("test-glassware-1", "test-glassware-2")
            ),
            result
        )
    }
}

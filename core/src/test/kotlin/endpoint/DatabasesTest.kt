package endpoint

import notion.api.v1.NotionClient
import notion.api.v1.model.databases.query.filter.TextPropertyFilter
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class DatabasesTest {

    @Test
    fun list() {
        NotionClient(token = System.getenv("NOTION_TOKEN")).use { client ->
            val databases = client.listDatabases()
            assertNotNull(databases)
            assertEquals("list", databases.objectType)
            assertTrue { databases.results.isNotEmpty() }
        }
    }

    @Test
    fun query() {
        NotionClient(token = System.getenv("NOTION_TOKEN")).use { client ->
            val databases = client.listDatabases()
            assertTrue { databases.results.isNotEmpty() }

            val database = databases.results[0]
            val queryResult = client.queryDatabase(
                databaseId = database.id,
                filter = TextPropertyFilter(property = "Name", equals = "Generated by Unit Test")
            )
            assertNotNull(queryResult)
            assertTrue { queryResult.results.isNotEmpty() }
        }
    }
}
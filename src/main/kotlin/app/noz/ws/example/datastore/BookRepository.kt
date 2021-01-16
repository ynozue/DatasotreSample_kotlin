package app.noz.ws.example.datastore

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository

interface BookRepository: DatastoreRepository<Book, Long> {

    fun findByAuthor(author: String): List<Book>
    fun findByYearGreaterThan(year: Int): List<Book>
    fun findByAuthorAndYear(author: String, year: Int): List<Book>

}
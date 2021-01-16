package app.noz.ws.example.datastore

import com.google.common.collect.Lists
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
@SpringBootApplication
class DatastoreApplication {

	@Autowired
	private lateinit var bookRepository: BookRepository

	@ShellMethod("Saves a book to Cloud Datastore: save-book <title> <author> <year>")
	fun saveBook(title: String, author: String, year: Int): String {
		val savedBook = this.bookRepository.save(Book(title = title, author = author, year = year))
		return savedBook.toString()
	}

	@ShellMethod("Loads all books")
	fun findAllBooks(): String {
		val books = this.bookRepository.findAll()
		return Lists.newArrayList(books).toString()
	}

	@ShellMethod("Loads books by author: find-by-author <author>")
	fun findByAuthor(author: String): String {
		val books = bookRepository.findByAuthor(author)
		return books.toString()
	}

	@ShellMethod("Loads books published after a given year: find-by-year-after <year>")
	fun findByYearAfter(year: Int): String {
		val books = bookRepository.findByYearGreaterThan(year)
		return books.toString()
	}

	@ShellMethod("Loads books by author and year: find-by-author-year <author> <year>")
	fun findByAuthorYear(author: String, year: Int): String {
		val books = bookRepository.findByAuthorAndYear(author, year)
		return books.toString()
	}

	@ShellMethod("Removes all books")
	fun removeAllBooks() {
		bookRepository.deleteAll()
	}

}

fun main(args: Array<String>) {
	runApplication<DatastoreApplication>(*args)
}
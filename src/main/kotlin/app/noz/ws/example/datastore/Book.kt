package app.noz.ws.example.datastore

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity
import org.springframework.data.annotation.Id

@Entity(name = "books")
class Book(@Id var id: Long? = null, var title: String, var author: String, var year: Int) {

    override fun toString(): String {
        return "Book(id=$id, title='$title', author='$author', year=$year)"
    }

}
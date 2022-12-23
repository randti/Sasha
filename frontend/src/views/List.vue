<template>
    <div>
        <table class="table">
            <thead>
                <tr>
                <th scope="col">First Name</th>
                <th scope="col">Last Name</th>
                <th scope="col">Email</th>
                <th scope="col">Phone</th>
                <th scope="col">Actions</th>
                </tr>
            </thead>
            <tbody v-for="book in books" v-bind:key="book.id">
                <tr>
                    <td>{{book.name}}</td>
                    <td>{{book.author}}</td>
                    <td>{{book.year}}</td>
                    <td>{{book.pages}}</td>
                    <td><a :href="'/books/' + book.id" class="btn btn-primary">Edit</a></td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
import BookService from './components/services/BookService.js'

export default {
    name: 'books',
    data() {
        return {
            books: []
        }
    },
    methods: {
        retrieveBooks() {
            BookService.getAll()
                .then(response => {
                    this.books = response.data
                })
                .catch(e => {
                    alert(e)
                })
        }
    },
    created() {
        this.retrieveBooks()
    }
}
</script>

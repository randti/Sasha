<template>
    <div v-if="currentBook">
        <div class="mb-3">
                <label for="firstName" class="form-label">First Name</label>
                <input type="text" class="form-control" id="firstName" required name="firstName" v-model="currentBook.name">
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" required name="lastName" v-model="currentBook.author">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" required name="email" v-model="currentBook.year">
            </div>
            <div class="mb-3">
                <label for="phone" class="form-label">Phone</label>
                <input type="text" class="form-control" id="phone" required name="phone" v-model="currentBook.pages">
            </div>
            <div class="mb-3">
                <button @click="updateBook" class="btn btn-primary me-3">Update</button>
                <button @click="deleteBook" class="btn btn-danger">Delete</button>
            </div>
             <div class="alert alert-success" role="alert" v-if="message">
                {{message}}
            </div>
    </div>
</template>
<script>
import BookService from './components/services/BookService.js'

export default {
    name: 'edit',
    data() {
        return {
            currentBook: null,
            message: ''
        }
    },
    methods: {
        getBook(id) {
            BookService.get(id)
                .then(response => {
                    this.currentBook = response.data
                })
                .catch(e => {
                    alert(e)
                })
        },
        updateBook() {
            BookService.update(this.currentBook.id, this.currentBook)
                .then(() => {
                    this.message = 'The customer was updated successfully!'
                })
                .catch(e => {
                    alert(e)
                })
        },
        deleteBook() {
            BookService.delete(this.currentBook.id)
                .then(() => {
                    this.$router.push({name: 'books'})
                })
                .catch(e => {
                    alert(e)
                })
        }
    },
    created() {
        this.getBook(this.$route.params.id)
    }
}
</script>

<template>
    <div>
        <div v-if="!submitted">
            <div class="mb-3">
                <label for="firstName" class="form-label">Name</label>
                <input type="text" class="form-control" id="firstName" required name="firstName" v-model="book.name">
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last Name</label>
                <input type="text" class="form-control" id="lastName" required name="lastName" v-model="book.author">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email" required name="email" v-model="book.year">
            </div>
            <div class="mb-3">
                <label for="phone" class="form-label">Phone</label>
                <input type="text" class="form-control" id="phone" required name="phone" v-model="book.pages">
            </div>
            <div class="mb-3">
                <button @click="saveBook" class="btn btn-primary">Submit</button>
            </div>
        </div>
        <div v-else>
            <div class="alert alert-success" role="alert">
                Save customer successfully!
            </div>
            <button @click="newBook" class="btn btn-primary">Add New Customer</button>
        </div>
    </div>
</template>

<script>
import BookService from './components/services/BookService.js'
export default {
    name: 'add',
    data() {
        return {
            book: {
                id: null,
                name: "",
                author: "",
                year:"",
                pages:"",
                publishing:"",
                link:""
            },
            submitted: false
        }
    },
    methods: {
        saveBook() {
            var data = {
                name: this.book.name,
                author: this.book.author,
                year: this.book.year,
                pages: this.book.pages,
                publishing:"",
                link:""
            }
            BookService.create(data)
                .then(response => {
                    this.customer.id = response.data.id
                    this.submitted = true;
                })
                .catch( e => {
                    alert(e)
                })
        },
        newBook() {
            this.submitted = false
            this.book = {}
        }
    }
}
</script>

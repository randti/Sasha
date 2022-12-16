<script setup lang="ts">

</script>

<template>
    <div class="wrapper"> 
      <div class="container">
        <h1 class="text-center"> Электронные ресурсы</h1>
          <table class="table table-striped">
              <thead>
                  <tr>
                      <th> Номер </th>
                      <th> Название </th>
                      <th> Автор</th>
                      <th> Год издания</th>
                      <th> Количество страниц</th>
                      <th> Издательство </th>
                      <th> Ссылка </th>
                  </tr>
              </thead>
              <tbody>
                  <tr v-for="book in books" v-bind:key="book.id">
                      <td> {{book.id }}</td>
                      <td> {{book.name }}</td>
                      <td> {{book.author}}</td>
                      <td> {{book.year}}</td>
                      <td> {{book.pages}}</td>
                      <td> {{book.publishing}}</td>
                      <td> {{book.link}}</td>
                  </tr>
              </tbody>
          </table>
      </div>
    </div>
</template>

<script>

import BookService from './services/BookService';

export default {
  name: 'MyBook',
  data(){
      return {
          books: []
      }
  },
  methods: {
      getBooks(){
          BookService.getBooks().then((response) => {
              this.books = response.data;   
          });
      }
  },
  created() {
      this.getBooks();
  }
}

</script>
<style scoped lang="scss">
</style>

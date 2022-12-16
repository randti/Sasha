<template>
  <div id="app">
    <MyBook />
  </div>
</template>

<script>
import MyBook from './components/MyBook.vue'

export default {
  name: 'App',
  components: {
    MyBook
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
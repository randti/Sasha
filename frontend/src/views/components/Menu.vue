<script setup lang="ts">


</script>

<template>
<div class="wrapperr" style="">
  <nav class="navbar navbar-expand-lg navbar-light bg-primary ">
    <div class="container-fluid">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <router-link to="/">
              <a class="nav-link active" href="#" style="font-size:20px; color:white;"> Главная</a>
            </router-link>
          </li>

          <li class="nav-item">
            <router-link to="/add">
              <a class="nav-link active" href="#" style="font-size:20px; color:white;">Добавление</a>
            </router-link>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</div>

</template>

<script>
</script>


<style scoped lang="scss">
a{
  text-decoration: none;
}
</style>
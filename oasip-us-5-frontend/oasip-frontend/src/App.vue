<script setup>
</script>

<template>
  <div>
    <nav class="flex items-center justify-between flex-wrap bg-orange-500 p-3">
      <div id="router-container">
        <router-link :to="{ name: 'Home' }" class="routers">Event List</router-link>
      </div>
    </nav>
    <div>
      <router-view></router-view>
    </div>
  </div>
</template>

<style>
@import url('https://fonts.googleapis.com/css2?family=Libre+Bodoni:ital,wght@1,700&display=swap');
.routers {
  margin: 10px 10px;
}
#router-container{
  font-size: 45px;
  font-style:normal;
  color: white;
  font-family: 'Libre Bodoni', serif;
}
</style>

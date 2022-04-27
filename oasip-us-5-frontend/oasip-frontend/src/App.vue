<script setup></script>

<template>
  <div>
    <div id="router-container">
      <router-link :to="{ name: 'Home' }" class="routers">Home</router-link>
    </div>
    <div>
      <router-view></router-view>
    </div>
  </div>

</template>

<style>
.routers {
    margin: 10px 10px;
}

</style>

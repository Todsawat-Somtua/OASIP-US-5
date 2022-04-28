<script setup></script>

<template>
  <div>
    <nav class="flex items-center justify-between flex-wrap bg-orange-500 p-6">
      <div id="router-container">
        <router-link :to="{ name: 'Home' }" class="routers">Home</router-link>
      </div>
    </nav>
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

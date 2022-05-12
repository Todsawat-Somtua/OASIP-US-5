<script setup></script>

<template>
  <div>
    <nav
      class="bg-white border-gray-200 px-2 sm:px-4 py-2.5 dark:bg-gray-800 flex justify-between flex-wrap"
    >
      <div>
        <router-link :to="{ name: 'Home' }" class="flex items-center">
          <img src="./assets/logo.png" ref="TeawKai" class="mr-3 h-6 sm:h-9" />
          TeawKaiorTeawPedareBetter
        </router-link>
      </div>
      <div class="content">
        <router-link :to="{ name: 'Home' }" class="py-2 pr-4 pl-3 text-gray-700"
          >Event List</router-link
        >
        <router-link
          :to="{ name: 'Create' }"
          class="py-2 pr-4 pl-3 text-gray-700"
        >
          Create Event
        </router-link>
      </div>
    </nav>
    <router-view> </router-view>
  </div>
</template>

<style scoped>
a {
  font-weight: bold;
  text-decoration: none;
  margin-right: 1em;
  color: white;
}
.content > a:hover,
.content > a.router-link-active {
  border-bottom: 2px solid white;
}
</style>

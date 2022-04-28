<script setup>
import { ref, onBeforeMount } from 'vue'
import AddEventIconVue from '../components/AddEventIcon.vue';
import AddEventIcon from '../components/AddEventIcon.vue';

const eventsList = ref([])

// Create
// Read
const getEvent = async () => {
  const res = await fetch('http://localhost:8080/api/events')
  if (res.status === 200) {
    eventsList.value = await res.json()
    console.log(eventsList.value)
  } else console.log('error, cannot get data')
}

onBeforeMount(async () => {
  await getEvent()
})

// Update
// Delete
</script>

<template>
  
    <div class="flex justify-center mt-40 text-gray-400" v-show="eventsList.length === 0" @click="">
      <AddEventIcon></AddEventIcon>
    </div>
      <div class="flex justify-center text-7xl text-gray-400 mt-10" v-show="eventsList.length === 0">No schedule
    </div>
  
</template>

<style>
*{
  margin: 0;
  padding: 0;
}
</style>

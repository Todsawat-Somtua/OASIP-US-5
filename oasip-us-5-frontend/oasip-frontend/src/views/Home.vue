<script setup>
import { ref, onBeforeMount } from 'vue'

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
  <div>
    <div v-show="eventsList.length === 0">No schedule</div>
  </div>
</template>

<style></style>

<script setup>
import { ref, onBeforeMount } from 'vue'

const eventsList = ref([])

// Create
// Read
const getEvent = async () => {
  const res = await fetch('http://localhost:8080/api/events')
  if (res.status === 200) {
    eventsList.value = await res.json()
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
    <p v-if="eventsList.value === 0">No schedule</p>
    <p v-else>มีข้อมูลจ้า</p>
  </div>
</template>

<style></style>

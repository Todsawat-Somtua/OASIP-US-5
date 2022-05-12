<script setup>
import { onBeforeMount, ref } from 'vue'
import CreateEvent from '../components/CreateEvent.vue'
import router from '../router'

const webUrl = import.meta.env.PROD
  ? import.meta.env.VITE_API_URL
  : 'http://localhost:8080/api'

const eventCategoriesGetter = ref([])
const eventGetter = ref([])

const getEvent = async () => {
  const res = await fetch(`${webUrl}/events`)
  if (res.status === 200) {
    eventGetter.value = await res.json()
  } else console.log('error, cannot get data')
}
const getEventCategory = async () => {
  const res = await fetch(`${webUrl}/eventCategories`)
  if (res.status === 200) {
    eventCategoriesGetter.value = await res.json()
  } else console.log('error, cannot get data')
}
onBeforeMount(async () => {
  await getEventCategory()
  await getEvent()
})

const newestEvent = ref({})
const createNewEvent = async (newEvent) => {
  const res = await fetch(`${webUrl}/events`, {
    method: 'POST',
    headers: {
      'content-type': 'application/json',
    },
    body: JSON.stringify({
      bookingName: newEvent.bookingName,
      bookingEmail: newEvent.bookingEmail,
      eventStartTime: newEvent.eventStartTime,
      eventNotes: newEvent.eventNotes,
      eventCategoryId: newEvent.eventCategoryId,
    }),
  })
  if (res.status === 201) {
    const addedEvent = await res.json()
    eventGetter.value.push(addedEvent)
    router.replace({ path: '/' })
    alert('Added Successfully')
  } else if (res.status === 500) {
    alert('eiei')
  } else 'error, cannot added'
  newestEvent.value = {}
}
</script>
<template>
  <div>
    <create-event
      :events="newestEvent"
      :eventCategories="eventCategoriesGetter"
      @addEvent="createNewEvent"
    />
  </div>
</template>
<style></style>

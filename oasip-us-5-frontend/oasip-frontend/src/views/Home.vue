<script setup>
import { ref, onBeforeMount, onMounted } from 'vue'
import ShowDetail from '../components/ShowDetail.vue'
import BaseButton from '../components/BaseButton.vue'
import EventTable from '../components/EventTable.vue'
import moment from 'moment'

const eventsGetted = ref([])
const isModel = ref(false)
const showDetail = ref({})
const isAddEvent = ref(false)

const showModel = (e) => {
  isModel.value = e
}
const showAddEvent = (e) => {
  isAddEvent.value = e
}

const webUrl = import.meta.env.PROD
  ? import.meta.env.VITE_API_URL
  : 'http://localhost:8080/api'
const currentEventDetail = ref({})

const currentEvent = (event) => {
  currentEventDetail.value = event
  isModel.value = true
}

// Create
// Read
const eventCategoriesGetter = ref([])
const getEvent = async () => {
  const res = await fetch(`${webUrl}/events`)
  if (res.status === 200) {
    eventsGetted.value = await res.json()
    console.log(eventsGetted.value)
  } else console.log('error, cannot get data')
}
const getEventCategory = async () => {
  const res = await fetch(`${webUrl}/eventCategories`)
  if (res.status === 200) {
    eventCategoriesGetter.value = await res.json()
    console.log(eventCategoriesGetter.value)
  } else console.log('error, cannot get data')
}

onBeforeMount(async () => {
  await getEvent()
  await getEventCategory()
  eventsGetted.value.sort(
    (a, b) => moment(b.eventStartTime) - moment(a.eventStartTime)
  )
})

// Update

// Delete
const removeEvent = async (deleteEventId) => {
  if (confirm('Are you sure to delete') == true) {
    const res = await fetch(`${webUrl}/events/${deleteEventId}`, {
      method: 'DELETE',
    })
    if (res.status === 200) {
      eventsGetted.value = eventsGetted.value.filter(
        (event) => event.eventId !== deleteEventId
      )
      console.log('deleted successfully')
    } else console.log('error, cannot delete data')
  } else {
    console.log('cancel')
  }
}
</script>

<template>
  <div>
    <!-- event empty -->
    <div v-show="eventsGetted.length === 0">
      <div class="flex justify-center text-7xl text-gray-400 mt-10">
        No schedule
      </div>
    </div>
    <!-- Show event -->
    <div v-show="eventsGetted.length !== 0">
      <event-table
        :events="eventsGetted"
        @deleteEvent="removeEvent"
        @showDetail="currentEvent"
      />
    </div>
    <div v-if="isModel">
      <show-detail :eventDetail="currentEventDetail" @close="showModel" />
    </div>
  </div>
</template>

<style></style>

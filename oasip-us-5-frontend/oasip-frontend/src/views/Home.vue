<script setup>
import { ref, onBeforeMount } from 'vue'
import AddEventIcon from '../components/AddEventIcon.vue'
import EventsList from '../components/EventsList.vue'
import ShowDetail from '../components/ShowDetail.vue'
import AddEvent from '../components/AddEvent.vue'
import BaseButton from '../components/BaseButton.vue'
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
const newestEvent = ref({})
const createNewEvent = async (newEvent) => {
  if (
    newEvent.bookingName === undefined ||
    newEvent.bookingEmail === undefined
  ) {
    alert('please insert data')
  } else {
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
      eventsGetted.value.push(addedEvent)
      alert('Added Successfully')
      isAddEvent.value = false
    } else 'error, cannot added'
    newestEvent.value = {}
  }
}
// Read
const eventCategoriesGetter = ref([])
const getEvent = async () => {
  const res = await fetch(`${webUrl}/events`)
  if (res.status === 200) {
    eventsGetted.value = await res.json()
    console.log(eventsGetted.value)
  } else console.log('error, cannot get data')
  console.log(event)
}
const getEventCategory = async () => {
  const res = await fetch(`${webUrl}/eventCategories`)
  if (res.status === 200) {
    eventCategoriesGetter.value = await res.json()
    console.log(eventCategoriesGetter.value)
  } else console.log('error, cannot get data')
  console.log(event)
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
  <div class="grid justify-items-end" v-show="eventsGetted.length !== 0">
    <base-button
      buttonName="Add Event"
      class="mr-3"
      @click="isAddEvent = !isAddEvent"
    />
  </div>
  <div v-show="isAddEvent">
    <add-event
      :events="newestEvent"
      :eventCategories="eventCategoriesGetter"
      @close="showAddEvent"
      @addEvent="createNewEvent"
    ></add-event>
  </div>
  <!-- event empty -->
  <div v-if="eventsGetted.length === 0">
    <div class="flex justify-center mt-40 text-gray-400">
      <base-button buttonName="Add Event" @click="isAddEvent = !isAddEvent" />
    </div>
    <div class="flex justify-center text-7xl text-gray-400 mt-10">
      No schedule
    </div>
  </div>
  <!-- Show event -->
  <div v-else>
    <events-list
      :events="eventsGetted"
      @passEvent="currentEvent"
      @deleteEvent="removeEvent"
    />
  </div>
  <div v-if="isModel">
    <show-detail :eventDetail="currentEventDetail" @close="showModel" />
  </div>
</template>

<style>
* {
  margin: 0;
  padding: 0;
}
</style>

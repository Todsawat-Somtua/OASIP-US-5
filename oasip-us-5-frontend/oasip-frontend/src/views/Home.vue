<script setup>
import { ref, onBeforeMount, onMounted } from 'vue'
import ShowDetail from '../components/ShowDetail.vue'
import BaseButton from '../components/BaseButton.vue'
import EventTable from '../components/EventTable.vue'
import moment from 'moment'

const eventsGetted = ref([])
const isModalOpen = ref(false)

const showModal = (e) => {
  isModalOpen.value = e
}

const webUrl = import.meta.env.PROD
  ? import.meta.env.VITE_API_URL
  : 'http://localhost:8080/api'

const currentEventDetail = ref({})

const currentEvent = (event) => {
  currentEventDetail.value = event
  showModal(true)
}

// Create
// Read
const eventCategoriesGetter = ref([])
const getEvent = async () => {
  const res = await fetch(`${webUrl}/events`)
  if (res.status === 200) {
    eventsGetted.value = await res.json()
  } else console.log('error, cannot get data')
}
const getEventCategory = async () => {
  const res = await fetch(`${webUrl}/eventCategories`)
  if (res.status === 200) {
    eventCategoriesGetter.value = await res.json()
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

const eventUpdate = async (editingEvent) => {
  await console.log(editingEvent)
  showModal(false)
  // const res = await fetch(`${webUrl}/events/${editingEvent.eventId}`, {
  //   method: 'PUT',
  //   headers: {
  //     'content-type': 'application/json',
  //   },
  //   body: JSON.stringify({
  //     eventId: editingEvent.eventId,
  //     eventStartTime: editingEvent.eventStartTime,
  //     eventNote: editingEvent.eventNote,
  //   }),
  // })
  // if (res.status === 200) {
  //   const editedEvent = await res.json()
  //   eventsGetted.value = eventsGetted.value.map((event) =>
  //     event.eventId === editedEvent.eventId
  //       ? {
  //           ...event,
  //           eventId: editedEvent.eventId,
  //           eventStartTime: editedEvent.eventStartTime,
  //           eventNotes: editedEvent.eventNotes,
  //         }
  //       : event
  //   )
  // } else console.log('error, cannot be added')
}

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
    <div v-if="isModalOpen">
      <show-detail
        :eventDetail="currentEventDetail"
        @close="showModal"
        @updateEvent="eventUpdate"
      />
    </div>
  </div>
</template>

<style></style>

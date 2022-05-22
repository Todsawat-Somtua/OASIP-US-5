<script setup>
import { ref, onBeforeMount, onMounted, computed } from 'vue'
import ShowDetail from '../components/ShowDetail.vue'
import EventTable from '../components/EventTable.vue'
import moment from 'moment'

const eventsGetted = ref([])
const isModalOpen = ref(false)
const selectCategory = ref('All')
const selectTime = ref('All')
const showModal = (e) => {
  isModalOpen.value = e
}

const webUrl = import.meta.env.PROD
  ? import.meta.env.VITE_API_URL
  : ' /api'

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
  if (
    eventsGetted.value
      .filter((event) => event.eventId === editingEvent.eventId)
      .some(
        (event) =>
          event.eventStartTime === editingEvent.eventStartTime ||
          moment(event.eventStartTime)
            .utc()
            .add(event.eventCategory.eventDuration, 'm')
            .format() >= editingEvent.eventStartTime
      )
  ) {
    alert('Someone already booked please change start time or clinic')
  } else {
    const res = await fetch(`${webUrl}/events/${editingEvent.eventId}`, {
      method: 'PUT',
      headers: {
        'content-type': 'application/json',
      },
      body: JSON.stringify({
        eventStartTime: editingEvent.eventStartTime,
        eventNotes: editingEvent.eventNotes,
      }),
    })
    if (res.status === 200) {
      const editedEvent = await res.json()
      eventsGetted.value = eventsGetted.value.map((event) =>
        event.eventId === editedEvent.eventId
          ? {
              ...event,
              eventId: editedEvent.eventId,
              eventStartTime: editedEvent.eventStartTime,
              eventNotes: editedEvent.eventNotes,
            }
          : event
      )
      showModal(false)
    } else console.log('error, cannot be added')
  }
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
const filterCategory = computed(() => {
  if (selectCategory.value === 'All') {
    return eventsGetted.value
  }
  else{
    return eventsGetted.value.filter((event) => event.eventCategory.eventCategoryName === selectCategory.value)
    
  }
})
</script>

<template>
<div class="flex justify-end mt-4 mr-4">
  <select class="bg-gray-50 border border-gray-300 text-gray-400 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500 mr-4"
  v-model="selectCategory"
  >
    <option option value="All">All</option>
    <option v-for="category in eventCategoriesGetter" :value="category.eventCategoryName" :key="category.eventCategoryId">
    {{ category.eventCategoryName }}
    </option>
  </select>
  <select class="bg-gray-50 border border-gray-300 text-gray-400 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
  v-model="selectTime"
  >
    <option option value="All">All</option>
    <option>Day</option>
    <option>Upcoming</option>
    <option>Past</option>
  </select>

</div>
  <div>
    <!-- event empty -->
    <div v-show="filterCategory.length === 0">
      <div class="flex justify-center text-7xl text-gray-400 mt-64">
        No schedule
      </div>
    </div>
    <!-- Show event -->
    <div v-show="filterCategory.length !== 0">
      <event-table
        :events="filterCategory"
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

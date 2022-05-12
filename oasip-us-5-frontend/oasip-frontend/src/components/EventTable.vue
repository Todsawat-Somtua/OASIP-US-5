<script setup>
import moment from 'moment'
defineEmits(['deleteEvent'])
defineProps({
  events: {
    type: Array,
    require: true,
  },
})
</script>
<template>
  <div class="relative overflow-x-auto shadow-md sm:rounded-lg table-container">
    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
      <thead
        class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400"
      >
        <tr>
          <th scope="col" class="px-6 py-3">Owner</th>
          <th scope="col" class="px-6 py-3">Event Category</th>
          <th scope="col" class="px-6 py-3">Start Time</th>
          <th scope="col" class="px-6 py-3">Duration</th>
          <th scope="col" class="px-6 py-3">
            <span class="sr-only">Delete</span>
          </th>
          <th scope="col" class="px-6 py-3">
            <span class="sr-only">Edit</span>
          </th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="event in events"
          :key="event.eventId"
          class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"
        >
          <td class="px-6 py-4">{{ event.bookingName }}</td>
          <td class="px-6 py-4">{{ event.eventCategory.eventCategoryName }}</td>
          <td class="px-6 py-4">
            {{ moment(event.eventStartTime).format('HH:mm , DD MMMM YYYY') }}
          </td>
          <td class="px-6 py-4">{{ event.eventDuration }}</td>
          <td class="px-6 py-4">
            <button
              @click="$emit('deleteEvent', event.eventId)"
              class="text-white bg-gradient-to-r from-red-400 via-red-500 to-red-600 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-red-300 dark:focus:ring-red-800 shadow-lg shadow-red-500/50 dark:shadow-lg dark:shadow-red-800/80 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2"
            >
              <i class="fa fa-home" />
              Delete
            </button>
          </td>
          <td class="px-6 py-4">
            <button
              @click="$emit('showDetail', event)"
              class="text-white bg-gradient-to-r from-blue-500 via-blue-600 to-blue-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 shadow-lg shadow-blue-500/50 dark:shadow-lg dark:shadow-blue-800/80 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2"
            >
              Detail
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<style scoped>
.table-container {
  margin: 2rem;
}
</style>

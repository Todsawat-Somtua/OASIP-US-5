<script setup>
import moment from 'moment'
defineEmits(['deleteEvent', 'showDetail'])
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
          <td v-if="event.bookingName.length > 40" class="px-6 py-4">
            {{ event.bookingName.slice(0, 40) }}...
          </td>
          <td v-else class="px-6 py-4">
            {{ event.bookingName }}
          </td>
          <td class="px-6 py-4">
            <span
              class="bg-green-100 text-green-800 text-xs font-semibold mr-2 px-2.5 py-0.5 rounded dark:bg-green-200 dark:text-green-900"
            >
              {{ event.eventCategory.eventCategoryName }}
            </span>
          </td>
          <td class="px-6 py-4">
            {{ moment(event.eventStartTime).format('HH:mm , DD MMMM YYYY') }}
          </td>
          <td class="px-6 py-4">{{ event.eventDuration }}</td>
          <td class="px-6 py-4">
            <button
              @click="$emit('deleteEvent', event.eventId)"
              class="text-white bg-gradient-to-r from-red-400 via-red-500 to-red-600 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-red-300 dark:focus:ring-red-800 shadow-lg shadow-red-500/50 dark:shadow-lg dark:shadow-red-800/80 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2"
            >
              <!-- <svg
                xmlns="http://www.w3.org/2000/svg"
                aria-hidden="true"
                role="img"
                width="1em"
                height="1em"
                preserveAspectRatio="xMidYMid meet"
                viewBox="0 0 512 512"
              >
                <rect
                  x="0"
                  y="0"
                  width="512"
                  height="512"
                  fill="none"
                  stroke="none"
                />
                <rect
                  width="448"
                  height="80"
                  x="32"
                  y="48"
                  fill="currentColor"
                  rx="32"
                  ry="32"
                />
                <path
                  fill="currentColor"
                  d="M74.45 160a8 8 0 0 0-8 8.83l26.31 252.56a1.5 1.5 0 0 0 0 .22A48 48 0 0 0 140.45 464h231.09a48 48 0 0 0 47.67-42.39v-.21l26.27-252.57a8 8 0 0 0-8-8.83Zm248.86 180.69a16 16 0 1 1-22.63 22.62L256 318.63l-44.69 44.68a16 16 0 0 1-22.63-22.62L233.37 296l-44.69-44.69a16 16 0 0 1 22.63-22.62L256 273.37l44.68-44.68a16 16 0 0 1 22.63 22.62L278.62 296Z"
                />
              </svg> -->
              Delete
            </button>
          </td>
          <td class="px-6 py-4">
            <button
              @click="$emit('showDetail', event)"
              buttonName="Detail"
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

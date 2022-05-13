<script setup>
import { computed } from 'vue'
import moment from 'moment'

defineEmits(['close', 'addEvent'])
const props = defineProps({
  events: {
    type: Object,
    require: true,
  },
  eventCategories: {
    type: Array,
    require: true,
  },
})

const currentDate = moment().format('YYYY-MM-DDTHH:mm')
const newEvent = computed(() => {
  return {
    bookingName: props.events.bookingName,
    bookingEmail: props.events.bookingEmail,
    eventStartTime:
      props.events.eventStartTime === undefined
        ? moment().format('YYYY-MM-DDTHH:mm')
        : props.events.eventStartTime,
    eventNotes: props.events.eventNotes,
    eventCategoryId: props.events.eventCategoryId,
  }
})
</script>
<template>
  <div>
    <form
      class="bg-gray-50 dark:bg-gray-500 dark:text-gray-200"
      @submit.prevent="
        $emit('addEvent', {
          bookingName: newEvent.bookingName,
          bookingEmail: newEvent.bookingEmail,
          eventCategoryId: newEvent.eventCategoryId,
          eventStartTime: moment(newEvent.eventStartTime).utc().format(),
          eventNotes: newEvent.eventNotes,
        })
      "
    >
      <div>
        <h1 class="block mb-2 text-3xl font-medium text-center">
          Create new event
        </h1>
        <hr />
        <div class="mb-6 mt-6">
          <label
            for="name"
            class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300"
            >Booking Name</label
          >
          <input
            id="name"
            type="text"
            maxlength="100"
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            placeholder="Firstname Lastname (Group Code)"
            v-model="newEvent.bookingName"
            required
          />
        </div>
        <div class="mb-6">
          <label
            for="email"
            class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300"
          >
            Booking Email
          </label>
          <input
            type="email"
            id="email"
            maxlength="100"
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            placeholder="email@us5.com"
            v-model="newEvent.bookingEmail"
            required
          />
        </div>
        <div class="mb-6">
          <label
            for="category"
            class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300"
          >
            Category Name
          </label>
          <select
            v-model="newEvent.eventCategoryId"
            id="category"
            class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            required
          >
            <option
              v-for="eventCategory in eventCategories"
              :value="eventCategory.eventCategoryId"
              :key="eventCategory.eventCategoryId"
            >
              {{ eventCategory.eventCategoryName }}
              (Duration {{ eventCategory.eventDuration }} minute)
            </option>
          </select>
        </div>
        <div class="mb-6">
          <label
            for="start-time"
            class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300"
          >
            Start Time</label
          >
          <input
            id="start-time"
            type="datetime-local"
            class="p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            :min="currentDate"
            v-model="newEvent.eventStartTime"
            required
          />
        </div>
        <div class="mb-6">
          <label
            for="note"
            class="block mb-2 text-sm font-medium text-gray-900 dark:text-gray-300"
          >
            Notes (max 500 characters)
          </label>
          <textarea
            id="note"
            rows="3"
            placeholder="Leave a note to adviser .."
            class="block p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            v-model="newEvent.eventNotes"
            maxlength="500"
          />
        </div>
        <div class="mb-6">
          <button
            type="submit"
            class="w-full focus:outline-none text-white bg-green-700 hover:bg-green-800 focus:ring-4 focus:ring-green-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-green-600 dark:hover:bg-green-700 dark:focus:ring-green-800"
          >
            Submit
          </button>
        </div>
      </div>
    </form>
  </div>
</template>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Kanit&family=Mitr&display=swap');
form {
  margin: 2rem auto;
  max-width: 35rem;
  border-radius: 12px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.25);
  padding: 1.5rem;
  font-family: 'Kanit', sans-serif;
}
</style>

<script setup>
import { computed } from 'vue'
import moment from 'moment'
import BaseButton from '../components/BaseButton.vue'

defineEmits(['close, addEvent'])
const props = defineProps({
  events: {
    type: Array,
    require: true,
  },
  eventCategories: {
    type: Array,
    require: true,
  },
})

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
  <div class="modal-mask">
    <div class="modal-wrapper">
      <div class="modal-container">
        <div class="modal-header text-lg font-bold">
          <h3>Add Event</h3>
        </div>
        <div class="modal-body">
          <p>
            Booking Name :
            <input
              type="text"
              class="border-2 rounded-lg border-gray-500 text-black ml-1 mt-2"
              v-model="newEvent.bookingName"
            />
          </p>
          <p>
            Booking Email :
            <input
              type="text"
              class="border-2 rounded-lg border-gray-500 text-black ml-1 mt-2"
              v-model="newEvent.bookingEmail"
            />
          </p>
          <p>
            Category Name :
            <select
              class="border-2 rounded-lg border-gray-500 text-black ml-1 mt-2"
              v-model="newEvent.eventCategoryId"
            >
              <option
                v-for="(eventCategory, eventCategoryId) in eventCategories"
                :value="eventCategory.eventCategoryId"
                :key="eventCategoryId"
              >
                {{ eventCategory.eventCategoryName }}
              </option>
            </select>
          </p>
          <p>
            Start Time :
            <input
              type="datetime-local"
              class="border-2 rounded-lg border-gray-500 text-black ml-1 mt-2"
              v-model="newEvent.eventStartTime"
            />
          </p>
          <p>
            Notes :
            <input
              type="text"
              class="border-2 rounded-lg border-gray-500 text-black ml-1 mt-2"
              v-model="newEvent.eventNotes"
            />
          </p>
          <base-button
            buttonName="Add Event"
            class="ml-1"
            @click="
              $emit('addEvent', {
                bookingName: newEvent.bookingName,
                bookingEmail: newEvent.bookingEmail,
                eventCategoryId: newEvent.eventCategoryId,
                eventStartTime: moment(newEvent.eventStartTime).utc().format(),
                eventNotes: newEvent.eventNotes,
              })
            "
          />
          <base-button
            buttonName="Close"
            @click="$emit('close', false)"
            class="ml-3"
          ></base-button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: table;
  transition: opacity 0.3s ease;
}
.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}
.modal-container {
  width: 400px;
  margin: 0px auto;
  padding: 20px 30px;
  background-color: rgb(123, 123, 123);
  border-radius: 10px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
}
.modal-header h3 {
  margin-top: 0;
  color: rgb(255, 255, 255);
}
.modal-body {
  color: white;
}
</style>

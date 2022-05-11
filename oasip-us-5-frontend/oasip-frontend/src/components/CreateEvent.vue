<script setup>
import { computed } from 'vue'
import moment from 'moment'
import BaseButton from './BaseButton.vue'
defineEmits(['close, addEvent'])
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
  <form @submit.prevent="submitForm">
    <h1>Create new event</h1>
    <hr />
    <div class="form-control">
      <label> Booking Name : </label>
      <input type="text" v-model="newEvent.bookingName" />
      <label> Booking Email : </label>
      <input type="text" v-model="newEvent.bookingEmail" />
      <label> Category Name : </label>
      <select v-model="newEvent.eventCategoryId">
        <option
          v-for="eventCategory in eventCategories"
          :value="eventCategory.eventCategoryId"
          :key="eventCategory.eventCategoryId"
        >
          {{ eventCategory.eventCategoryName }}
        </option>
      </select>
      <label> Start Time : </label>
      <input type="datetime-local" v-model="newEvent.eventStartTime" />
      <label> Notes : </label>
      <textarea v-model="newEvent.eventNotes"> </textarea>
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
    </div>
  </form>
</template>
<style scoped>
h1 {
  text-align: center;
  font-size: 30px;
  font-weight: bold;
  margin-bottom: 0.5rem;
}
label {
  font-weight: bold;
}
.form-control {
  margin: 0.5rem 0;
}
form {
  margin: 2rem auto;
  max-width: 40rem;
  border-radius: 12px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.25);
  padding: 1.5rem;
  background-color: azure;
}
input,
select,
textarea {
  display: block;
  width: 100%;
  font: inherit;
  margin-top: 0.5rem;
  border: 2px solid black;
}
input,
select,
textarea {
  border: 2px solid;
}
input:focus,
select:focus,
textarea:focus {
  background-color: wheat;
}
</style>

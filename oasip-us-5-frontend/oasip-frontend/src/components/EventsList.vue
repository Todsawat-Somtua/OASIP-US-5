<script setup>
import moment from "moment";
import BaseButton from "../components/BaseButton.vue";

defineEmits(["passEvent,deleteEvent"]);
defineProps({
  events: {
    type: Array,
    require: true,
  },
});
</script>
<template>
  <!-- Show event -->
  <div class="grid grid-cols-4">
    <div
      v-for="(event, eventId) in events"
      :key="eventId"
      class="flex max-w-sm rounded-lg border border-gray-200 bg-gray-400 border-gray-700 mt-10 mx-2 p-8"
    >
      <ul>
        <li>ชื่อผู้จอง : {{ event.bookingName }}</li>
        <li>ชื่อหมวดหมู่ : {{ event.eventCategory.eventCategoryName }}</li>
        <li>
          Start Time : 
          {{ moment(event.eventStartTime).format("HH:mm , DD MMMM YYYY") }}
        </li>
        <li>Duration : {{ event.eventDuration }} mins</li>
        <base-button buttonName="Detail" @click="$emit('passEvent', event)" />
        <base-button buttonName="Delete" @click="$emit('deleteEvent',eventId)" class="ml-3"/>
      </ul>
    </div>
  </div>
</template>

<style></style>

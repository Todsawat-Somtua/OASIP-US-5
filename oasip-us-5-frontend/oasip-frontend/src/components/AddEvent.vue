<script setup>
import BaseButton from "../components/BaseButton.vue"
defineProps({
  events: {
    type: Array,
    require: true,
  },
  eventCategories:{
      type: Array,
      require: true
  }
});
</script>
 
<template>
  <h1>Add Event</h1>
  <p>Booking Name : <input type="text" class="border-2 rounded-lg border-gray-500 text-black ml-1 mt-2" ></p>
  <p>Booking Email : <input type="text" class="border-2 rounded-lg border-gray-500 text-black ml-1 mt-2"></p>
  <p>Category Name :
    <select class="border-2 rounded-lg border-gray-500 text-black ml-1 mt-2">
      <option v-for="eventCategory in eventCategories" :value="eventCategory">
        {{ eventCategory.eventCategoryName }}
      </option>
    </select> 
  </p>
  <p>Date : <input type="date" class="border-2 rounded-lg border-gray-500 text-black ml-1 mt-2"></p>
  <p>Start Time : <input type="time" class="border-2 rounded-lg border-gray-500 text-black ml-1 mt-2"></p>
  <p>Notes : <input type="text" class="border-2 rounded-lg border-gray-500 text-black ml-1 mt-2"></p>
  <base-button buttonName="Add Event" class="ml-3" />
</template>
 
<style>
</style>
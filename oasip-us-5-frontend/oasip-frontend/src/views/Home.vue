<script setup>
import { ref, onBeforeMount } from 'vue'
import AddEventIconVue from '../components/AddEventIcon.vue';
import AddEventIcon from '../components/AddEventIcon.vue';
import moment from 'moment'
import BaseButton from '../components/BaseButton.vue'
const eventsList = ref([])

// Create
// Read
const getEvent = async () => {
  const res = await fetch('http://localhost:8080/api/events')
  if (res.status === 200) {
    eventsList.value = await res.json()
    console.log(eventsList.value)
  } else console.log('error, cannot get data')
}

onBeforeMount(async () => {
  await getEvent()
})

// Update
// Delete
</script>

<template>
  <!-- //event empty -->
    <div class="flex justify-center mt-40 text-gray-400" v-show="eventsList.length === 0" @click="">
      <AddEventIcon></AddEventIcon>
    </div>
      <div class="flex justify-center text-7xl text-gray-400 mt-10" v-show="eventsList.length === 0">No schedule
    </div>

  <!-- Show event -->
    <div v-for="events in eventsList" class="card-event">
    <div v-show="eventsList.length !== 0" class="flex max-w-sm rounded-lg border border-gray-200 bg-gray-400 border-gray-700 mt-10 ml-20 p-8 ">
      
       <label>
          <ul>
            <li>ชื่อผู้จอง : {{events.bookingName}}</li>
            <li>ชื่อหมวดหมู่ : {{events.eventCategory.eventCategoryName}}</li>
            <li>Start Time : {{moment(events.eventStartTime).format('HH:mm , DD MMMM YYYY')}}</li>
            <li>Duration : {{ events.eventCategory.eventDuration}} mins</li>
            
          </ul>
          
          <base-button buttonName = 'Detail' @click="showDetail" />
       </label>
      
      </div>
    </div>
  
</template>

<style>
*{
  margin: 0;
  padding: 0;
}
.card-event{
  display: inline-block;
  width: 500px;
  justify-items: center;
}
</style>
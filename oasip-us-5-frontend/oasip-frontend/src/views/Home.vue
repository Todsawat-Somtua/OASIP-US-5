<script setup>
import { ref, onBeforeMount } from "vue";
import AddEventIcon from "../components/AddEventIcon.vue";
import EventsList from "../components/EventsList.vue";
import ShowDetail from "../components/ShowDetail.vue";
import moment from "moment";

const eventsGetted = ref([]);
const isModel = ref(false);
const showDetail = ref({});
const showModel = (e) => {
  isModel.value = e;
};

const currentEventDetail = ref({});

const currentEvent = (event) => {
  currentEventDetail.value = event;
  isModel.value = true;
};


// Create
// Read
const getEvent = async () => {
  const res = await fetch("http://localhost:8080/api/events");
  if (res.status === 200) {
    eventsGetted.value = await res.json();
    console.log(eventsGetted.value);
  } else console.log("error, cannot get data");
};

onBeforeMount(async () => {
  await getEvent()
  eventsGetted.value.sort((a, b) =>
    moment(a.eventStartTime) - moment(b.eventStartTime)
);
});

// Update
// Delete
</script>

<template>
  <!-- event empty -->
  <div v-if="eventsGetted.length === 0">
    <div class="flex justify-center mt-40 text-gray-400">
      <AddEventIcon />
    </div>
    <div class="flex justify-center text-7xl text-gray-400 mt-10">
      No schedule
    </div>
  </div>
  <!-- Show event -->
  <div v-else>
    <events-list :events="eventsGetted" @passEvent="currentEvent" />
  </div>
  <div v-if="isModel">
    <show-detail :eventDetail="currentEventDetail" @close="showModel" />
  </div>
</template>

<style>
* {
  margin: 0;
  padding: 0;
}
</style>

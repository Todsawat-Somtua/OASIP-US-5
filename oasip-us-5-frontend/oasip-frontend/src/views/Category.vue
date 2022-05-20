<script setup>
import EventCategoryTable from '../components/EventCategoryTable.vue';
import { ref,onBeforeMount} from 'vue';

const eventCategoriesGetter = ref([])
const webUrl = import.meta.env.PROD
  ? import.meta.env.VITE_API_URL
  : 'http://localhost:8080/api'
const getEventCategory = async () => {
  const res = await fetch(`${webUrl}/eventCategories`)
  if (res.status === 200) {
    eventCategoriesGetter.value = await res.json()
  } else console.log('error, cannot get data')
}

onBeforeMount(async () => {
  await getEventCategory()
})
</script>
 
<template>
<div>
    <EventCategoryTable :events="eventCategoriesGetter"/>
</div>
</template>
 
<style>

</style>
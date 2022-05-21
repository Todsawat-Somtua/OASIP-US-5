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
  eventCategoriesGetter.value.sort(
    (a, b) => (b.eventCategoryId) - (a.eventCategoryId)
  )
})
const updateCategory = async (editingCategory) => {
  if (editingCategory.eventCategoryName === "" ) {
    alert('please insert Movie Name and Genre')
  } else {
    const res = await fetch(`${webUrl}eventCategories/${editingCategory.eventCategoryId}`, {
    method: 'PUT',
    headers:{
      'content-type' : 'application/json'
    },
    body: JSON.stringify({ eventCategoryName: editingCategory.eventCategoryName, eventCategoryDescription: editingCategory.eventCategoryDescription, eventDuration: editingCategory.eventDuration})
    })
    if (res.status === 200) {
      const editedCategory = await res.json()
      eventCategoriesGetter.value = eventCategoriesGetter.value.map((category) => 
      category.eventCategoryId === editedCategory.eventCategoryId
      ? {...category, eventCategoryName: editedCategory.eventCategoryName, eventCategoryDescription: editedCategory.eventCategoryDescription, eventDuration: editedCategory.eventDuration} 
      : category
      )
    } else console.log('error, cannot be added')
  }
}
</script>
 
<template>
<div>
    <event-category-table :categories="eventCategoriesGetter" @updateCategory="updateCategory"></event-category-table>
</div>
</template>
 
<style>

</style>
<script setup>
import EventCategoryTable from '../components/EventCategoryTable.vue'
import CategoryEdit from '../components/CategoryEdit.vue'
import { ref, onBeforeMount } from 'vue'

const eventCategoriesGetter = ref([])
const isModalOpen = ref(false)
const selectCategory = ref({})
const showModal = (e) => {
  isModalOpen.value = e
}

const currentCategory = (e) => {
  selectCategory.value = e
  showModal(true)
}
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
    (a, b) => b.eventCategoryId - a.eventCategoryId
  )
})
const updatedCategory = async (editingCategory) => {
  if (editingCategory.eventCategoryName === '') {
    alert('Plase insert category name')
  // } else if (
  //   eventCategoriesGetter.value.some(
  //     (e) => e.eventCategoryName === editingCategory.eventCategoryName
  //   )
  // ) {
  //   alert('Have a duplicate category name')
  } else if (editingCategory.eventDuration > 480 || editingCategory.eventDuration < 1){
    alert('Invalid time must be between 1 - 480 minutes')
  } else {
    const res = await fetch(`${webUrl}/eventCategories/${editingCategory.eventCategoryId}`,
      {
        method: 'PUT',
        headers: {
          'content-type': 'application/json',
        },
        body: JSON.stringify({
          eventCategoryName: editingCategory.eventCategoryName,
          eventCategoryDescription: editingCategory.eventCategoryDescription,
          eventDuration: editingCategory.eventDuration,
        }),
      }
    )
    if (res.status === 200) {
      const editedCategory = await res.json()
      eventCategoriesGetter.value = eventCategoriesGetter.value.map(
        (category) =>
          category.eventCategoryId === editedCategory.eventCategoryId
            ? {
                ...category,
                eventCategoryName: editedCategory.eventCategoryName,
                eventCategoryDescription:
                  editedCategory.eventCategoryDescription,
                eventDuration: editedCategory.eventDuration,
              }
            : category
      ) 
      showModal(false)
      alert('Edit Successfully')
    } else if(res.status === 404){
      alert('Have a duplicate category name')
    }else console.log('error, cannot be added')
  }
}
</script>

<template>
  <div>
    <div>
      <event-category-table
        :categories="eventCategoriesGetter"
        @passCategory="currentCategory"
      />
    </div>
    <div v-show="isModalOpen">
      <category-edit
        :editingCategory="selectCategory"
        @close="showModal"
        @updateCategory="updatedCategory"
      />
    </div>
  </div>
</template>

<style></style>

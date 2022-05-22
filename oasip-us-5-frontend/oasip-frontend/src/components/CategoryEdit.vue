<script setup>
import { computed } from 'vue'
defineEmits(['close', 'updateCategory'])
const props = defineProps({
  editingCategory: {
    type: Object,
  },
})
const editingCategory = computed(() => {
  return {
    eventCategoryId: props.editingCategory.eventCategoryId,
    eventCategoryName: props.editingCategory.eventCategoryName,
    eventDuration: props.editingCategory.eventDuration,
    eventCategoryDescription: props.editingCategory.eventCategoryDescription,
  }
})
</script>
 
<template>
<div
    class="overflow-y-auto overflow-x-hidden fixed w-full top-0 right-0 left-0 z-50 md:inset-0 h-modal md:h-full background"
  >
    <!-- Mask -->
    <div class="mx-auto my-0 mt-20 p-4 w-full max-w-2xl h-full md:h-auto">
      <!-- Container -->
      <div class="relative bg-white rounded-lg shadow dark:bg-gray-700">
        <!-- Header -->
        <div
          class="flex justify-between items-center p-5 rounded-t border-b dark:border-gray-600"
        >
          <h1 class="text-xl font-medium text-gray-900 dark:text-white">
            Hi
          </h1>
          <button
            type="button"
            class="text-gray-400 bg-transparent hover:bg-gray-200 hover:text-gray-900 rounded-lg text-sm p-1.5 ml-auto inline-flex items-center dark:hover:bg-gray-600 dark:hover:text-white"
            data-modal-toggle="large-modal"
            @click="$emit('close', false)"
          >
            <svg
              class="w-5 h-5"
              fill="currentColor"
              viewBox="0 0 20 20"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                fill-rule="evenodd"
                d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
                clip-rule="evenodd"
              ></path>
            </svg>
          </button>
          <hr />
        </div>
        <div class="p-6 space-y-6">
            <div class="mb-6">
              <label for="name" class="text-lg leading-relaxed text-gray-500 dark:text-gray-400">Category Name: </label>
              <input type="text" name="name" min="100" 
              class="block mt-3 p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              v-model="editingCategory.eventCategoryName">
            </div>
            <div class="mb-6">
              <label for="duration" class="text-lg leading-relaxed text-gray-500 dark:text-gray-400">Event Duration: </label>
              <input type="number" name="duration" min="1" max="480"
              class="block mt-3 p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              v-model="editingCategory.eventDuration">
            </div>
            <div class="mb-6">
              <label for="description" class="text-lg leading-relaxed text-gray-500 dark:text-gray-400">Category Description:</label>
              <textarea name="description" maxlenght="500" rows="3"
              class="block mt-3 p-2.5 w-full text-sm text-gray-900 bg-gray-50 rounded-lg border border-gray-300 focus:ring-blue-500 focus:border-blue-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              v-model="editingCategory.eventCategoryDescription" />
            </div>
        </div>
        <div
          class="flex items-center p-6 space-x-2 rounded-b border-t border-gray-200 dark:border-gray-600 justify-end"
        >
          <button
          @click="$emit('updateCategory',{
                eventCategoryId: editingCategory.eventCategoryId,
                eventCategoryName: editingCategory.eventCategoryName,
                eventCategoryDescription: editingCategory.eventCategoryDescription,
                eventDuration: editingCategory.eventDuration
              })"
            class="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-base px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
          >
            Submit
          </button>
          <button
            @click="$emit('close', false)"
            class="text-gray-500 bg-white hover:bg-gray-100 focus:ring-4 focus:outline-none focus:ring-gray-200 rounded-lg border border-gray-200 text-base font-medium px-5 py-2.5 hover:text-gray-900 focus:z-10 dark:bg-gray-700 dark:text-gray-300 dark:border-gray-500 dark:hover:text-white dark:hover:bg-gray-600 dark:focus:ring-gray-600"
          >
            Close
          </button>
        </div>
      </div>
    </div>
  </div>
</template>
 
<style scoped>
.background {
  background-color: rgba(0, 0, 0, 0.5);
  transition: opacity 0.3s ease;
}
</style>
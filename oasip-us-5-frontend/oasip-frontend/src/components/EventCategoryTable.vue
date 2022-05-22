<script setup>
defineEmits(['passCategory'])
defineProps({
  categories: {
    type: Array,
    require: true,
  },
})
</script>
 
<template>
<div class="relative overflow-x-auto shadow-md sm:rounded-lg table-container">
    <table class="w-full text-sm text-left text-gray-500 dark:text-gray-400">
      <thead
        class="text-xs text-gray-700 uppercase bg-gray-50 dark:bg-gray-700 dark:text-gray-400"
      >
        <tr>
          <th scope="col" class="px-6 py-3">Event Category</th>
          <th scope="col" class="px-64 py-3">Description</th>
          <th scope="col" class="px-6 py-3">Duration</th>
          <th scope="col" class="px-6 py-3">
            <span class="sr-only">Edit</span>
          </th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="category in categories"
          :key="category.eventCategoryId"
          class="bg-white border-b dark:bg-gray-800 dark:border-gray-700"
        >
          <td class="px-6 py-4">
            <span class="bg-green-100 text-green-800 text-xs font-semibold mr-2 px-2.5 py-0.5 rounded dark:bg-green-200 dark:text-green-900">
            {{ category.eventCategoryName }}
            </span>
          </td>
          <td class="px-6 py-4">
            <span
              class="px-6 py-4"
            >
              {{ category.eventCategoryDescription }}
            </span>
          </td>
          <td class="px-6 py-4">{{ category.eventDuration }}</td>
          <td class="px-6 py-4">
            <button
              @click="$emit('passCategory', category)"
              buttonName="Edit"
              class="text-white bg-gradient-to-r from-blue-500 via-blue-600 to-blue-700 hover:bg-gradient-to-br focus:ring-4 focus:outline-none focus:ring-blue-300 dark:focus:ring-blue-800 shadow-lg shadow-blue-500/50 dark:shadow-lg dark:shadow-blue-800/80 font-medium rounded-lg text-sm px-5 py-2.5 text-center mr-2 mb-2"
            >
              Edit
            </button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
 
<style scoped>
.table-container {
  margin: 6rem;
}
</style>
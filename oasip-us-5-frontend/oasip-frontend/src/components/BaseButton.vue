<script setup>
defineProps({
    buttonName: {
        type: String,
        require: true
    },
    buttonColor: {
        type: String
    }
})
</script>
 
<template>
<button class="base-button bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mt-5 ">
  {{ buttonName }}
</button>
</template>
 
<style>
</style>
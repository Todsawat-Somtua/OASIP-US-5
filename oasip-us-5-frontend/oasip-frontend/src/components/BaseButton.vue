<script setup>
defineEmits(['sendEvent'])
defineProps({
    buttonName: {
        type: String,
        require: true
    },
    event: {
      type: Object,
    }
})
</script>
 
<template>
<button @click="$emit('sendEvent', event)" class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded mt-5 ">
  {{ buttonName }}
</button>
</template>
 
<style>
</style>
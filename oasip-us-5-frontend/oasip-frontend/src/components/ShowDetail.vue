<script setup>
import BaseButton from '../components/BaseButton.vue'
import moment from 'moment-timezone'


defineEmits(['close'])
defineProps({
    eventDetail: {
        type: Object,
    }
})


</script>
 
<template>
<div class="modal-mask">
    <div class="modal-wrapper">
        <div class="modal-container">
            <div class="modal-header text-lg font-bold" >
                <h3>Detail</h3>
            </div>
            <div class="modal-body ">
                <p>ชื่อผู้จอง : {{ eventDetail.bookingName }}</p>
                <p>E-mail : {{eventDetail.bookingEmail}}</p>
                <p>ชื่อหมวดหมู่ : {{eventDetail.eventCategory.eventCategoryName}}</p>
                <p>Start Time : {{moment(eventDetail.eventStartTime).format('HH:mm , DD MMMM YYYY')}}</p>
                <p>Duration : {{ eventDetail.eventDuration}} mins</p>  
                <p v-if="eventDetail.eventNotes !== null" >Note : {{ eventDetail.eventNotes }}</p>
            </div>
            <div class=" text-black flex justify-end">
                <base-button buttonName='Close' @click="$emit('close', false)">Close</base-button>
            </div>
        </div>
    </div>
</div>
</template>
 
<style scoped>
.modal-mask {
    position: fixed;
    z-index: 9998;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    display: table;
    transition: opacity 0.3s ease;
}
.modal-wrapper {
    display: table-cell;
    vertical-align: middle;
}
.modal-container {
    width: 500px;
    margin: 0px auto;
    padding: 20px 30px;
    background-color: rgb(123, 123, 123);
    border-radius: 10px;
    box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
}
.modal-header h3 {
    margin-top: 0;
    color: rgb(255, 255, 255);
}
.modal-body{
    color: white;
}
</style>
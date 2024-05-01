<template>

  <div class="v_card">
    <div class="v_card_header">
      <div class="v_card_header_left">
        <h2 class="v_card_title">{{ employee.name }}</h2>
      </div>
      <div class="v_card_header_right">
        <button class="v_btn" @click="editEmployee">Edit</button>
        <button class="v_btn" @click="deleteEmployee">Delete</button>
        <button class="v_btn" @click="showDetails">Details</button>
      </div>
    </div>
    <div class="v_card_body">
      <div class="v_card_row">
        <div class="v_card_label">Phone:</div>
        <div class="v_card_value">{{ employee.phone }}</div>
      </div>
      <div class="v_card_row">
        <div class="v_card_label">Email:</div>
        <div class="v_card_value">{{employee.email }}</div>
      </div>
    </div>
  </div>


</template>

<script lang="ts" setup>

import {useRouter} from "vue-router";
import employeeService from '@/core/services/EmployeeService'

const props = defineProps(['employee']);
const router = useRouter();

const showDetails = () => {
  router.push({name:"details",params:{id: props.employee.id}})
}

const editEmployee = () => {
  router.push({name:"edit",params:{id:props.employee.id}})
}

const deleteEmployee = () => {
    employeeService.deleteEmployeeById(props.employee.id)
  .then(() => {
    window.location.reload();
  });
}

</script>

<style scoped>
.v_card {
  background-color: #f9fafb;
  border-radius: 8px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  margin: 16px;
  overflow: hidden;
}

.v_card_header {
  background-color: #1890ff;
  color: #fff;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 16px;
}

.v_card_title {
  margin: 0;
  font-size: 24px;
}

.v_card_header_right {
  display: flex;
  align-items: center;
}

.v_btn {
  background-color: #fff;
  border: 1px solid #1890ff;
  border-radius: 4px;
  color: #1890ff;
  font-size: 14px;
  margin-left: 8px;
  padding: 8px 16px;
}

.v_btn:hover {
  background-color: #1890ff;
  color: #fff;
}

.v_card_body {
  padding: 16px;
}

.v_card_row {
  display: flex;
  align-items: center;
  margin-bottom: 8px;
}

.v_card_label {
  font-size: 14px;
  font-weight: bold;
  width: 100px;
}

.v_card_value {
  font-size: 14px;
}


</style>
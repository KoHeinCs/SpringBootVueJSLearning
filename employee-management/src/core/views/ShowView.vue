<template>
  <div class="employee-details">

    <div class="employee-header">

      <div class="employee-avatar">
        <img src="../../assets/logo.png" alt="Employee Avatar"/>
      </div>

      <div class="employee-info">
        <h1>{{ employee?.name }}</h1>
        <h2>{{ employee?.position }}</h2>
        <div class="employee-contact">
          <div class="employee-contact-item">
            <i class="fas fa-phone"></i>
            <p>{{ employee?.phone }}</p>
          </div>
          <div class="employee-contact-item">
            <i class="fas fa-envelope"></i>
            <p>{{ employee?.email }}</p>
          </div>
        </div>
      </div>
    </div>
    <div class="employee-details-body">
      <div class="employee-details-section">
        <h2>About {{ employee?.name }}</h2>
        <p>{{ employee?.bio }}</p>
      </div>
    </div>


  </div>

</template>

<script setup lang="ts">
import {useRoute} from "vue-router";
import {ref} from "vue";
import Employee from "@/core/types/Employee";
import employeeService from "@/core/services/EmployeeService"

const route = useRoute();
const id: string | string[] = route.params.id;
let employee = ref<Employee>();
employeeService.getEmployeeById(id)
    .then((resp) => employee.value = resp)

</script>

<style scoped>



.employee-details {
  margin: 2rem auto;
  max-width: 800px;
  padding: 2rem;
  background-color: #f2f2f2;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  font-family: Arial, sans-serif;
  color: #333;
}

.employee-header {
  display: flex;
  align-items: center;
  margin-bottom: 2rem;
}

.employee-avatar {
  width: 150px;
  height: 150px;
  border-radius: 50%;
  overflow: hidden;
  margin-right: 2rem;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
}

.employee-avatar img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.employee-info {
  display: flex;
  flex-direction: column;
}

.employee-info h1 {
  font-size: 2.5rem;
  margin: 0;
}

.employee-info h2 {
  font-size: 1.5rem;
  margin: 0;
  color: #666;
}


.employee-contact {
  display: flex;
  margin-top: 1rem;
}

.employee-contact-item {
  display: flex;
  align-items: center;
  margin-right: 1rem;
}

.employee-contact-item i {
  font-size: 1.2rem;
}

.employee-contact-item p {
  margin: 0 0 0 0.5rem;
}

.employee-details-body {
  display: flex;
  flex-direction: column;
}

.employee-details-section {
  margin-bottom: 2rem;
}

.employee-details-section h2 {
  font-size: 1.8rem;
  margin-bottom: 1rem;
}

.employee-details-section p {
  line-height: 1.5;
  text-align: justify;
}




</style>
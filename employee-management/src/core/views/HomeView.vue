<template>

  <nav-bar></nav-bar>

  <a-layout-content style="padding: 0 50px">
    <div v-for="(employee,index) in employees" :key="index">
      <employee-card :employee="employee"></employee-card>
    </div>
  </a-layout-content>


</template>

<script setup lang="ts">
import employeeService from "@/core/services/EmployeeService"
import {ref} from "vue";
import Employee from "@/core/types/Employee";
import EmployeeCard from "@/core/components/EmployeeCard.vue";
import NavBar from "@/core/components/NavBar.vue"

let employees = ref<Employee[]>([])

employeeService.getAllEmployees()
    .then(resp => {
      employees.value = resp
    })
    .catch((error) => {
      if (error.response && error.response.data.httpStatusCode === 403) {
        // Redirect the user to the login page
        window.location.href = "/login";
      }
    })

</script>

<style scoped>

</style>
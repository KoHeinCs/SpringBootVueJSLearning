<template>

  <div class="jumbotron">
    <h1>
      Welcome Back Admin ! <br /><br />
      Employees
    </h1>
  </div>
  <div class="container">

      <div v-for="(employee,index) in employees" :key="index">
          <employee-card :employee="employee"></employee-card>
      </div>
  </div>

</template>

<script setup lang="ts">
import employeeService from "@/core/services/EmployeeService"
import {ref} from "vue";
import Employee from "@/core/types/Employee";
import EmployeeCard from "@/core/components/EmployeeCard.vue";

   let employees = ref<Employee[]>([])

    employeeService.getAllEmployees().then(resp =>
       employees.value = resp
    )

</script>

<style scoped>

</style>
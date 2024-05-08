<template>

  <div class="container">
    <a-form
        :model="formState"
        name="basic"
        :label-col="{ span: 8 }"
        :wrapper-col="{ span: 16 }"
        autocomplete="off"
        @finish="onFinish"
        @finishFailed="onFinishFailed"
    >
      <a-form-item
          label="Username"
          name="username"
          :rules="[{ required: true, message: 'Please input your username!' }]">
        <a-input v-model:value="formState.username"/>
      </a-form-item>

      <a-form-item
          label="Password"
          name="password"
          :rules="[{ required: true, message: 'Please input your password!' }]"
      >
        <a-input-password v-model:value="formState.password"/>
      </a-form-item>

      <a-form-item :wrapper-col="{ offset: 8, span: 16 }">
        <a-button type="primary" html-type="submit">Submit</a-button>
      </a-form-item>

    </a-form>
  </div>


</template>

<script setup lang="ts">

import {reactive} from 'vue';
import authService from "@/core/services/AuthService";
import {useRouter} from "vue-router";

const router = useRouter();

interface LoginForm {
  username: string,
  password: string
}

const formState = reactive<LoginForm>({
  username: '',
  password: ''
});

const onFinish = (values: any) => {

  authService.login(values).then((resp) => {
    console.log("login resp ",resp)
    if (resp && resp.httpStatusCode === 200) {
      const token = resp.data;
      window.localStorage.clear();
      window.localStorage.setItem("jwtToken", token);
      router.push({name: "Home"})
    }else {
      window.localStorage.clear();
      router.push({name:"Login"})
    }
  })
};

const onFinishFailed = (errorInfo: any) => {
  console.log('Failed:', errorInfo);
};

</script>

<style scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 70vh;
}


</style>
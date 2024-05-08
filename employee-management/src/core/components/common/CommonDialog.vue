<template>
  <a-modal
      :open="props.isOpen"
      :width="modalWidth"
      :closable="false"
      :centered="true"
      style="border: 2px solid #333333 ; border-radius:  2px">

    <template #title>
      <div :class="props.titlePosition === 'center' ? 'custom-modal-header' : 'custom-modal-header header-container' ">
        <span class="title">{{ props.title }}</span>
      </div>
    </template>


    <div class="message-container-error" v-if="props.dialogType === 'error'">
      <span>{{ props.message }}</span>
    </div>
    <div class="message-container-common" v-if="props.dialogType === 'common'">
      <span>{{ props.message }}</span>
    </div>

    <template #footer>
      <div class="custom-modal-footer">
        <div>
          <button
              type="button"
              @click="handleClose"
              class="custom-button"
          >
            Close
          </button>
        </div>
      </div>
    </template>


  </a-modal>

</template>

<script setup lang="ts">


import {computed} from "vue";

interface Props {
  isOpen: boolean,
  title: string,
  message: string | 'none',
  width?: number,
  dialogType: 'error' | 'common',
  titlePosition: 'left' | 'center',
  isClosable: boolean
}

const props = defineProps<Props>();
const emit = defineEmits(['handleClose'])

const modalWidth = computed(() => props.width ?? 500)

const  handleClose = () => {
  emit('handleClose')
}


</script>

<style scoped>
.custom-modal-header {
  text-align: center;
  background-color: #095393;
  padding: 10px;
  margin: -20px -24px 0 -24px;
}

.custom-modal-header > .title {
  color: #ffffff;
  font-size: 20px;
}

.message-container-common {
  text-align: center;
  margin-top: 30px;
  margin-left: 20px;
  margin-right: 20px;
}

.message-container-error {
  text-align: center;
  margin: 20px;
}

.custom-modal-footer {
  text-align: center;
  background-color: #ffffff;
  padding-bottom: 20px;
  padding-top: 10px;
  margin: 0 -24px -20px -24px;
}

.custom-button {
  color: #000;
  border: 1px solid #333333;
  border-radius: 6px;
  cursor: pointer;
  width: 128px;
  background-color: #ffffff;
  font-size: 14px;
  padding: 4px 15px;
}


.custom-button:hover {
  opacity: 0.87;
  border: 2px solid blue !important;
}


</style>
<template>
    <div>
      <CToast
        :show="true"
        position="static"
        title="CToast static component"
      >
        Hello, world! This is a <b>toast</b> message.
      </CToast>
      <CButton 
        color="primary" 
        @click="addFixedToast"
      >
        click to add fixed toast!
      </CButton>
      <CToaster :autohide="3000">
        <template v-for="toast in fixedToasts">
          <CToast
            :show="true"
            header="CToast fixed component"
          >
            Hello, world! This is a <b>toast</b> number {{toast}}.
          </CToast>
        </template>
      </CToaster>
    </div>
  </template>
  <script>
  export default {
    data () {
      return {
        fixedToasts: 0
      }
    },
    methods: {
      addFixedToast () {
        this.fixedToasts++
      }
    }
  }
  </script>
<!-- <script setup>

import { CCard, CCardBody, CFormLabel } from '@coreui/vue';
import { ref,reactive } from 'vue'
const lgDemo = ref(false);
const discountType = ref(null);
let discount = reactive({
    id:null,
    name:"",
    quantity:"",
    minPrice:"",
    maxPrice:"",
    description:"",
    start:null,
    end:null,
    discountType:null,
    discountAmount:null,
    status: true,
})
let actionString = ref("New discount")
function resetData(){

}
</script> -->
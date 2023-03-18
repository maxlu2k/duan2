<script setup>
import Axios from '@/commons/Axios';
import { ref, onMounted } from 'vue';
import { useRoute } from 'vue-router';
import { cilInfo } from '@coreui/icons';
import { TodayDate } from './util';
const router = useRoute();
let data = ref({});
let user = ref({});
let visibleVerticallyCenteredScrollableDemo = ref(false);
const init = () => {
    Axios.get(`/voucher-account/${router.params.id}`).then((resp) => {
        if (resp.data.infor_response.code == 200) {
            data.value = resp.data.data;
            console.log(data.value);
            console.log(data.value.voucherAccountReq.length);
        }
    }).catch(() => {

    });
}
const infor = (username)=>{
    Axios.get(`/voucher-account/user?username=${username}`).then((resp)=>{
        console.log(resp.data);
        if(resp.data.infor_response.code == 200){
            user.value = resp.data.data;
            visibleVerticallyCenteredScrollableDemo.value = true;
        }
    }).catch((err)=>{
        alert("Có lỗi xảy ra");
    });
}
const checking = (inputData,index) => {
    console.log(inputData);
    if(inputData.active){
        Axios.post(`/voucher-account/disable`, inputData).then(
            (resp) => {
                
                if (resp.data.infor_response.code != 200) {
                    location.reload();
                    alert("Error" + resp.data.infor_response.message);
                    data.value.voucherAccountReq[index].active = !inputData.active;
                }
                else{
                    data.value.voucherAccountReq.splice(index,1,resp.data.data);
                    console.log(data.value.voucherAccountReq[index]);
                    console.log(resp.data.data);
                    
                }
            }
        ).catch(
            (error) => {
                alert("Error " + error);
            }
        );
    }
    else{
        Axios.post(`/voucher-account/save`, inputData).then(
            (resp) => {
                if (resp.data.infor_response.code != 200) {
                    alert("Error" + resp.data.infor_response.message);
                    data.value.voucherAccountReq[index].active = !inputData.active;
                }
                else{
                    data.value.voucherAccountReq.splice(index,1,resp.data.data);
                }
            }
        ).catch(
            (error) => {
                console.log(error);
                alert("Error " + error);
            }
        );
    }
}
onMounted(() => {
    init();
})

</script>
<template>
    <CRow>
        <CCol :xs="12">
            <CCard>
                <CCardHeader>
                    <h3 class="text-center text-primary">Thông tin</h3>
                </CCardHeader>
                <CCardBody>
                    <CRow>
                        <CCol :md="6">
                            <div class="mb-3 row">
                                <CFormLabel for="staticEmail" class="col-md-2 col-form-label">Name</CFormLabel>
                                <div class="col-md-10">
                                    <CFormInput type="text" id="staticEmail" :value="data.voucherReq?.name" disabled />
                                </div>
                            </div>
                        </CCol>
                        <CCol :md="6">
                            <div class="mb-3 row">
                                <CFormLabel for="staticEmail" class="col-md-2 col-form-label">Amount</CFormLabel>
                                <div class="col-md-10">
                                    <CFormInput type="text" id="staticEmail" :value="data.voucherReq?.discountType == 0 ? data.voucherReq?.discountAmount + '%':data.voucherReq?.discountAmount+ ' VND'" disabled />
                                </div>
                            </div>
                        </CCol>
                    </CRow>
                    <CRow>
                        <CCol :md="6">
                            <div class="mb-3 row">
                                <CFormLabel for="staticEmail" class="col-md-2 col-form-label">From</CFormLabel>
                                <div class="col-md-10">
                                    <CFormInput type="text" id="staticEmail" :value="TodayDate(new Date(data.voucherReq?.discountStart))" disabled />
                                </div>
                            </div>
                        </CCol>
                        <CCol :md="6">
                            <div class="mb-3 row">
                                <CFormLabel for="staticEmail" class="col-md-2 col-form-label">To</CFormLabel>
                                <div class="col-md-10">
                                    <CFormInput type="text" id="staticEmail" :value="TodayDate(new Date(data.voucherReq?.discountEnd))" disabled />
                                </div>
                            </div>
                        </CCol>
                    </CRow>
                    <CRow>
                        <CCol :md="6">
                            <div class="mb-3 row">
                                <CFormLabel for="staticEmail" class="col-md-2 col-form-label">Status</CFormLabel>
                                <div class="col-md-10">
                                    <CFormInput type="text" id="staticEmail" :value="data.voucherReq?.status?'Active':'Non-active'" readonly
                                        plain-text />
                                </div>
                            </div>
                        </CCol>

                    </CRow>
                </CCardBody>
            </CCard>

            <CCard>
                <CCardBody>
                    <CTable bordered hover>
                        <CTableHead class="text-center">
                            <CTableRow>
                                <CTableHeaderCell scope="col">#</CTableHeaderCell>
                                <CTableHeaderCell scope="col">Active</CTableHeaderCell>
                                <CTableHeaderCell scope="col">Status</CTableHeaderCell>
                                <CTableHeaderCell scope="col">Username</CTableHeaderCell>
                                <CTableHeaderCell scope="col">More</CTableHeaderCell>
                            </CTableRow>
                        </CTableHead>
                        <CTableBody  v-if="data.voucherAccountReq?.length">
                            <CTableRow v-for="(item, index) in data.voucherAccountReq" :key="index" class="text-center">
                                <CTableDataCell class="text-center">{{ index }}</CTableDataCell>
                                <CTableDataCell class="text-center" size="xxl"
                                    :class="{ 'activeableVoucher': item.active != null }">
                                    <CFormCheck :disabled="item.active === null" :checked="item.active != false"
                                        v-model="item.active" @change="checking(item,index)" />
                                </CTableDataCell>
                                <CTableDataCell>{{ item.active == null ? 'Used' : (item.active ? 'Useable' : 'non-accept')
                                }}
                                </CTableDataCell>
                                <CTableDataCell>{{ item.username }}</CTableDataCell>
                                <CTableDataCell class="text-center">
                                    <span class="outter" @click="infor(item.username)" title="infor">
                                        <CIcon :icon="cilInfo" class="action-custom" size="lg" />
                                    </span>
                                </CTableDataCell>
                            </CTableRow>
                        </CTableBody>
                    </CTable>
                </CCardBody>
                
            <CModal alignment="center"
              scrollable
              :visible="visibleVerticallyCenteredScrollableDemo"
              @close="
                () => {
                  visibleVerticallyCenteredScrollableDemo = false
                }
              "
            >
              <CModalHeader
                dismiss
                @close="
                  () => {
                    visibleVerticallyCenteredScrollableDemo = false
                  }
                "
              >
                <CModalTitle>Thông tin khách hàng</CModalTitle>
              </CModalHeader>
              <CModalBody>
                <ul>
                    <li>Username : {{ user.userName }}</li>
                    <li>Email : {{ user.email }}</li>
                    <li>Full name : {{ user.fullname }}</li>
                    <li>Number phone : {{ user.phone }}</li>
                </ul>
              </CModalBody>
              <CModalFooter>
                <CButton
                  color="secondary"
                  @click="() => {visibleVerticallyCenteredScrollableDemo = false}">
                  Close
                </CButton>
              </CModalFooter>
            </CModal>
            </CCard>
        </CCol>
    </CRow>
</template>
<style>
.outter {
    height: 40px;
}

.outter:hover {
    cursor: pointer;
    background-color: rgba(15, 51, 195, 0.1);
    opacity: 0.9;
    border-radius: 50%;
}

.outter:hover .action-custom {
    color: red;
}

.activeableVoucher:hover input {
    cursor: pointer;
}
</style>